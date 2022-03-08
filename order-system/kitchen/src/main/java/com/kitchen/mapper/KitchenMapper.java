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

    /**
     * 插入消息, 更少的字段
     * @param message 消息
     */
    void addMessage(Message message);

    /**
     * 根据 orderId 获取菜品详细信息头
     * @param orderId orderId
     * @return 菜品详细信息头
     */
    OrderDetailTitle getOrderDetailTitle(int orderId);

    /**
     * 根据订单号获取菜品列表
     * @param orderId orderId
     * @return 菜品列表
     */
    List<FoodDetail> getFoodDetail(int orderId);

    /**
     * 根据 userId 获取公告详细信息
     * @param userId userId
     * @return 通知公告信息
     */
    NoticeDetail getNoticeDetail(int userId);

    /**
     * 根据 userId 获取公告列表
     * @param userId userId
     * @return 公告列表
     */
    List<Notice> getNotice(int userId);

    /**
     * 将公告设置为已读
     * @param noticeId noticeId
     * @param userId userId
     */
    void setNoticeRead(int noticeId, int userId);

    /**
     * 设置菜品的烹饪状态
     * @param orderId orderId
     * @param foodId foodId
     * @param status status
     */
    void setFoodStatus(int orderId, int foodId, int status);

    /**
     * 获取所有的 orderId
     * @return orderId 列表
     */
    List<Integer> getOrderId();

    /**
     * 获取所有的服务员 id
     * @return 服务员 id 列表
     */
    List<Integer> getWaiterId();

    /**
     * 根据订单号获取订单负责的服务员 id
     * @param orderId orderId
     * @return 服务员 id
     */
    Integer getWaiterIdByOrderId(int orderId);

    /**
     * 插入后厨通知服务员消息
     * @param message 消息
     * @return 插入成功或者失败
     */
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
