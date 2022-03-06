package com.example1.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//创建公告时 前端发给后端的请求
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeRequest {
    String title;
    String content;
}
