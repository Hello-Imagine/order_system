package com.waiter.service.impl;

import com.waiter.entity.Message;
import com.waiter.mapper.MessageMapper;
import com.waiter.mapper.NoticeMapper;
import com.waiter.service.MessageService;
import com.waiter.vo.MessageDetails;
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
    public MessageDetails messagedetails(Integer message_id) {
        //拿到后厨名字
        String senderName = messageMapper.querySenderName(message_id);
        //拿到message
        Message message = messageMapper.queryMessage(message_id);
        //创建返回结果
        MessageDetails messageDetails = new MessageDetails();
        messageDetails.setMessageId(message.getMessageId());
        messageDetails.setOrderId(message.getOrderId());
        messageDetails.setTitle(message.getTitle());
        messageDetails.setContent(message.getContent());
        messageDetails.setCreateTime(message.getCreateTime());
        messageDetails.setSendUser(message.getSendUser());
        messageDetails.setReceiveUser(message.getReceiveUser());
        messageDetails.setStatus(message.getStatus());
        messageDetails.setSenderName(senderName);

        return messageDetails;
    }

    @Override
    public void changeStatus(Integer message_id) {
        messageMapper.updateStatus(message_id);
    }
}
