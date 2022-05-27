package com.demodatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ADWeapon {
    String weapon_name;
    int weapon_count;
    int atk;
    String damage_type;
}
