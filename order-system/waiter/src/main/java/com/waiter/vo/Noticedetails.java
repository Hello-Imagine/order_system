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
public class Noticedetails {
    private int noticeId;
    private String title;
    private String content;
    private Date createTime;
    private int status;
}
