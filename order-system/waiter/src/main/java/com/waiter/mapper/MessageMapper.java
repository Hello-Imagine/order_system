package com.waiter.mapper;

import com.waiter.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {

    List<Message> selectAllMessage(Integer receive_user);

    Message queryMessage(Integer message_id);

    void updateStatus(Integer message_id);

    String querySenderName(Integer message_id);
}
