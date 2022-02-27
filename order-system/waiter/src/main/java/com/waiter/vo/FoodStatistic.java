package com.waiter.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FoodStatistic {
    private String foodName;
    private String description;
    private Integer category;
    private Float price;
    private Integer isLike;
}
