package com.zpy.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.zpy.mapper.HistoryMapper;
import com.zpy.pojo.History;
import com.zpy.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryMapper historyMapper;
    @Override
    public List<History> queryHistory() {
        return historyMapper.selectList(null);
    }

    @Override
    public PageInfo<History> list(Map<String, Object> map) {
        List<History> histories = historyMapper.listHistory(map);
        return new PageInfo<>(histories);
    }

    @Override
    public int addHis(History history) {
        return historyMapper.addHis(history);
    }

    @Override
    public int delete(String ids) {
        String[]split=StrUtil.split(ids,",");
        List<Integer>list=new ArrayList<>();

        for (String s : split) {
            if (!s.isEmpty()){
                int i = Integer.parseInt(s);
                list.add(i);
            }
        }
        int i = historyMapper.deleteHis(list);
        return i;
    }

    @Override
    public History getHisById(Integer id) {
        return historyMapper.getHisById(id);
    }

    @Override
    public int updateHis(History history) {
        return historyMapper.updateHis(history);
    }
}
