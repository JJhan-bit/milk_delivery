package com.zpy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class WaterDetails {
    private String workerName;
    private String workerImage;
    private String custDetails;
    private String custAddress;
    private int sendWaterCount;
}
