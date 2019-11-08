package com.qf.service.impl;

import com.qf.mapper.HolidayMapper;
import com.qf.pojo.Holiday;
import com.qf.service.HolidayService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    private HolidayMapper holidayMapper;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Override
    public int addHoliday(Holiday holiday, String teaName) {
        holidayMapper.addHoliday(holiday);
        HashMap<String, Object> map = new HashMap<>();
        map.put("stuName", holiday.getUser().getUsername());
        map.put("teaName", teaName);
        runtimeService.startProcessInstanceByKey("holiday", holiday.getHid() + "", map);
        Task task = taskService.createTaskQuery().taskAssignee(holiday.getUser().getUsername()).singleResult();
        taskService.complete(task.getId());
        return holiday.getHid();
    }

    @Override
    public int updateHoliday(int hid, int state, String teaName) {
        Task task = taskService.createTaskQuery().processInstanceBusinessKey(hid + "").taskAssignee(teaName).singleResult();
        taskService.complete(task.getId());
        return holidayMapper.updateHolidayState(hid, state);
    }

    @Override
    public List<Holiday> getHolidayListBySid(int sid) {
        return holidayMapper.getHolidayListBySid(sid);
    }

    @Override
    public List<Holiday> getApproveHolidayList(String teaName) {
        List<Task> list = taskService.createTaskQuery().taskAssignee(teaName).list();
        ArrayList<String> businessKeys = new ArrayList<>();
        for (Task task : list) {
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
            businessKeys.add(processInstance.getBusinessKey());
        }
        List<Holiday> approveHolidayByHid = null;
        if (businessKeys.size() != 0) {
            approveHolidayByHid = holidayMapper.getApproveHolidayByHid(businessKeys);
        }
        return approveHolidayByHid;
    }

}
