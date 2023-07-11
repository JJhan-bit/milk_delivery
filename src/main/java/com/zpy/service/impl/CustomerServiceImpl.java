package com.zpy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.StringUtils;
import com.zpy.mapper.CustomerMapper;
import com.zpy.pojo.Customer;
import com.zpy.pojo.Worker;
import com.zpy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public PageInfo<Customer> list(Customer customer) {
        QueryWrapper<Customer>qw=new QueryWrapper<>();
        String custName = customer.getCustName();
        String custMobile = customer.getCustMobile();
        if (!StringUtils.isNullOrEmpty(custName)){
            qw.like("cust_name",custName);
        }
        if (!StringUtils.isNullOrEmpty(custMobile)){
            qw.eq("cust_mobile",custMobile);
        }
        List<Customer> listCust = customerMapper.selectList(qw);
        return new PageInfo<>(listCust);
    }

    @Override
    public int addCust(Customer customer) {
        return customerMapper.insert(customer);
    }

    @Override
    public int deleteCust(Integer id) {
        QueryWrapper<Customer>qw=new QueryWrapper<>();
        qw.eq("cid",id);
        int delete = customerMapper.delete(qw);
        return delete;
    }

    @Override
    public Customer getCustById(Integer id) {
        QueryWrapper<Customer>qw=new QueryWrapper<>();
        qw.eq("cid",id);
        Customer customer = customerMapper.selectOne(qw);
        return customer;
    }

    @Override
    public int updateCust(Customer customer) {
        Integer cid = customer.getCid();
        QueryWrapper<Customer>qw=new QueryWrapper<>();
        qw.eq("cid",cid);
        int update = customerMapper.update(customer, qw);
        return update;
    }

    @Override
    public List<Customer> queryCustomer() {
        return customerMapper.selectList(null);
    }
}
