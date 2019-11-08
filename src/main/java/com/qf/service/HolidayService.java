package com.qf.service;


import com.qf.pojo.Holiday;

import java.util.List;

public interface HolidayService {

    public int addHoliday(Holiday holiday, String teaName);

    public int updateHoliday(int hid,int state,String uname);

    public List<Holiday> getHolidayListBySid(int sid);

    public List<Holiday> getApproveHolidayList(String teaName);



}
