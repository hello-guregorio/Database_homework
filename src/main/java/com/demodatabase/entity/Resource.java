package com.demodatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Resource {
    String res_name;
    String rarity_name;
    int count;

    public Resource(String res_name, String rarity_name){
        this.res_name=res_name;
        this.rarity_name=rarity_name;
    }
}
