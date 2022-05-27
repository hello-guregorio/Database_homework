package com.demodatabase.operate;

import com.demodatabase.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OtherOperate {
    public static void delDeadCharacter() throws SQLException {
        try(Connection connection= DbUtil.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement
                    ps=connection.prepareStatement("" +
                    "delete characters from characters,advanced where characters.id=advanced.id and advanced.res_name='源石'");
            ps.execute();
            ps=connection.prepareStatement("delete from advanced where res_name='源石'");
            ps.execute();
            ps=connection.prepareStatement("delete from resources where res_name='源石'");
            ps.execute();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            DbUtil.getConnection().rollback();
            throw new RuntimeException(e);
        }
    }

}
