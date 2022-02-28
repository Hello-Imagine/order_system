package com.menu.service;

import com.menu.entity.WaiterMenu;
import com.menu.vo.JsonResponse;

import java.util.List;

public interface MenuService {

    JsonResponse<List<WaiterMenu>> getWaiterMenu();

}
