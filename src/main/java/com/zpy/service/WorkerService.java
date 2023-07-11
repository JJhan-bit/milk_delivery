package com.zpy.service;

import com.github.pagehelper.PageInfo;
import com.zpy.pojo.Worker;

import java.util.List;

public interface WorkerService {
    //查询所有
    List<Worker> queryWorker();

    //查询所有带分页
    PageInfo<Worker>list(Worker worker);

    //添加
    int addWorker(Worker worker);

    //根据id获取Worker对象
    Worker getWorkerById(Integer id);

    //修改
    int updateWorker(Worker worker);

    //修改薪资
    int updateSalary(Integer wid,String workerSalary);

}
