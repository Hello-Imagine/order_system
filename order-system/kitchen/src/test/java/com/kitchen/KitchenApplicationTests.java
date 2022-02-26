package com.kitchen;

import com.kitchen.service.KitchenService;
import com.kitchen.vo.NoticeDetail;
import com.kitchen.vo.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class KitchenApplicationTests {

    @Autowired
    private KitchenService kitchenService;

    @Test
    void contextLoads() {
        OrderDetail orderDetail = kitchenService.getOrderDetail(1);
        System.out.println(orderDetail);
    }

    @Test
    void test2() {
        NoticeDetail noticeDetail = kitchenService.getNoticeDetail(1);
        System.out.println(noticeDetail);
    }

}
