package com.cdutcm.model;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/18
 * Time: 18:37 星期一
 * Description:
 */
public class Birth {
    /**
     * 出生日期
     */
    private String date;
    /**
     * 出生 时
     */
    private String hour;
    /**
     * 出生 分
     */
    private String minute;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }
}
