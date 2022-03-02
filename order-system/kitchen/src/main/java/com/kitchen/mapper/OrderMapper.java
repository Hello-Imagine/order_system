package com.kitchen.mapper;

import com.kitchen.entity.TOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<TOrder> selectUnfinished(List<Integer> order_id);

    List<Integer> selectOrderId();

    List<TOrder> selectFinished(List<Integer> unfinished);
}
