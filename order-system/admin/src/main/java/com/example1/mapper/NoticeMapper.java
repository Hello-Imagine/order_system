package com.example1.mapper;

import com.example1.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface NoticeMapper {

    Integer insertNotice(Notice notice);

    void insertNoticeUser(Integer notice_id, Integer user_id);

    List<Integer> queryOtherUser();
}
