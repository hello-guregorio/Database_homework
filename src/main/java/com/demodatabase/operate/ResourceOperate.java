package com.demodatabase.operate;

import com.demodatabase.entity.Resource;
import com.demodatabase.utils.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResourceOperate {
    public static void addResource(Resource resource){
        try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(
                "insert into resources values (?,?,?)")) {
            ps.setString(1,resource.getRes_name());
            ps.setString(2,resource.getRarity_name());
            ps.setInt(3,resource.getCount());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int updateResourceCount(String resourceName,int change){
        try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(
                "update resources set count=count+"+change+" where res_name=?")) {
            ps.setString(1,resourceName);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static int delResource(String resourceName){
        try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(
                "delete from resources where res_name= \'"+resourceName+"\'")) {
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Resource getResource(String resourceName){
        Resource resource;
        try(ResultSet resultSet=DbUtil.getStatement().executeQuery(
                "select * from resources where res_name= \'"+resourceName+"\'")) {
            if(!resultSet.next()){
                return null;
            }
            String name=resultSet.getString("res_name");
            String rarity=resultSet.getString("rarity");
            int count=resultSet.getInt("count");
            resource=new Resource(name,rarity,count);
            return resource;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
