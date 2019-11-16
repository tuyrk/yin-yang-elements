package com.cdutcm.elements.utils;

import java.util.Arrays;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/6/6 9:32 星期三
 * Description:
 */
public class Test {
    public static void main(String[] args) {
        String[] horoscopes = {
                "戊寅戊午戊申甲寅",
                "己卯丙子戊午壬子",
                "庚辰戊寅壬辰庚戌",
                "辛巳庚子己酉庚子",
                "乙酉癸未丁巳戊申",
                "乙酉戊子庚寅丙子",
                "戊子戊午丁未癸卯",
                "庚寅己卯乙酉戊寅",
                "庚寅庚辰丙戌甲午",
                "甲午丁卯丁丑丁未",
                "乙未己卯辛亥癸巳",
                "戊戌丁巳丁卯庚子",
                "辛亥壬辰丁亥辛丑",
                "甲寅戊辰癸巳庚申",
                "己未辛未癸巳壬子",
                "癸亥乙卯己未甲戌",
                "乙丑戊寅庚子丙戌",
                "庚午辛巳癸未癸亥",
                "乙亥乙酉辛未丁酉",
                "丁丑戊申丁未丙午",
                "戊戌丁巳戊辰壬子",
                "己未辛未壬辰庚子",
                "乙丑戊寅辛丑戊戌",
                "己卯丙子丁巳庚子",
                "己卯丁丑壬辰庚戌",
                "辛巳庚子己酉庚午",
                "乙酉戊子庚寅丙戌",
                "戊戌丁巳丁卯庚子"
        };

        int count = 0;
        for (String horoscope : horoscopes) {
            long startTime, endTime;

            startTime = System.currentTimeMillis();
            String getCongenital1 = Arrays.toString(new Congenital().getCongenital1(horoscope));
            endTime = System.currentTimeMillis();
            System.out.print(endTime - startTime);
            System.out.print(" ");
            startTime = System.currentTimeMillis();
            String Five = Arrays.toString(new Tools().Five(horoscope));
            endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);

            if (!getCongenital1.equals(Five)) {
                System.out.println(getCongenital1);
                System.out.println(Five);
                count++;
            }
        }
        System.out.println(count + "/" + horoscopes.length);
    }
}
