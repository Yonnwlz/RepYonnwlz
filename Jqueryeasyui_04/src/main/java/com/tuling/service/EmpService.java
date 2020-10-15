package com.tuling.service;

import com.tuling.entity.EasyUiDataGrid;
import com.tuling.entity.Emp;

public interface EmpService {
    /**
     * 分页查询
     * @param curPage  当前页数
     * @param pageSize  当前最大条数
     * @return
     */
    public EasyUiDataGrid findAllEmp(Integer curPage,Integer pageSize);

    /**
     * 添加员工
     * @param emp
     * @return
     */
    public Integer addEmp(Emp emp);

    /**
     * 修改员工
     * @param emp
     * @return
     */
    public Integer updateEmp(Emp emp);

    /**
     * 删除员工
     * @param
     * @return
     */
    public Integer delEmp(Integer empNo);
}
