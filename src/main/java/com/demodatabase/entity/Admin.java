package com.demodatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Admin {
    int id;
    String username;
    String password;
    String nickname;
}
