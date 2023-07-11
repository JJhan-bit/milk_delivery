package com.zpy.service;

import com.github.pagehelper.PageInfo;
import com.zpy.pojo.History;

import java.util.List;
import java.util.Map;

public interface HistoryService {
    //查询所有
    List<History>queryHistory();

    //查询所有带分页
    PageInfo<History>list(Map<String,Object>map);

    //添加
    int addHis(History history);

    //删除
    int delete(String ids);

    //根据id获取History对象
    History getHisById(Integer id);

    //修改
    int updateHis(History history);
}
