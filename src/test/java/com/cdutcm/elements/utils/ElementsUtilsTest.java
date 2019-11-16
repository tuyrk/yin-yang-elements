package com.cdutcm.elements.utils;

import com.cdutcm.elements.ElementsApplicationTests;
import com.cdutcm.elements.form.Category;
import com.cdutcm.elements.form.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class ElementsUtilsTest extends ElementsApplicationTests {
    @Autowired
    private ElementsUtils elementsUtils;

    @Test
    public void BirthConverter() {
        Person person = new Person();

        person.setBirth("农历:2018-06-01 08");
        System.out.println(elementsUtils.BirthConverter(person));
        person.setBirth("公历:2018-06-01 08");
        System.out.println(elementsUtils.BirthConverter(person));
    }

    @Test
    public void getHoroscope() {
        // 2010-04-05 04 庚寅己卯乙酉戊寅
//        System.out.println("王敏:" + elementsUtils.getHoroscope("2004-08-11 12"));
//        System.out.println("王军:" + elementsUtils.getHoroscope("1990-06-16 12"));
        System.out.println("己未辛未癸巳壬子".equals(elementsUtils.getHoroscope("2000-02-04 20")));
    }

    @Test
    public void getHoroscopeTXT() {
        try {
            File file = ResourceUtils.getFile("classpath:八字测试数据.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            int i = 1;
            while ((line = bufferedReader.readLine()) != null) {
                String date = line.substring(0, 13);
                String horoscopeTXT = line.substring(14);
                String horoscopeCalc = elementsUtils.getHoroscope(date);
                if (!horoscopeCalc.equals(horoscopeTXT)) {
                    System.out.println(i + " " + date + " " + horoscopeTXT + " " + horoscopeCalc);
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCongenital() {
        String date = "1964-02-05 00";
        String horoscope = elementsUtils.getHoroscope(date);
        System.out.println("八字:" + horoscope);
        float congenital[] = elementsUtils.getCongenital2(horoscope);
        System.out.println("五行值:" + Arrays.toString(congenital));
    }

    @Test
    public void getPostnatal() {
        /*
        脸形特点、面色特点、躯干特点、四肢特点、
        语音特点、心理特征、好发季节、好发病位
        总共8项判断五行所属所缺所次
         */
        Category category = new Category(
                /*体貌特征*/"A", "Ba", "C", "B", "D",
                /*心理特征*/"Ea",
                /*生命特征*/"E", "F", "H", "B", "A", "D", "F",
                /*好发症状-木行人*/"B", "A", "D", "C", "E", "B",
                /*好发症状-火行人*/"C", "D", "B",
                /*好发症状-土行人*/"A", "B", "D", "C", "E",
                /*好发症状-金行人*/"A", "D", "E", "F",
                /*好发症状-水行人*/"B", "E", "F", "A",
                /*好发季节*/"D",
                /*好发病位*/"C");
        System.out.println("postnatal = " + Arrays.toString(elementsUtils.getPostnatal(category, '男')));
    }

    @Test
    public void getBelongLackMinor() {
        int[] elementValues = {0, 2, 1, 3, 5};
        String belongLackMinor = elementsUtils.getBelongLackMinor(elementValues);
        System.out.println("belongLackMinor = " + belongLackMinor);
    }

    @Test
    public void getYinYangValue() {
        Category category = new Category(
                /*体貌特征*/"A", "Ba", "C", "B", "D",
                /*心理特征*/"Ea",
                /*生命特征*/"E", "F", "H", "B", "A", "D", "F",
                /*好发症状-木行人*/"B", "A", "D", "C", "E", "B",
                /*好发症状-火行人*/"C", "D", "B",
                /*好发症状-土行人*/"A", "B", "D", "C", "E",
                /*好发症状-金行人*/"A", "D", "E", "F",
                /*好发症状-水行人*/"B", "E", "F", "A",
                /*好发季节*/"D",
                /*好发病位*/"C");
        String belongLackMinor = elementsUtils.getBelongLackMinor(elementsUtils.getPostnatal(category, '男'));//6
        System.out.println("belongLackMinor = " + belongLackMinor);
        System.out.println("getYinYangValue = " + Arrays.toString(elementsUtils.getYinYangValue(category)));
    }

    @Test
    public void convert() {
        String value = "00001-10000";
        System.out.println("ElementsUtils.convert(value) = " + ElementsUtils.convertInborn(value));
        value = "00001-01000";
        System.out.println("ElementsUtils.convert(value) = " + ElementsUtils.convertInborn(value));
        value = "00001-00100";
        System.out.println("ElementsUtils.convert(value) = " + ElementsUtils.convertInborn(value));
        value = "00001-20000";
        System.out.println("ElementsUtils.convert(value) = " + ElementsUtils.convertInborn(value));
        value = "00001-02000";
        System.out.println("ElementsUtils.convert(value) = " + ElementsUtils.convertInborn(value));
        value = "00001-22000";
        System.out.println("ElementsUtils.convert(value) = " + ElementsUtils.convertInborn(value));
        value = "00001-02200";
        System.out.println("ElementsUtils.convert(value) = " + ElementsUtils.convertInborn(value));
    }

    @Test
    public void getValuesList() {
        int[] elementValues = {0, 3, 0, 3, 5};
        System.out.println("getValuesList = " + elementsUtils.getAcquireValuesList(elementValues));
    }
}