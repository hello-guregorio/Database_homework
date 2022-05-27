package com.demodatabase.operate;

import com.demodatabase.entity.DefWeapon;
import com.demodatabase.utils.DbUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DefWeaponOperate {
    public static void addDefWeapon(DefWeapon defWeapon){
        try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(
                "insert into def_weapon values (?,?,?,?)")) {
            ps.setString(1,defWeapon.getWeapon_name());
            ps.setInt(2,defWeapon.getWeapon_count());
            ps.setInt(3,defWeapon.getArmor());
            ps.setInt(4,defWeapon.getMagic_resist());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void delDefWeaponWeapon(String weaponName){
        try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(
                "delete from def_weapon where weapon_name= \'"+weaponName+"\'")) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
