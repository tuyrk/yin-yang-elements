package com.cdutcm.elements.utils;

import com.cdutcm.elements.ElementsApplicationTests;
import com.cdutcm.elements.dao.SolartermDao;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/2/9 16:05 星期五
 * Description:
 */
public class SolartermTest extends ElementsApplicationTests {

    @Autowired
    private SolartermDao solartermDao;

    /**
     * 测试 1900年开始150年各节气时间表.txt 是否正确
     */
    @Test
    public void solartermTxt() {
        try {
            File file = ResourceUtils.getFile("classpath:1900年开始150年各节气时间表.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int idx = 12;
            int count = 1;
            while ((line = reader.readLine()) != null) {
                // 行号
                System.out.println("count = " + count++);

                //保留的节气是每个月（农历月）的第一个节气（有规律节气都是在上旬，日的第一个数字都是“0”）
                Assert.assertEquals("0", line.substring(10, 11));

                //保留的节气的月数是01、02、03、04、05···，循环
                String index = String.valueOf(idx);
                if (idx <= 9) {
                    index = "0" + index;
                }
                Assert.assertEquals(index, line.substring(7, 9));

                if (idx++ == 12) {
                    idx = 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void importDB() {
        try {
            File file = ResourceUtils.getFile("classpath:1900年开始150年各节气时间表.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String solarterm = line.substring(0, 2);
                String date = line.substring(2);
                System.out.println("saveSolarterm = " + solartermDao.saveSolarterm(solarterm, date));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void solartermDB() {
        Date date0 = solartermDao.selectDateByID(1);
        System.out.println("date0 = " + date0);
        for (int i = 2; i < 1800; i++) {
            Date date = solartermDao.selectDateByID(i);
            if (!date0.before(date)) {
                System.out.println("i = " + (i - 1));
            }
            date0 = date;
        }
    }
}
