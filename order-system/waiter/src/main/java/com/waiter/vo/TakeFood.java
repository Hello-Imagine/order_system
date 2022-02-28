package com.waiter.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TakeFood {
    private Integer tableId;
    private Integer orderId;
    private Integer foodId;
    private String foodName;
    private String image;
    private Integer status;
    private Integer delivery;
}
