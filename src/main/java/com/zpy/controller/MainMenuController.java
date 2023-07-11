package com.zpy.controller;

import com.zpy.pojo.MainMenu;
import com.zpy.service.HistoryService;
import com.zpy.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("main")
public class MainMenuController {
    @Autowired
    private HistoryService historyService;
    @Autowired
    private WorkerService workerService;

    @RequestMapping("mainMenu")
    public List<MainMenu>list(){
        List<MainMenu>list=new ArrayList<>();

        Map<Integer,Integer>map=new HashMap<>();

        historyService.queryHistory().forEach(h -> {
            map.put(h.getWorkerId(),map.getOrDefault(h.getWorkerId(),0)+h.getSendWaterCount());
        });

        workerService.queryWorker().forEach(w -> {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setWorkerName(w.getWorkerName());
            mainMenu.setSendWaterCount(map.get(w.getWid())==null?0:map.get(w.getWid()));
            list.add(mainMenu);
        });

        Collections.sort(list,(o1,o2)->{
            if (o1.getSendWaterCount()>o2.getSendWaterCount()){
                return -1;
            }else if (o1.getSendWaterCount()<o2.getSendWaterCount()){
                return 1;
            }else {
                return 0;
            }
        });

        if (list.size()<12){
            return list;
        }

        List<MainMenu>arrList=new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            arrList.add(list.get(i));
        }
        return arrList;
    }
}
