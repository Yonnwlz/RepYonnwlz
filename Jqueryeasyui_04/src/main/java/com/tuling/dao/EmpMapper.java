package com.tuling.dao;

import com.tuling.entity.Emp;
import com.tuling.entity.EmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EmpMapper {
    long countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(Integer empno);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    /**
     * 分页
     * @param curPage 当前页数
     * @param pageSize 当前有几条
     * @return
     */
    @Select("select * from emp LIMIT #{curPage},#{pageSize}")
    public List<Emp> findCurEmpAll(Integer curPage, Integer pageSize);

    /**
     * 总条数
     * @return
     */
    @Select("select count(*) from emp")
    public Integer findEmpCount();
}