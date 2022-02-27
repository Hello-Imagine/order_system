package com.waiter.service;

import com.waiter.entity.Notice;
import com.waiter.vo.NoticeView;
import com.waiter.vo.Noticedetails;

import java.util.List;

public interface NoticeService {

    public NoticeView showNotice(Integer user_id);

    public Noticedetails noticedetails(Integer notice_id);

    void changeStatus(Integer notice_id);
}
