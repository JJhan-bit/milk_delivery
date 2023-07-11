package com.zpy.service;

import com.github.pagehelper.PageInfo;
import com.zpy.pojo.Customer;
import com.zpy.pojo.Worker;

import java.util.List;

public interface CustomerService {
    PageInfo<Customer>list(Customer customer);
    //添加
    int addCust(Customer customer);

    //删除
    int deleteCust(Integer id);

    //根据id获取customer对象
    Customer getCustById(Integer id);

    //更新
    int updateCust(Customer customer);

    //查询所有不带分页
    List<Customer>queryCustomer();
}
