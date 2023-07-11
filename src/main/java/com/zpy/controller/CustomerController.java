package com.zpy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zpy.pojo.Customer;
import com.zpy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("cust")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //分页实现
    @RequestMapping("listCust")
    public String list(@RequestParam(required = false,defaultValue = "1",value = "pageNum") Integer pageNum,
                       @RequestParam(required = false,defaultValue = "10",value = "pageSize") Integer pageSize, Model model, Customer customer) {
        if (pageNum <= 0 || pageNum.equals("") || pageNum == null) {
            pageNum = 1;
        }
        if (pageSize <= 0 || pageSize.equals("") || pageSize == null) {
            pageSize = 10;
        }
            PageHelper.startPage(pageNum, pageSize);
            PageInfo<Customer> pageInfo = customerService.list(customer);
            model.addAttribute("pageInfo", pageInfo);
            return "customerList";
    }

    //跳转 增添
    @RequestMapping("preSaveCust")
    public String preSave(){
        return "custSave";
    }

    //insert
    @RequestMapping("saveCust")
    public String save(Customer customer){
        int i = customerService.addCust(customer);
        return "redirect:/cust/listCust";
    }

    //delete
    @RequestMapping("delCust/{id}")
    public String delete(@PathVariable Integer id){
        int i = customerService.deleteCust(id);
        return "redirect:/cust/listCust";
    }

    //跳转 更新
    @RequestMapping("preUpdateCust/{id}")
    public String preUpdate(@PathVariable Integer id,Model model){
        Customer customer = customerService.getCustById(id);
        model.addAttribute("customer",customer);
        return "customerUpdate";
    }

    //更新
    @PostMapping("updateCust")
    public String update(Customer customer){
        int i = customerService.updateCust(customer);
        return "redirect:/cust/listCust";
    }
}
