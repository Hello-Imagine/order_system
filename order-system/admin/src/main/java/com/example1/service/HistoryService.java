package com.example1.service;

import com.example1.vo.HistoryFood;
import com.example1.vo.HistorySale;
import com.example1.vo.HistoryWaiter;

import java.util.List;

public interface HistoryService {

    List<HistoryFood> showTopFood();

    List<HistoryWaiter> showTopWaiter();

    Integer todaySales();

    List<HistorySale> saleNum(String start, String end);

    List<HistorySale> sales(String start, String end);
}
