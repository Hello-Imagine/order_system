package com.example1.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HistoryWaiter {
    private String userName;
    Integer userId;
    Integer sales;
    Float percent;
}
