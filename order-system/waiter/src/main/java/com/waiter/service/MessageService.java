package com.waiter.service;

import com.waiter.entity.Message;
import com.waiter.vo.MessageView;

public interface MessageService {
    public MessageView showMessage(Integer receive_user);

    public Message messagedetails(Integer message_id);

    void changeStatus(Integer message_id);
}
