package com.kitchen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private int userId;
    private String password;
    private String username;
    private String portrait;
    private int role;
    private String phone;
    private double salary;
    private double bonus;

}
