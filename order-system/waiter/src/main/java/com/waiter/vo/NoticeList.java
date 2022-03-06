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
public class NoticeList {
    private int noticeId;
    private String title;
    private int status;
    private String content;
    private Date createTime;
}
