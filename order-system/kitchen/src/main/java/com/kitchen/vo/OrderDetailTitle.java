package com.kitchen.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetailTitle {

    private int orderId;
    private int tableId;
    private String username;
    private int userId;
    private String memo;

}
