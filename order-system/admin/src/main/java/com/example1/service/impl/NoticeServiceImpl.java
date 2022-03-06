package com.example1.service.impl;

import com.example1.entity.Notice;
import com.example1.mapper.NoticeMapper;
import com.example1.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public void sendNotice(String title, String content) {

        //记录当前系统时间作为create_time
        Date create_time = new Date();
        //插入新公告
        Notice notice = new Notice();
        notice.setContent(content);
        notice.setTitle(title);
        notice.setCreateTime(create_time);

        noticeMapper.insertNotice(notice);

        //拿到自增的notice_id
        Integer notice_id = notice.getNoticeId();
        System.out.println(notice_id);
        //查询所有的user(除了管理员)的user_id 注意notice_user表中的user_id是接收人的id
        //所以需要对所有人都创建一个关联表项
        List<Integer> userList = noticeMapper.queryOtherUser();

        //创建关联表notice_user status初始化为0
        for(Integer user_id : userList){
            noticeMapper.insertNoticeUser(notice_id, user_id);
        }
    }
}
