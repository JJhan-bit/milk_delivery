package com.zpy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zpy.pojo.Customer;
import com.zpy.pojo.History;
import com.zpy.pojo.Worker;
import com.zpy.service.CustomerService;
import com.zpy.service.HistoryService;
import com.zpy.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private CustomerService customerService;

    //分页实现
    @RequestMapping("/listHis")
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
        PageInfo<History> list = historyService.list(map);
        model.addAttribute("pageInfo",list);
        return "historyList";
    }

    //跳转 save 回写
    @RequestMapping("preSaveHis")
    public String preAddHis(Model model){
        List<Worker> workers = workerService.queryWorker();
        List<Customer> customers = customerService.queryCustomer();
        model.addAttribute("custList",customers);
        model.addAttribute("workerList",workers);
        return "historySave";

    }

    //save
    @PostMapping("saveHis")
    public String addHis(Integer workerId,Integer custId,History history){
        Worker worker = new Worker();
        worker.setWid(workerId);
        Customer customer = new Customer();
        customer.setCid(custId);
        history.setWorker(worker);
        history.setCustomer(customer);
        int i = historyService.addHis(history);
        return "redirect:/history/listHis";
    }

    //batch delete
    @RequestMapping("batchDeleteHistory")
    @ResponseBody
    public String delete(String idList){
        int delete = historyService.delete(idList);
        if (delete>0){
            return "OK";
        }else {
            return "error";
        }
    }

    //跳转 更新 回写
    @RequestMapping("preUpdateHis/{id}")
    public String preUpdate(@PathVariable Integer id,Model model){
        History history = historyService.getHisById(id);
        List<Worker> workers = workerService.queryWorker();
        List<Customer> customers = customerService.queryCustomer();
        model.addAttribute("workerList",workers);
        model.addAttribute("custList",customers);
        model.addAttribute("history",history);
        return "historyUpdate";
    }

    //更新
    @PostMapping("updateHis")
    public String update(Integer workerId,Integer custId,History history){
        Worker worker = new Worker();
        Customer customer = new Customer();
        worker.setWid(workerId);
        customer.setCid(custId);
        history.setCustomer(customer);
        history.setWorker(worker);
        int i = historyService.updateHis(history);
        return "redirect:/history/listHis";
    }
}
