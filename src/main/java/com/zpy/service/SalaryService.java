package com.zpy.service;

import com.github.pagehelper.PageInfo;
import com.zpy.pojo.Salary;

import java.util.List;
import java.util.Map;

public interface SalaryService {

    PageInfo<Salary>list(Map<String,Object> map);

    PageInfo<Salary>listAll();

    PageInfo<Salary>listNull();
}
