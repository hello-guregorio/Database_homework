package com.demodatabase.operate;

import com.demodatabase.entity.Character;
import com.demodatabase.utils.DbUtil;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CharactersOperate {
    public static void addCharacter(Character character){
        try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(
                    "insert into characters(job_name, weapon_name, name, sex, atk, def, damage_type, level) values (?,?,?,?,?,?,?,?)")) {
            ps.setString(1,character.getJob_name());
            ps.setString(2,character.getWeapon_name());
            ps.setString(3,character.getName());
            ps.setString(4,character.getSex());
            ps.setInt(5,character.getAtk());
            ps.setInt(6,character.getDef());
            ps.setString(7,character.getDamage_type());
            ps.setInt(8,character.getLevel());
            ps.executeUpdate();
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static int delCharacter(String characterName){
        try{
            CallableStatement proc=DbUtil.getConnection().prepareCall("call GameDatabase.checkValid(\'"+characterName+"\')");
            return proc.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Character getCharacter(int characterId){
        try(ResultSet resultSet=DbUtil.getStatement().executeQuery(
                "select * from characters where id= \'"+characterId+"\'")) {
            resultSet.next();
            int id=resultSet.getInt("id");
            String job_name=resultSet.getString("job_name");
            String weapon_name=resultSet.getString("weapon_name");
            String name=resultSet.getString("name");
            String sex= resultSet.getString("sex");
            int atk=resultSet.getInt("atk");
            int def=resultSet.getInt("def");
            String damage_type=resultSet.getString("damage_type");
            int level=resultSet.getInt("level");
            return new Character(id,job_name,weapon_name,name,sex,atk,def,damage_type,level);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateCharacterLevel(Character character, int level){
        try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(
                "update characters set level=characters.level+"+level+" where name=?")) {
            ps.setString(1,character.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
