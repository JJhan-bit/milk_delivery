package com.zpy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.StringUtils;
import com.zpy.mapper.WorkerMapper;
import com.zpy.pojo.Worker;
import com.zpy.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerMapper workerMapper;
    @Override
    public List<Worker> queryWorker() {
        return workerMapper.selectList(null);
    }

    @Override
    public PageInfo<Worker> list(Worker worker) {
        String workerName = worker.getWorkerName();
        QueryWrapper<Worker>qw=new QueryWrapper<>();
        if (!StringUtils.isNullOrEmpty(workerName)){
            qw.like("worker_name",workerName);
        }
        List<Worker> workers = workerMapper.selectList(qw);
        return new PageInfo<>(workers);
    }

    @Override
    public int addWorker(Worker worker) {
        return workerMapper.insert(worker);
    }

    @Override
    public Worker getWorkerById(Integer id) {
        QueryWrapper<Worker>qw=new QueryWrapper<>();
        qw.eq("wid",id);
        Worker worker = workerMapper.selectOne(qw);
        return worker;
    }

    @Override
    public int updateWorker(Worker worker) {
        Integer wid = worker.getWid();
        QueryWrapper<Worker>qw=new QueryWrapper<>();
        qw.eq("wid",wid);
        int update = workerMapper.update(worker, qw);
        return update;
    }

    @Override
    public int updateSalary(Integer wid, String workerSalary) {
        QueryWrapper<Worker>qw=new QueryWrapper<>();
        qw.eq("wid",wid);
        Worker worker = workerMapper.selectOne(qw);
        worker.setWorkerSalary(workerSalary);
        int update = workerMapper.update(worker, qw);
        return update;

    }
}
