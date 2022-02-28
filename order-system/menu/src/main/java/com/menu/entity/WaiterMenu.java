package com.menu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WaiterMenu {

    private Integer id;
    private String name;
    private Integer parentId;

    private List<WaiterMenu> children;

}
