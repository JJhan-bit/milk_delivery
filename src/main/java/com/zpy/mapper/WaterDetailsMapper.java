package com.zpy.mapper;

import com.zpy.pojo.WaterDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterDetailsMapper {
    List<WaterDetails>list(String workerName);
}
