package com.example1.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderView {
    private Integer orderId;
    private Integer userId;
    private Integer tableId;
    private Float totalPrice;
    private String memo;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime finishTime;
    private Integer numPeople;

    //主要是多了这个服务员姓名
    private String username;
}
