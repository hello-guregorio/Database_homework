package com.demodatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefWeapon {
    String weapon_name;
    int weapon_count;
    int armor;
    int magic_resist;
}
