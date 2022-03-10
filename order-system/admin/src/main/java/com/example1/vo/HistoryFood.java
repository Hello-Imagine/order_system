package com.example1.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HistoryFood {
    private String foodName;
    Integer foodId;
    Integer sales;
    Float percent;
}
