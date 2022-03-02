package com.menu.controller;

import com.menu.entity.WaiterMenu;
import com.menu.service.MenuService;
import com.menu.vo.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menu/waiter")
    public JsonResponse<List<WaiterMenu>> waiterNotice() {
        return menuService.getWaiterMenu();
    }

    @GetMapping("/menu/administrator")
    public JsonResponse<List<WaiterMenu>> getAdministratorMenu() {
        return menuService.getAdministratorMenu();
    }

    @GetMapping("/menu/kitchen")
    public JsonResponse<List<WaiterMenu>> getKitchenMenu() {
        return menuService.getKitchenMenu();
    }

}
