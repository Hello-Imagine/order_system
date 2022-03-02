package com.waiter.mapper;

import com.waiter.entity.Message;
import com.waiter.vo.MessageDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {

    List<MessageDetails> selectAllMessage(Integer receive_user);

    Message queryMessage(Integer message_id);

    void updateStatus(Integer message_id);

    String querySenderName(Integer message_id);

}
