package com.waiter.service.impl;

import com.waiter.entity.Message;
import com.waiter.mapper.MessageMapper;
import com.waiter.mapper.NoticeMapper;
import com.waiter.service.MessageService;
import com.waiter.vo.MessageView;
import com.waiter.vo.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class                  MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;
    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public MessageView showMessage(Integer receive_user) {
        MessageView messageView = new MessageView();
        UserDetails userDetails = noticeMapper.queryUser(receive_user);
        List<Message> messages = messageMapper.selectAllMessage(receive_user);

        messageView.setMessages(messages);

        messageView.setUserId(userDetails.getUserId());
        messageView.setUserName(userDetails.getUserName());
        messageView.setRole(userDetails.getRole());
        messageView.setPortrait(userDetails.getPortrait());
        messageView.setPassword(userDetails.getPassword());
        return messageView;
    }

    @Override
    public Message messagedetails(Integer message_id) {
        Message message = messageMapper.queryMessage(message_id);
        return message;
    }
}
