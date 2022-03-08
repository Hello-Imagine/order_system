package com.kitchen.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.kitchen.entity.Food;
import com.kitchen.entity.Message;
import com.kitchen.mapper.KitchenMapper;
import com.kitchen.service.KitchenService;
import com.kitchen.util.GoEasyUtil;
import com.kitchen.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KitchenServiceImpl implements KitchenService {
    @Autowired
    private KitchenMapper kitchenMapper;

    @Override
    public Map<String, String> postMessage(Map<String, String> data) {
        Message message = new Message();
        message.setTitle(data.get("title"));
        message.setContent(data.get("content"));
        message.setOrderId(Integer.parseInt(data.get("order_id")));
        message.setCreateTime(new Date(Long.parseLong(data.get("create_time"))));

        kitchenMapper.addMessage(message);

        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");

        return map;
    }

    @Override
    public OrderDetail getOrderDetail(int orderId) {
        OrderDetailTitle orderDetailTitle = kitchenMapper.getOrderDetailTitle(orderId);
        List<FoodDetail> foodDetails = kitchenMapper.getFoodDetail(orderId);
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setFood(foodDetails);
        orderDetail.setOrderId(orderDetailTitle.getOrderId());
        orderDetail.setMemo(orderDetailTitle.getMemo());
        orderDetail.setTableId(orderDetailTitle.getTableId());
        orderDetail.setUsername(orderDetailTitle.getUsername());
        orderDetail.setUserId(orderDetailTitle.getUserId());
        return orderDetail;
    }

    @Override
    public JsonResponse<OrderDetail> getOrderDetail(Map<String, String> data) {
        int orderId = Integer.parseInt(data.get("order_id"));
        OrderDetailTitle orderDetailTitle = kitchenMapper.getOrderDetailTitle(orderId);
        List<FoodDetail> foodDetails = kitchenMapper.getFoodDetail(orderId);
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setFood(foodDetails);
        orderDetail.setOrderId(orderDetailTitle.getOrderId());
        orderDetail.setMemo(orderDetailTitle.getMemo());
        orderDetail.setTableId(orderDetailTitle.getTableId());
        orderDetail.setUsername(orderDetailTitle.getUsername());
        orderDetail.setUserId(orderDetailTitle.getUserId());

        JsonResponse<OrderDetail> response = new JsonResponse<>();
        response.setCode(1);
        response.setMsg("成功");
        response.setData(orderDetail);
        return response;
    }

    @Override
    public NoticeDetail getNoticeDetail(int userId) {
        NoticeDetail noticeDetail = kitchenMapper.getNoticeDetail(userId);
        List<Notice> notice = kitchenMapper.getNotice(userId);
        noticeDetail.setNotices(notice);
        return noticeDetail;
    }

    @Override
    public JsonResponse<NoticeDetail> getNotice(Map<String, String> data) {
        JsonResponse<NoticeDetail> response = new JsonResponse<>();

        int userId = Integer.parseInt(data.get("user_id"));
        NoticeDetail noticeDetail = kitchenMapper.getNoticeDetail(userId);
        List<Notice> notice = kitchenMapper.getNotice(userId);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Notice notice1 : notice) {
            notice1.setCreateTimeStr(simpleDateFormat.format(notice1.getCreateTime()));
        }

        noticeDetail.setNotices(notice);

        response.setData(noticeDetail);
        response.setCode(1);
        response.setMsg("成功");
        return response;
    }

    @Override
    public JsonResponse<Object> setNoticeRead(Map<String, String> data) {
        int noticeId = Integer.parseInt(data.get("notice_id"));
        int userId = Integer.parseInt(data.get("user_id"));
        kitchenMapper.setNoticeRead(noticeId, userId);

        JsonResponse<Object> response = new JsonResponse<>();
        response.setCode(1);
        response.setMsg("成功");
        response.setData(null);
        return response;
    }

    @Override
    public JsonResponse<Object> setFoodStatus(Map<String, String> data) {
        int orderId = Integer.parseInt(data.get("order_id"));
        int foodId = Integer.parseInt(data.get("food_id"));
        int status = Integer.parseInt(data.get("status"));
        int tableId = Integer.parseInt(data.get("table_id"));
        kitchenMapper.setFoodStatus(orderId, foodId, status);

        // 建立长连接, 实时传菜消息到微信小程序前端
        // 根据订单编号获取服务员信息
        int userId = kitchenMapper.getUserIdByOrderId(orderId);
        // 获取 FoodId, image
        Food food = kitchenMapper.getFoodByFoodId(foodId);
        // channel 内容 jsonString
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tableId", tableId);
        jsonObject.put("orderId", orderId);
        jsonObject.put("foodId", foodId);
        jsonObject.put("foodName", food.getFoodName());
        jsonObject.put("image", food.getImage());
        jsonObject.put("status", 1);
        // 发送实时消息
        GoEasyUtil.publish(userId + "dishPass", jsonObject.toJSONString());

        JsonResponse<Object> response = new JsonResponse<>();
        response.setCode(1);
        response.setMsg("成功");
        response.setData(null);
        return response;
    }

    @Override
    public JsonResponse<OrderId> getOrderId() {
        List<Integer> orderIds = kitchenMapper.getOrderId();
        OrderId orderId = new OrderId(orderIds);

        JsonResponse<OrderId> response = new JsonResponse<>();
        response.setCode(1);
        response.setMsg("成功");
        response.setData(orderId);
        return response;
    }

    @Override
    public JsonResponse<WaiterId> getWaiterId() {
        List<Integer> waiterIds = kitchenMapper.getWaiterId();
        WaiterId waiterId = new WaiterId(waiterIds);

        JsonResponse<WaiterId> response = new JsonResponse<>();
        response.setCode(1);
        response.setMsg("成功");
        response.setData(waiterId);
        return response;
    }

    @Override
    public JsonResponse<Integer> getWaiterIdByOrderId(Map<String, String> data) {
        int orderId = Integer.parseInt(data.get("user_id"));
        Integer waiterId = kitchenMapper.getWaiterIdByOrderId(orderId);

        JsonResponse<Integer> response = new JsonResponse<>();
        response.setCode(1);
        response.setMsg("成功");
        response.setData(waiterId);
        return response;
    }

    @Override
    public JsonResponse<Object> getMessage(Map<String, String> data) {
        Message message = new Message();
        message.setTitle(data.get("title"));
        message.setContent(data.get("content"));
        message.setOrderId(Integer.parseInt(data.get("order_id")));
        message.setCreateTime(new Date(Long.parseLong(data.get("create_time"))));
        message.setSendUser(Integer.parseInt(data.get("send_user")));
        message.setReceiveUser(Integer.parseInt(data.get("receive_user")));
        message.setStatus(0);

        kitchenMapper.insertMessage(message);
        int messageId = message.getMessageId();
//        System.out.println(messageId);

        // 建立长连接, 通知服务员后厨消息
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("messageId", messageId);
        jsonObject.put("orderId", message.getOrderId());
        jsonObject.put("title", message.getTitle());
        jsonObject.put("content", message.getContent());
        jsonObject.put("createTime", message.getCreateTime());
        jsonObject.put("sendUser", message.getSendUser());
        jsonObject.put("receiveUser", message.getReceiveUser());
        jsonObject.put("status", message.getStatus());
        jsonObject.put("senderName", kitchenMapper.getUserNameByUserId(message.getSendUser()));
        GoEasyUtil.publish(data.get("receive_user") + "message", jsonObject.toJSONString());

        JsonResponse<Object> response = new JsonResponse<>();
        response.setCode(1);
        response.setMsg("成功");
        response.setData(null);
        return response;
    }
}
