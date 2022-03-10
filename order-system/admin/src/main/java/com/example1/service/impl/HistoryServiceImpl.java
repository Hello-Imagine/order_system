package com.example1.service.impl;

import com.example1.mapper.HistoryMapper;
import com.example1.service.HistoryService;
import com.example1.vo.HistoryFood;
import com.example1.vo.HistorySale;
import com.example1.vo.HistoryWaiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    HistoryMapper historyMapper;

    @Override
    public List<HistoryFood> showTopFood() {
        //找到菜品总销量 方便后面得到percent
        Integer totalSale = historyMapper.selectTotalFoodSales();
        return historyMapper.selectTopFood(totalSale);
    }

    @Override
    public List<HistoryWaiter> showTopWaiter() {
        //找到服务员总销量 方便后面得到percent
        Integer totalSale = historyMapper.selectTotalWaiterSales();
        return historyMapper.selectTopWaiter(totalSale);
    }

    @Override
    public Integer todaySales(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = format.format(date);
        Integer todaySale = historyMapper.selectTodaySale(today);
//        System.out.println(today);
//        System.out.println(todaySale);
        return todaySale;
    }

    @Override
    public List<HistorySale> saleNum(String start, String end) {
        return historyMapper.selectSaleNum(start,end);
    }

    @Override
    public List<HistorySale> sales(String start, String end) {
        return historyMapper.selectSales(start,end);
    }
}
