package com.zpy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zpy.pojo.Salary;
import com.zpy.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @RequestMapping("/searchCalcSalay")
    public String list(@RequestParam(required = false,value = "pageNum",defaultValue = "1")Integer pageNum,
                       @RequestParam(required = false,value = "pageSize",defaultValue = "10")Integer pageSize, Model model,
                       @RequestParam Map<String,Object>map){
        if (pageNum<=0||pageNum.equals("")||pageNum==null){
            pageNum=1;
        }
        if (pageSize<=0||pageSize.equals("")||pageSize==null){
            pageSize=10;
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Salary> list = salaryService.list(map);
        model.addAttribute("pageInfo",list);
        return "salaryList";
    }

    @RequestMapping("/searchSalay")
    public String listAll(@RequestParam(required = false,value = "pageNum",defaultValue = "1")Integer pageNum,
                       @RequestParam(required = false,value = "pageSize",defaultValue = "10")Integer pageSize, Model model){
        if (pageNum<=0||pageNum.equals("")||pageNum==null){
            pageNum=1;
        }
        if (pageSize<=0||pageSize.equals("")||pageSize==null){
            pageSize=10;
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Salary> list = salaryService.listAll();
        model.addAttribute("pageInfo",list);
        return "salaryList";
    }
    @RequestMapping("/IsNullWorker")
    public String listNull(@RequestParam(required = false,value = "pageNum",defaultValue = "1")Integer pageNum,
                          @RequestParam(required = false,value = "pageSize",defaultValue = "10")Integer pageSize, Model model){
        if (pageNum<=0||pageNum.equals("")||pageNum==null){
            pageNum=1;
        }
        if (pageSize<=0||pageSize.equals("")||pageSize==null){
            pageSize=10;
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Salary> list = salaryService.listNull();
        model.addAttribute("pageInfo",list);
        return "salaryList";
    }


}
