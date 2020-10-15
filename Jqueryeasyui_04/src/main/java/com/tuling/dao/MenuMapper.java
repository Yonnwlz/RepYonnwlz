package com.tuling.dao;

import com.tuling.entity.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {
    //根据pid查询 节点
    @Select("select * from menu where pid=#{id}")
    public List<Menu> findFoAll(Integer id);
}
