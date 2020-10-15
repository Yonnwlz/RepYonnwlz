package com.tuling.service.impl;

import com.tuling.entity.Attributes;
import com.tuling.entity.Menu;
import com.tuling.dao.MenuMapper;
import com.tuling.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuService_impl implements MenuService {
    //注入Menu Mapper
    @Resource
    private MenuMapper menuMapper;
    
    @Override
    public List<Menu> selectMenuAll(Integer id) {
        //查询所有根节点
        List<Menu> foAll = menuMapper.findFoAll(id);
        return nodeSouAll(foAll);
    }

    //通过跟节点查询所有子节点
    public List<Menu> nodeSouAll(List<Menu> list){
        //遍历根节点
        for (Menu m:list) {
            //根据根节点编号  查询子节点
            List<Menu> foAll = menuMapper.findFoAll(m.getId());
            //把子节点存入根节点属性中
            m.setChildren(foAll);
            Attributes attr = new Attributes();
            attr.setUrl(m.getUrl());
            attr.setIcon(m.getIcon());
            m.setAttributes(attr);
            //判断是否有子节点
            if(foAll.size()>0){
                //如果有子节点  就递归
                nodeSouAll(foAll);
            }
        }
        return list;
    }
}
