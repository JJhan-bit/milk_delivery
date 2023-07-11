package com.zpy.mapper;

import com.zpy.pojo.Salary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SalaryMapper {
    List<Salary>list(Map<String,Object>map);

    List<Salary>listAll();

    List<Salary>listNull();
}
