package com.waiter.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NoticeView {
    private Integer userId;
    private String userName;
    private Integer role;
    private String portrait;
    private String password;
    private List<NoticeList> notice;
}
