package com.zpy.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@TableName("tb_history")
public class History {
    private Integer hid;
    @TableField(exist = false)
    private Worker worker;
    @TableField(exist = false)
    private Customer customer;
    private Integer workerId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sendWaterTime;
    private Integer sendWaterCount;
}
