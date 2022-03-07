package com.example1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TOrder {
    private Integer orderId;
    private Integer userId;
    private Integer tableId;
    private Float totalPrice;
    private String memo;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime finishTime;
    private Integer numPeople;
}
