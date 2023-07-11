package com.zpy.service.impl;

import com.github.pagehelper.PageInfo;
import com.zpy.mapper.SalaryMapper;
import com.zpy.pojo.Salary;
import com.zpy.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;
    @Override
    public PageInfo<Salary> list(Map<String, Object> map) {
        List<Salary> list = salaryMapper.list(map);
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<Salary> listAll() {
        List<Salary> salaries = salaryMapper.listAll();
        return new PageInfo<>(salaries);
    }

    @Override
    public PageInfo<Salary> listNull() {
        List<Salary> salaries = salaryMapper.listNull();
        return new PageInfo<>(salaries);
    }
}
