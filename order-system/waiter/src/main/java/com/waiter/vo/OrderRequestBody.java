package com.waiter.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class test {
    private Integer userId;
    private Integer tableId;
    private Integer numPeople;
    private String memo;
    private Float totalPrice;

    private List<OrderView> orderViews;
}
