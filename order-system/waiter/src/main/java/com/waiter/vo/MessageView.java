package com.waiter.vo;

import com.waiter.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageView {
    private Integer userId;
    private String userName;
    private Integer role;
    private String portrait;
    private String senderName;
    private List<MessageDetails> messages;
}
