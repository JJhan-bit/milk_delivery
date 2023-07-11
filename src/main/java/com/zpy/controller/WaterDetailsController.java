package com.zpy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zpy.pojo.WaterDetails;
import com.zpy.service.WaterDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/stat")
public class WaterDetailsController {
    @Autowired
    private WaterDetailsService waterDetailsService;
    @RequestMapping("/statWaterDetails")
    public String list(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                       @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize, Model model,String workerName){
        if (pageNum<=0||pageNum.equals("")||pageNum==null){
            pageNum=1;
        }
        if (pageSize<=0||pageSize.equals("")||pageSize==null){
            pageSize=10;
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<WaterDetails> list = waterDetailsService.list(workerName);
        model.addAttribute("pageInfo",list);
        return "waterDetailsList";
    }
}
