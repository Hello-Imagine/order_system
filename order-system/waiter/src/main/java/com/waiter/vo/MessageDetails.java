package com.waiter.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageDetails {
    private Integer messageId;
    private Integer orderId;
    private String title;
    private String content;
    private Date createTime;
    private Integer sendUser;
    private Integer receiveUser;
    private Integer status;
    private String senderName;
}
