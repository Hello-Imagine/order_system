package com.example1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FoodOrder {

    private Integer orderId;

    private Integer foodId;

    private Integer numFood;

    private Integer status;
}
