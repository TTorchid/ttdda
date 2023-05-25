package com.sugar.dda.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sugar.dda.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
