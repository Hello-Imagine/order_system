package com.kitchen.mapper;

import com.kitchen.entity.Message;
import com.kitchen.vo.FoodDetail;
import com.kitchen.vo.Notice;
import com.kitchen.vo.NoticeDetail;
import com.kitchen.vo.OrderDetailTitle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KitchenMapper {

    void addMessage(Message message);

    OrderDetailTitle getOrderDetailTitle(int orderId);

    List<FoodDetail> getFoodDetail(int orderId);

    NoticeDetail getNoticeDetail(int userId);

    List<Notice> getNotice(int userId);

    void setNoticeRead(int noticeId, int userId);

    void setFoodStatus(int orderId, int foodId, int status);

    List<Integer> getOrderId();
    List<Integer> getWaiterId();
    Integer getWaiterIdByOrderId(int orderId);

    void insertMessage(Message message);

}
