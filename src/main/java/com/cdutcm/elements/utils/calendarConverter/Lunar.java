package com.cdutcm.elements.utils.calendarConverter;

import lombok.Data;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/18
 * Time: 18:11 星期一
 * Description:
 */
@Data
public class Lunar {
    private boolean isLeap;
    private int lunarDay;
    private int lunarMonth;
    private int lunarYear;
    int[] years = {1583, 1585, 1588, 1591, 1594, 1596, 1599};

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(lunarYear).append("-");
        if (isLeap) {
            sb.append("闰");
        }
        if (lunarMonth < 10) {
            sb.append("0");
        }
        sb.append(lunarMonth).append("-");
        if (lunarDay < 10) {
            sb.append("0");
        }
        sb.append(lunarDay);
        return sb.toString();
    }

    public Lunar() {
    }

    public Lunar(int lunarYear, int lunarMonth, int lunarDay) {
        this.lunarYear = lunarYear;
        this.lunarMonth = lunarMonth;
        this.lunarDay = lunarDay;
        int i = 0;
        for (; i < years.length; i++) {
            if ((lunarYear - years[i]) % 19 == 0) {
                this.isLeap = true;
                break;
            }
        }
        if (i >= years.length) {
            this.isLeap = false;
        }
    }
}
