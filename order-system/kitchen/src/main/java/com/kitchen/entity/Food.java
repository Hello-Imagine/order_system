package com.kitchen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Food {

    private int foodId;
    private String foodName;
    private String description;
    private int category;
    private double price;
    private String image;
    private int isLike;
    private int isAvailable;
    private int sales;

}
