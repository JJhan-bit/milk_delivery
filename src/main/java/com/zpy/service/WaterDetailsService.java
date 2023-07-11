package com.zpy.service;

import com.github.pagehelper.PageInfo;
import com.zpy.pojo.WaterDetails;

public interface WaterDetailsService {
    PageInfo<WaterDetails>list(String workerName);
}
