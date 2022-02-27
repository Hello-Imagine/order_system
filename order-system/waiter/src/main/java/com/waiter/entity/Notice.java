package com.waiter.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notice {
    private int noticeId;
    private String title;
    private String content;
    private Date createTime;
}
