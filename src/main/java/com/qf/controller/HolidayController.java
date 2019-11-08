package com.qf.controller;


import com.qf.pojo.Holiday;
import com.qf.pojo.User;
import com.qf.service.HolidayService;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HolidayController {

//春风十里不如你，一见钟情就是你！
    @Autowired
    private UserService userService;

    @Autowired
    private HolidayService holidayService;

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("login")
    public String login() {
        return "login";
    }
    /**
     * 登录的servlet
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("goLogin")
    public String goLogin(User user, HttpSession session) {
        User user1 = userService.userLogin(user);
        if (user1 == null) {
            return "redirect:fail";
        }
        String position = user.getPosition();
        if (position.equals("teacher")) {
            session.setAttribute("teacher", user1);
        } else {
            session.setAttribute("student", user1);
        }
        return "index";
    }
    /**
     * 跳转到登录失败页面
     * @return
     */
    @RequestMapping("fail")
    public String fail() {
        return "fail";
    }

    /**
     * 跳转到添加页面
     * @param request
     * @return
     */
    @RequestMapping("addHoliday")
    public String addHoliday(HttpServletRequest request) {
        List<User> teacherList = userService.getTeacherList();
        request.setAttribute("teacherList", teacherList);
        return "holiday";
    }

    /**
     * 添加假条的servlet
     * @param holiday
     * @param teaName
     * @param session
     * @return
     */
    @RequestMapping("saveHoliday")
    public String saveHoliday(Holiday holiday, String teaName, HttpSession session) {
        User user = (User) session.getAttribute("student");
        holiday.setUser(user);
        holidayService.addHoliday(holiday, teaName);
        return "redirect:addHoliday";
    }

    /**
     * 跳转到我的假条页面
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("fakeStrip")
    public String fakeStrip(HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("student");
        List<Holiday> holidayListBySid = holidayService.getHolidayListBySid(user.getUid());
        request.setAttribute("holidayList", holidayListBySid);
        return "myFakeStrip";
    }

    /**
     * 老师获取所有代办申请
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("getApproveHolidays")
    public String getApproveHolidays(HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("teacher");
        List<Holiday> holidayList = holidayService.getApproveHolidayList(user.getUsername());
        request.setAttribute("holidayList", holidayList);
        return "approveHolidays";
    }

    /**
     * 更新申请状态
     * @param hid
     * @param session
     * @return
     */
    @RequestMapping("updateHoliday")
    public String updateHoliday(int hid, HttpSession session) {
        User user = (User) session.getAttribute("teacher");
        holidayService.updateHoliday(hid, 1, user.getUsername());
        return "redirect:getApproveHolidays";
    }

}
