package com.zpy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.PageInfo;
import com.zpy.pojo.History;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface HistoryMapper extends BaseMapper<History> {
    List<History>listHistory(Map<String,Object>map);

    int addHis(History history);

    int deleteHis(List<Integer>ids);

    //根据id获取History对象
    History getHisById(Integer id);

    //修改
    int updateHis(History history);

}
