package com.qf.pojo;

public class Holiday {

    private int hid;
    private String startDate;
    private String endDate;
    private String reason;
    private int state;
    private User user;

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Holiday(int hid, String startDate, String endDate, String reason, int state, User user) {
        this.hid = hid;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.state = state;
        this.user = user;
    }

    public Holiday(String startDate, String endDate, String reason, int state, User user) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.state = state;
        this.user = user;
    }

    public Holiday() {
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "hid=" + hid +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", reason='" + reason + '\'' +
                ", state=" + state +
                ", user=" + user +
                '}';
    }
}
