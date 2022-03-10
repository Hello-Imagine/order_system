package com.example1.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HistorySale {

    Date time;
    //销售额
    String sales;
    //销售量
    String nums;
}
