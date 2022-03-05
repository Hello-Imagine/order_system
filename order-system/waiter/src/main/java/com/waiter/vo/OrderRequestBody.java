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
//确认点单 传给后台的对象
public class OrderRequestBody {
    private Integer userId;
    private Integer tableId;
    private Integer numPeople;
    private String memo;
    private Float totalPrice;

    private List<OrderView> orderViews;
}
