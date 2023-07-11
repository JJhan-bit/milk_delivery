package com.zpy.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("tb_customer")
@Data
public class Customer {
    private Integer cid;
    private String custName;
    private String custMobile;
    private String custAddress;
    private Integer custTicket;

}
