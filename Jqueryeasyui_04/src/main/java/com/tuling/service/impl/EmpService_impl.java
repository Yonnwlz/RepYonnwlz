package com.tuling.service.impl;

import com.tuling.entity.EasyUiDataGrid;
import com.tuling.entity.Emp;
import com.tuling.dao.EmpMapper;
import com.tuling.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmpService_impl implements EmpService {
    //注入empMapper
    @Resource
    private EmpMapper empMapper;

    @Override
    public EasyUiDataGrid findAllEmp(Integer curPage, Integer pageSize) {
        EasyUiDataGrid easyui = new EasyUiDataGrid();
        easyui.setTotal(empMapper.findEmpCount());
        easyui.setRows(empMapper.findCurEmpAll((curPage-1)*pageSize,pageSize));
        return easyui;
    }

    @Override
    public Integer addEmp(Emp emp) {
        return empMapper.insert(emp);
    }

    @Override
    public Integer updateEmp(Emp emp) {
        return empMapper.updateByPrimaryKeySelective(emp);
    }

    @Override
    public Integer delEmp(Integer empNo) {
        return empMapper.deleteByPrimaryKey(empNo);
    }
}
