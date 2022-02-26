package com.kitchen.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetail {

    private int orderId;
    private int tableId;
    private String username;
    private int userId;
    private String memo;

    private List<FoodDetail> food;

}
