package com.example1.mapper;

import com.example1.vo.HistoryFood;
import com.example1.vo.HistorySale;
import com.example1.vo.HistoryWaiter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HistoryMapper {
    List<HistoryFood> selectTopFood(Integer totalSale);

    Integer selectTotalFoodSales();

    Integer selectTotalWaiterSales();

    List<HistoryWaiter> selectTopWaiter(Integer totalSale);

    Integer selectTodaySale(String today);

    List<HistorySale> selectSaleNum(String start, String end);

    List<HistorySale> selectSales(String start, String end);
}
