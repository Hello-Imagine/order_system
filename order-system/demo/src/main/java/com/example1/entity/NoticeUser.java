package com.example1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NoticeUser {

    private Integer noticeId;

    private Integer userId;

    private Integer status;
}
