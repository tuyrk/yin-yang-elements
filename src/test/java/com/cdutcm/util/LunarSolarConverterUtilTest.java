package com.cdutcm.util;

import com.cdutcm.BaseTest;
import com.cdutcm.util.calendarConverter.Lunar;
import com.cdutcm.util.calendarConverter.LunarSolarConverterUtil;
import com.cdutcm.util.calendarConverter.Solar;
import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/18
 * Time: 18:19 星期一
 * Description:
 */
public class LunarSolarConverterUtilTest extends BaseTest {

    @Test
    public void lunarYearToGanZhi() {

    }

    @Test
    public void LunarToSolar() {

    }

    @Test
    public void SolarToLunar() {

    }

    private String dump(Object o) {
        StringBuffer buffer = new StringBuffer();
        Class<?> oClass = o.getClass();
        if (oClass.isArray()) {
            buffer.append("[");
            for (int i = 0; i < Array.getLength(o); i++) {
                if (i > 0)
                    buffer.append(",");
                Object value = Array.get(o, i);
                buffer.append(value.getClass().isArray() ? dump(value) : value);
            }
            buffer.append("]");
        } else {
            buffer.append("{");
            while (oClass != null) {
                Field[] fields = oClass.getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    if (buffer.length() > 1)
                        buffer.append(",");
                    fields[i].setAccessible(true);
                    buffer.append(fields[i].getName());
                    buffer.append("=");
                    try {
                        Object value = fields[i].get(o);
                        if (value != null) {
                            buffer.append(value.getClass().isArray() ? dump(value)
                                    : value);
                        }
                    } catch (IllegalAccessException e) {
                    }
                }
                oClass = oClass.getSuperclass();
            }
            buffer.append("}");
        }
        return buffer.toString();
    }

    @Test
    public void doTest() {
        Solar solar = new Solar();
        solar.setSolarYear(2017);
        solar.setSolarMonth(1);
        solar.setSolarDay(4);

        System.out.println(dump(solar));
        Lunar lunar = LunarSolarConverterUtil.SolarToLunar(solar);


        System.out.println(dump(lunar));


        solar = LunarSolarConverterUtil.LunarToSolar(lunar);
        System.out.println(lunar.isIsleap());
        System.out.println(dump(solar));
        System.out.println(LunarSolarConverterUtil.lunarYearToGanZhi(2015));
    }
}
