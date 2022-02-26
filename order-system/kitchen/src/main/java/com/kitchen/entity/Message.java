package com.kitchen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {

    private int messageId;
    private int orderId;
    private String title;
    private String content;
    private Date createTime;
    private int sendUser;
    private int receiveUser;
    private int status;

}
