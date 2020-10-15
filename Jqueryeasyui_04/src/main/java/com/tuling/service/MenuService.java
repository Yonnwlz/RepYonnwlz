package com.tuling.service;

import com.tuling.entity.Menu;

import java.util.List;

public interface MenuService {
    /**
     * 查询所有节点
     * @param id
     * @return
     */
    public List<Menu> selectMenuAll(Integer id);
}
