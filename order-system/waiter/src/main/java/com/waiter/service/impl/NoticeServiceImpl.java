package com.waiter.service.impl;

import com.waiter.entity.Notice;
import com.waiter.mapper.NoticeMapper;
import com.waiter.service.NoticeService;
import com.waiter.vo.NoticeList;
import com.waiter.vo.NoticeView;
import com.waiter.vo.Noticedetails;
import com.waiter.vo.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public NoticeView showNotice(Integer user_id) {
        NoticeView noticeView = new NoticeView();
        UserDetails userDetails = noticeMapper.queryUser(user_id);
        List<NoticeList> noticeLists = noticeMapper.selectAllNotice(user_id);

        noticeView.setNotice(noticeLists);

        noticeView.setUserId(userDetails.getUserId());
        noticeView.setUserName(userDetails.getUserName());
        noticeView.setRole(userDetails.getRole());
        noticeView.setPortrait(userDetails.getPortrait());
        noticeView.setPassword(userDetails.getPassword());
        return noticeView;
    }

    @Override
    public Noticedetails noticedetails(Integer notice_id) {
        Noticedetails noticedetails = noticeMapper.queryNotice(notice_id);
        //同时把该notice的状态变成已读
        noticeMapper.updateStatus(notice_id);
        return noticedetails;
    }

    @Override
    public void changeStatus(Integer notice_id) {
        noticeMapper.updateStatus(notice_id);
    }


}
