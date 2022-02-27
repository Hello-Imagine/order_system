package com.waiter.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetails {
    private Integer userId;
    private String userName;
    private Integer role;
    private String portrait;
    private String password;
}
