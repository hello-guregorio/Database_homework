package com.demodatabase.operate;

import com.demodatabase.entity.View;
import com.demodatabase.utils.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewOperate {
    public static ArrayList<View> getView(int id){
        ArrayList<View> arrayList=new ArrayList<>();
        try(PreparedStatement ps= DbUtil.getConnection().prepareStatement(
                "select * from use_resource_info where id=?"
        )){
            ps.setInt(1,id);
            ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()){
                String name= resultSet.getString(2);
                String res_name=resultSet.getString(3);
                String rarity=resultSet.getString(4);
                arrayList.add(new View(id,name,res_name,rarity));
            }
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
