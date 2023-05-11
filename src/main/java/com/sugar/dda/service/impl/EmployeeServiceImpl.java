package com.sugar.dda.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sugar.dda.entit.Employee;
import com.sugar.dda.mapper.EmployeeMapper;
import com.sugar.dda.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    public void test(){

    }
}
