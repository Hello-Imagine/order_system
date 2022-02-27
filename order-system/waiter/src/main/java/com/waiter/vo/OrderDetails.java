package com.waiter.vo;

import com.waiter.entity.TOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetails {
    private TOrder tOrder;
    private List<FoodStatistic> foodList;
}
