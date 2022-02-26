package com.kitchen.service;

import com.kitchen.vo.*;

import java.util.Map;

public interface KitchenService {
    Map<String, String> postMessage(Map<String, String> data);

    OrderDetail getOrderDetail(int orderId);
    JsonResponse<OrderDetail> getOrderDetail(Map<String, String> data);

    NoticeDetail getNoticeDetail(int userId);

    JsonResponse<NoticeDetail> getNotice(Map<String, String> data);

    JsonResponse<Object> setNoticeRead(Map<String, String> data);

    JsonResponse<Object> setFoodStatus(Map<String, String> data);

    JsonResponse<OrderId> getOrderId();

    JsonResponse<WaiterId> getWaiterId();
    JsonResponse<Integer> getWaiterIdByOrderId(Map<String, String> data);

    JsonResponse<Object> getMessage(Map<String, String> data);
}
