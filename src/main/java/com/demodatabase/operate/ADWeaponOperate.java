package com.demodatabase.operate;

import com.demodatabase.entity.ADWeapon;
import com.demodatabase.entity.Job;
import com.demodatabase.utils.DbUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ADWeaponOperate {
    public static void addADWeapon(ADWeapon adWeapon){
        try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(
                "insert into ad_weapon values (?,?,?,?)")) {
            ps.setString(1,adWeapon.getWeapon_name());
            ps.setInt(2,adWeapon.getWeapon_count());
            ps.setInt(3,adWeapon.getAtk());
            ps.setString(4,adWeapon.getDamage_type());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void delADWeaponWeapon(String weaponName){
        try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(
                "delete from ad_weapon where weapon_name= \'"+weaponName+"\'")) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
