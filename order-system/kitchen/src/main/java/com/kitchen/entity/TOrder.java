package com.kitchen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TOrder {

    private int orderId;
    private int userId;
    private int tableId;
    private int totalPrice;
    private String memo;
    private int status;
    private Date createTime;
    private Date finishTime;
    private int numPeople;

}
