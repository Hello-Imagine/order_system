package com.waiter.service;

import com.waiter.entity.Message;
import com.waiter.vo.MessageDetails;
import com.waiter.vo.MessageView;

public interface MessageService {
    MessageView showMessage(Integer receive_user);

    MessageDetails messagedetails(Integer message_id);

    void changeStatus(Integer message_id);
}
