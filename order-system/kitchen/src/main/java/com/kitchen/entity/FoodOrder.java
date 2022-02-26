package com.kitchen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FoodOrder {

    private int orderId;
    private int foodId;
    private int numFood;
    private int status;

}
