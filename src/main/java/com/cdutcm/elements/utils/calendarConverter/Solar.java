package com.cdutcm.elements.utils.calendarConverter;

import lombok.Data;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/18
 * Time: 18:45 星期一
 * Description:
 */
@Data
public class Solar {
    private int solarDay;
    private int solarMonth;
    private int solarYear;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(solarYear).append("-");
        if (solarMonth < 10) {
            sb.append("0");
        }
        sb.append(solarMonth).append("-");
        if (solarDay < 10) {
            sb.append("0");
        }
        sb.append(solarDay);
        return sb.toString();
    }

    public Solar() {
    }

    public Solar(int solarYear, int solarMonth, int solarDay) {
        this.solarDay = solarDay;
        this.solarMonth = solarMonth;
        this.solarYear = solarYear;
    }
}
