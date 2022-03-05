package com.waiter.service;

import com.waiter.vo.NoticeView;
import com.waiter.vo.Noticedetails;

public interface NoticeService {

    NoticeView showNotice(Integer user_id);

    Noticedetails noticedetails(Integer notice_id, Integer user_id);

    void changeStatus(Integer notice_id, Integer user_id);
}
