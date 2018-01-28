package com.cdutcm.util.calendarConverter;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/18
 * Time: 18:45 星期一
 * Description:
 */
public class Solar {
    private int solarDay;
    private int solarMonth;
    private int solarYear;

    public Solar() {
    }

    public Solar(int solarYear, int solarMonth, int solarDay) {
        this.solarDay = solarDay;
        this.solarMonth = solarMonth;
        this.solarYear = solarYear;
    }

    public int getSolarDay() {
        return solarDay;
    }

    public void setSolarDay(int solarDay) {
        this.solarDay = solarDay;
    }

    public int getSolarMonth() {
        return solarMonth;
    }

    public void setSolarMonth(int solarMonth) {
        this.solarMonth = solarMonth;
    }

    public int getSolarYear() {
        return solarYear;
    }

    public void setSolarYear(int solarYear) {
        this.solarYear = solarYear;
    }
}
