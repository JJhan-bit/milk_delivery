package com.zpy.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("tb_worker")
public class Worker {
    private Integer wid;
    private String workerName;
    private String workerSalary;
    private String workerMoney;
    private String workerImage;

    public Worker() {
    }

    public Worker(Integer wid, String workerName, String workerSalary, String workerMoney, String workerImage) {
        this.wid = wid;
        this.workerName = workerName;
        this.workerSalary = workerSalary;
        this.workerMoney = workerMoney;
        this.workerImage = workerImage;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerSalary() {
        return workerSalary;
    }

    public void setWorkerSalary(String workerSalary) {
        this.workerSalary = workerSalary;
    }

    public String getWorkerMoney() {
        return workerMoney;
    }

    public void setWorkerMoney(String workerMoney) {
        this.workerMoney = workerMoney;
    }

    public String getWorkerImage() {
        return workerImage;
    }

    public void setWorkerImage(String workerImage) {
        this.workerImage = workerImage;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "wid=" + wid +
                ", workerName='" + workerName + '\'' +
                ", workerSalary='" + workerSalary + '\'' +
                ", workerMoney='" + workerMoney + '\'' +
                ", workerImage='" + workerImage + '\'' +
                '}';
    }
}
