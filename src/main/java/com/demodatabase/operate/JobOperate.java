package com.demodatabase.operate;

import com.demodatabase.entity.Job;
import com.demodatabase.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JobOperate {
    public static void addJob(Job job){
        try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(
                "insert into job values (?,?)")) {
            ps.setString(1,job.getJob_name());
            ps.setString(2,job.getProfiling());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
