package com.waiter.mapper;

import com.waiter.entity.Notice;
import com.waiter.vo.NoticeList;
import com.waiter.vo.Noticedetails;
import com.waiter.vo.UserDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<NoticeList> selectAllNotice(Integer user_id);

    UserDetails queryUser(Integer user_id);

    Noticedetails queryNotice(Integer notice_id);
}
