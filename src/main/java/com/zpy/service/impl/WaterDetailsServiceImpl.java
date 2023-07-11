package com.zpy.service.impl;

import com.github.pagehelper.PageInfo;
import com.zpy.mapper.WaterDetailsMapper;
import com.zpy.pojo.WaterDetails;
import com.zpy.service.WaterDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterDetailsServiceImpl implements WaterDetailsService {

    @Autowired
    private WaterDetailsMapper waterDetailsMapper;

    @Override
    public PageInfo<WaterDetails> list(String workerName) {
        List<WaterDetails> list = waterDetailsMapper.list(workerName);
        return new PageInfo<>(list);

    }
}
