package com.tuling.controller;

import com.tuling.entity.EasyUiDataGrid;
import com.tuling.entity.Emp;
import com.tuling.entity.Menu;
import com.tuling.service.EmpService;
import com.tuling.service.MenuService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MyController {
    //注入service menu层
    @Autowired
    private MenuService menuService;

    //注入service emp层
    @Autowired
    private EmpService empService;

    @RequestMapping("nodeSouAll")
    @ResponseBody
    public List<Menu> nodeSouAll(){
        //调用查询所有节点方法
        List<Menu> menus = menuService.selectMenuAll(0);
        return menus;
    }

    @RequestMapping("tabsAll")
    @ResponseBody
    public EasyUiDataGrid tabsAll(@RequestParam(defaultValue = "2",name = "page") Integer curPage, @RequestParam(defaultValue = "2",name = "rows") Integer pageSize){
        return  empService.findAllEmp(curPage,pageSize);
    }

    @RequestMapping("addEmp")
    @ResponseBody
    public String addEmp(Emp emp){
        Integer integer = empService.addEmp(emp);
        return integer>0?"success":"1";
    }

    @RequestMapping("updateEmp")
    @ResponseBody
    public String updateEmp(Emp emp){
        Integer integer = empService.updateEmp(emp);
        return integer>0?"success":"1";
    }

    @RequestMapping("delEmp")
    @ResponseBody
    public String delEmp(Integer empno){
        Integer integer = empService.delEmp(empno);
        return integer>0?"success":"1";
    }
}
