package com.demodatabase.operate;

import com.demodatabase.entity.ADWeapon;
import com.demodatabase.entity.Character;
import com.demodatabase.entity.Weapon;
import com.demodatabase.utils.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WeaponOperate {
    public static void addWeapon(Weapon weapon){
        try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(
                "insert into weapons values (?,?)")) {
            ps.setString(1,weapon.getWeapon_name());
            ps.setInt(2,weapon.getWeapon_count());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static int delWeapon(String weaponName){
        try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(
                "delete from weapons where weapon_name= \'"+weaponName+"\'")) {
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateWeaponCount(Weapon weapon, int change){
        try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(
                "update weapons set weapon_count=weapons.weapon_count+"+change+" where weapon_name=?")) {
            ps.setString(1,weapon.getWeapon_name());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Character> getWhoEquipped(String weaponName){
        ArrayList<Character> arrayList=new ArrayList<>();
        try(PreparedStatement ps=DbUtil.getConnection().prepareStatement(
                "select * from characters natural join weapons where weapon_name=?"
        )){
            ps.setString(1,weaponName);
            ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String job_name=resultSet.getString("job_name");
                String weapon_name=resultSet.getString("weapon_name");
                String name=resultSet.getString("name");
                String sex= resultSet.getString("sex");
                int atk=resultSet.getInt("atk");
                int def=resultSet.getInt("def");
                String damage_type=resultSet.getString("damage_type");
                int level=resultSet.getInt("level");
                arrayList.add(new Character(id,job_name,weapon_name,name,sex,atk,def,damage_type,level));
            }
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
