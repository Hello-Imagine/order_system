package com.kitchen.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FoodDetail {

    private int foodId;
    private String foodName;
    private int numFood;
    private int status;

}
