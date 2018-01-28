package com.cdutcm.util.calendarConverter;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/18
 * Time: 18:11 星期一
 * Description:
 */
public class Lunar {
    private boolean isleap;
    private int lunarDay;
    private int lunarMonth;
    private int lunarYear;
    int[] years = {1583, 1585, 1588, 1591, 1594, 1596, 1599};

    public Lunar() {
    }

    public Lunar(int lunarYear, int lunarMonth, int lunarDay) {
        this.lunarYear = lunarYear;
        this.lunarMonth = lunarMonth;
        this.lunarDay = lunarDay;
        int i = 0;
        for (; i < years.length; i++) {
            if ((lunarYear - years[i]) % 19 == 0) {
                this.isleap = true;
                break;
            }
        }
        if (i >= years.length) {
            this.isleap = false;
        }
    }

    public boolean isIsleap() {
        return isleap;
    }

    public void setIsleap(boolean isleap) {
        this.isleap = isleap;
    }

    public int getLunarDay() {
        return lunarDay;
    }

    public void setLunarDay(int lunarDay) {
        this.lunarDay = lunarDay;
    }

    public int getLunarMonth() {
        return lunarMonth;
    }

    public void setLunarMonth(int lunarMonth) {
        this.lunarMonth = lunarMonth;
    }

    public int getLunarYear() {
        return lunarYear;
    }

    public void setLunarYear(int lunarYear) {
        this.lunarYear = lunarYear;
    }
}
