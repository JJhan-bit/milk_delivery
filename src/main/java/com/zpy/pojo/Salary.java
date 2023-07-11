package com.zpy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Salary {

    /**
     * 送牛奶工名称
     */
    private String workerName;
    /**
     * 送牛奶工底薪
     */
    private Integer workerSalary;

    /**
     * 送牛奶工提成
     */
    private Double workerMoney;

    /**
     * 送牛奶数量
     */
    private Integer sendWaterCount;

    /**
     * 实发工资
     */
    private Double finalSalary;
}
