package com.example1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Food {
    private Integer foodId;

    private String foodName;

    private String description;

    private Integer category;

    private Float price;

    private String image;

    private Boolean isLike;

    private Boolean isAvailable;

    private Boolean sales;
}
