package com.demodatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Character {
    int id;
    String job_name;
    String weapon_name;
    String name;
    String sex;
    int atk;
    int def;
    String damage_type;
    int level;

    public Character(String job_name, String weapon_name, String name, String sex, int atk, int def, String damage_type, int level) {
        this.job_name = job_name;
        this.weapon_name = weapon_name;
        this.name = name;
        this.sex = sex;
        this.atk = atk;
        this.def = def;
        this.damage_type = damage_type;
        this.level = level;
    }
}
