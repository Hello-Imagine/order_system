package com.menu.mapper;

import com.menu.entity.WaiterMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<WaiterMenu> getRootWaiterNoticeMenu();
    List<WaiterMenu> getAllWaiterNoticeMenu();

}
