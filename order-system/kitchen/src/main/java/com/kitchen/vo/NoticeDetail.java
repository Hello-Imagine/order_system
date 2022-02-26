package com.kitchen.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NoticeDetail {

    private int userId;
    private String username;
    private String portrait;

    private List<Notice> notices;

}
