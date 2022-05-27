package com.demodatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class View {
    int id;
    String name;
    String resource_name;
    String rarity;
}
