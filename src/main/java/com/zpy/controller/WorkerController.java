package com.zpy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mult;
import com.zpy.pojo.Worker;
import com.zpy.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

@Controller
@RequestMapping("worker")
public class WorkerController {
    @Value("${location}")
    private String location;
    @Autowired
    private WorkerService workerService;

    @RequestMapping("workerList")
    public String list(@RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                       @RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize, Model model, Worker worker){
        if (pageNum<=0||pageNum.equals("")||pageNum==null){
            pageNum=1;
        }
        if (pageSize<=0||pageSize.equals("")||pageSize==null){
            pageSize=10;
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Worker> list = workerService.list(worker);
        model.addAttribute("pageInfo",list);
        return "workerList";
    }

    @RequestMapping("preSaveWorker")
    public String preAdd(){
        return "workerSave";
    }

    @PostMapping("workerSave")
    public String add(Worker worker, MultipartFile file){
        transFile(worker,file);
        int i = workerService.addWorker(worker);
        return "redirect:/worker/workerList";
    }

    private void transFile(Worker worker, MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);
        String prefix =System.nanoTime()+"";
        String path=prefix+suffix;
        File file1 = new File(location);
        if (!file1.exists()){
            file1.mkdirs();
        }
        File file2 = new File(file1,path);
        try {
            file.transferTo(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        worker.setWorkerImage(path);
    }

    @RequestMapping("preUpdateWorker/{id}")
    public String preUpdate(@PathVariable Integer id,Model model){
        Worker worker = workerService.getWorkerById(id);
        model.addAttribute("worker",worker);
        return "workerUpdate";
    }

    @RequestMapping("/updateWorker")
    public String update(Worker worker, MultipartFile file){
        transFile(worker,file);
        int i = workerService.updateWorker(worker);
        return "redirect:/worker/workerList";
    }

    @PostMapping("addSalary")
    @ResponseBody
    public String updateSalary(Integer wid,String workerSalary){
        int i = workerService.updateSalary(wid, workerSalary);
        if (i>0){
            return "OK";
        }else {
            return "error";
        }
    }
}
