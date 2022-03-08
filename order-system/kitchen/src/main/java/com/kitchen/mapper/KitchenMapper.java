package com.kitchen.mapper;

import com.kitchen.entity.Food;
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

    int insertMessage(Message message);

    /**
     * 根据订单 id 获取服务员 id
     * @param orderId 订单 id
     * @return 服务员 id
     */
    int getUserIdByOrderId(int orderId);

    /**
     * 根据 foodId 获取菜品详细信息
     * @param foodId foodId
     * @return 菜品详细信息
     */
    Food getFoodByFoodId(int foodId);

    /**
     * 根据 userId 获取用户名称
     * @return 用户名称
     */
    String getUserNameByUserId(int userId);

}
