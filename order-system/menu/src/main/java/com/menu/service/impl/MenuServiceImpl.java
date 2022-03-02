package com.menu.service.impl;

import com.menu.entity.WaiterMenu;
import com.menu.mapper.MenuMapper;
import com.menu.service.MenuService;
import com.menu.vo.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public JsonResponse<List<WaiterMenu>> getWaiterMenu() {
        List<WaiterMenu> root = menuMapper.getRootWaiterNoticeMenu();
        List<WaiterMenu> waiterMenus = menuMapper.getAllWaiterNoticeMenu();
        for (WaiterMenu waiterMenu : root) {
            List<WaiterMenu> children = getChildren(waiterMenu, waiterMenus);
            waiterMenu.setChildren(children);
        }
        return JsonResponse.success(root);
    }

    @Override
    public JsonResponse<List<WaiterMenu>> getAdministratorMenu() {
        List<WaiterMenu> root = menuMapper.getAdministratorMenu();
        List<WaiterMenu> administratorMenus = menuMapper.getAllAdministratorMenu();
        for (WaiterMenu waiterMenu : root) {
            List<WaiterMenu> children = getChildren(waiterMenu, administratorMenus);
            waiterMenu.setChildren(children);
        }
        return JsonResponse.success(root);
    }

    @Override
    public JsonResponse<List<WaiterMenu>> getKitchenMenu() {
        List<WaiterMenu> root = menuMapper.getKitchenMenu();
        List<WaiterMenu> waiterMenus = menuMapper.getAllKitchenMenu();
        for (WaiterMenu waiterMenu : root) {
            List<WaiterMenu> children = getChildren(waiterMenu, waiterMenus);
            waiterMenu.setChildren(children);
        }
        return JsonResponse.success(root);
    }

    private List<WaiterMenu> getChildren(WaiterMenu waiterMenu, List<WaiterMenu> waiterMenus) {
        List<WaiterMenu> children = new ArrayList<>();
        for (WaiterMenu waiterMenu2 : waiterMenus) {
            if (waiterMenu2.getParentId().equals(waiterMenu.getId())) {
                children.add(waiterMenu2);
            }
        }
        for (WaiterMenu waiterMenu2 : children) {
            waiterMenu2.setChildren(getChildren(waiterMenu2, waiterMenus));
        }
        return children;
    }
}
