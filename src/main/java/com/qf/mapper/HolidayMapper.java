package com.qf.mapper;

import com.qf.pojo.Holiday;

import java.util.List;

public interface HolidayMapper {

    public int addHoliday(Holiday holiday);

    public int updateHolidayState(int hid, int state);

    public List<Holiday> getHolidayListBySid(int sid);

    public List<Holiday> getApproveHolidayByHid(List<String> hid);

}
