package com.cdutcm.elements.utils;

import com.cdutcm.elements.dao.SolartermDao;
import com.cdutcm.elements.entity.Acquire;
import com.cdutcm.elements.entity.Inborn;
import com.cdutcm.elements.enums.ResultEnum;
import com.cdutcm.elements.exception.ElementsException;
import com.cdutcm.elements.form.Category;
import com.cdutcm.elements.form.Person;
import com.cdutcm.elements.utils.calendarConverter.Lunar;
import com.cdutcm.elements.utils.calendarConverter.LunarSolarConverterUtil;
import com.cdutcm.elements.utils.calendarConverter.Solar;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 18:55 星期一
 * Description:
 */
@Slf4j
@Service
public class ElementsUtils {

    @Autowired
    private SolartermDao solartermDao;

    private String[] TGTable = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};//天干表
    private String[] DZTable = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};//地支表
    private Map<String, Float> TGMap = new LinkedHashMap<>();

    /**
     * 【先天】根据农历计算公历，根据公历计算农历
     *
     * @param person person
     * @return inborn
     */
    public Inborn BirthConverter(Person person) {
        /*
        日期格式：
            公历:2018-05-15 08
            农历:2018-04-01 08
         */
        Inborn inborn = new Inborn();
        try {
            String birth = person.getBirth();
            if ("公历".equals(birth.substring(0, 2))) {
                inborn.setSolarBirth(birth.substring(3));
                SimpleDateFormat sdf = new SimpleDateFormat("公历:yyyy-MM-dd HH");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(sdf.parse(birth));
                Solar solar = new Solar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
                Lunar lunar = LunarSolarConverterUtil.SolarToLunar(solar);
                inborn.setLunarBirth(lunar.toString() + birth.substring(13));
            } else {
                inborn.setLunarBirth(birth.substring(3));
                SimpleDateFormat sdf = new SimpleDateFormat("农历:yyyy-MM-dd HH");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(sdf.parse(birth));
                Lunar lunar = new Lunar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
                Solar solar = LunarSolarConverterUtil.LunarToSolar(lunar);
                inborn.setSolarBirth(solar.toString() + birth.substring(13));
            }

        } catch (ParseException e) {
            e.printStackTrace();
            throw new ElementsException(ResultEnum.DATE_FORMAT_ERROR);
        }
        return inborn;
    }

    /**
     * 【先天】计算八字
     * http://www.china95.net/paipan/bazi/
     *
     * @param date 公历出生日期
     * @return 八字
     */
    public String getHoroscope(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar birth = Calendar.getInstance();
        Calendar birthDay = Calendar.getInstance();
        try {
            birth.setTime(sdf.parse(date));
            birthDay.setTime(sdf2.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
            throw new ElementsException(ResultEnum.DATE_FORMAT_ERROR);
        }
        StringBuilder sb = new StringBuilder();
        String[] tianganTable = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
        String[] dizhiTable = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
        Map<String, Integer> jieqiMap = new HashMap<String, Integer>() {
            {
                put("惊蛰", 1);
                put("清明", 2);
                put("立夏", 3);
                put("芒种", 4);
                put("小暑", 5);
                put("立秋", 6);
                put("白露", 7);
                put("寒露", 8);
                put("立冬", 9);
                put("大雪", 10);
                put("小寒", 11);
                put("立春", 12);
            }
        };
        //年柱
        int year = birth.get(Calendar.YEAR);
        Calendar lichunCalender = Calendar.getInstance();
        lichunCalender.setTime(solartermDao.selectLichunByYear(year));

        int nianganInt = (year - 3) % 10;
        int nianzhiInt = (year - 3) % 12;
        if (birth.before(lichunCalender)) {//立春之前
            nianganInt--;
            nianzhiInt--;
        }
        sb.append(tianganTable[(nianganInt + 9) % 10]);
        sb.append(dizhiTable[(nianzhiInt + 11) % 12]);
        //月柱
        int month = jieqiMap.get(solartermDao.selectSolartermByDate(birth.getTime()).getSolarterm());
        sb.append(tianganTable[(nianganInt * 2 + month + 9) % 10]);
        sb.append(dizhiTable[(month + 1) % 12]);
        //日柱
//{"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"}
//{"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"}
        Calendar rizhuStd = Calendar.getInstance();
//        rizhuStd.set(1999, Calendar.DECEMBER, 31, 23, 59, 59);
        rizhuStd.set(2000, Calendar.JANUARY, 1, 0, 0, 0);
        long A = (birthDay.getTimeInMillis() - rizhuStd.getTimeInMillis()) / (3600 * 24 * 1000);
        int riganInt;
        int rizhiInt;
        if (A > 0) {//公元2000年后
            A++;
            riganInt = (int) (((Math.abs(A) - 5) % 10 + 9) % 10);
            rizhiInt = (int) (((Math.abs(A) - 5) % 12 + 11) % 12);
        } else {
            riganInt = (int) ((10 - (Math.abs(A) + 5) % 10 + 9) % 10);
            rizhiInt = (int) ((12 - (Math.abs(A) + 5) % 12 + 11) % 12);
        }
        sb.append(tianganTable[riganInt]);
        sb.append(dizhiTable[rizhiInt]);
        //时柱
        int shizhiInt = (birth.get(Calendar.HOUR_OF_DAY) + 1) / 2 % 12;
        sb.append(tianganTable[((riganInt * 2 + shizhiInt + 1) % 10 + 9) % 10]);
        sb.append(dizhiTable[shizhiInt]);
        return sb.toString();
    }

    /**
     * 【先天】计算先天五行值-方案1
     *
     * @param horoscope 八字
     * @return 五行值
     */
    public float[] getCongenital1(String horoscope) {
        for (String aTGTable : TGTable) {
            TGMap.put(aTGTable, 0.0f);
        }
        String[] zhus = {horoscope.substring(0, 2), horoscope.substring(2, 4), horoscope.substring(4, 6), horoscope.substring(6, 8)};
        TGNumber(zhus);//步骤1
        DZNumber(zhus);//步骤2\3
        YZNumber(zhus);//步骤4
        TGJZNumber();//步骤5
        return getResult();
    }
    //region 【先天】计算先天五行值-方案1

    /**
     * 步骤1：天干取数，是对输入八字结构中四个天干处理。
     * 先取数，每一个天干的基本数为18。然后根据天干所坐地支加权，即基本数18加表1标记的权重数：
     *///步骤1
    private void TGNumber(String[] zhus) {
        //天干加权表
        String[][] TGJQTable = {{"甲申", "乙酉", "丙子", "丁亥", "戊寅", "己卯", "庚午", "辛巳", "壬戌", "癸未"}, {"甲戌", "乙丑", "丙申", "丁酉", "戊子", "己亥", "庚寅", "辛卯", "壬午", "癸巳"}, {"甲午", "乙巳", "丙辰", "丁丑", "戊申", "己酉", "庚子", "辛亥", "壬寅", "癸卯"}, {"甲辰", "乙未", "丙戌", "丁未", "戊辰", "己丑", "庚戌", "辛未", "壬辰", "癸丑"}, {"甲子", "乙亥", "丙寅", "丁卯", "戊戌", "己未", "庚辰", "辛丑", "壬申", "癸酉"}, {"甲寅", "乙卯", "丙午", "丁巳", "戊午", "己巳", "庚申", "辛酉", "壬子", "癸亥"},};
        for (int j = 0; j < 4; j++) {//年月日时
            for (int i = 0; i < TGJQTable.length; i++) {//年柱
                if (TGFind(TGJQTable[i], zhus[j], (float) (i * 2.0 + 18))) {//已经找到年月日时柱,跳出循环
                    break;
                }
            }
        }
    }

    /**
     * 步骤2：地支藏天干取数，是对八字结构中四个地支的处理。根据表2，
     * 将地支转换为其中所含有的天干，然后将各天干数相加，得到地支藏天干取数，
     * 若某一天干在地支藏天干取数中不存在，则该天干数为0。
     * 步骤3：同类天干数值相加，将以上步骤1天干处理和步骤2地支处理后
     * 所输出的天干的数值，作同类天干数值各自相加的运算，由此得到10个变量，
     * 即由10个天干符号标记的变量数值。
     *///步骤2.3
    private void DZNumber(String[] zhus) {
        //声明3个Map数组.分别存放配数1,配数2,配数3
        Map<String, Float>[] maps = new Map[3];
        for (int i = 0; i < 3; i++) {
            //声明LinkedHashMap可循序存放 (子 丑 寅 卯 辰 巳 午 未 申 酉 戌 亥)
            maps[i] = new LinkedHashMap<>();
        }
        //地支藏天干配数表 在后边添加0123456789ab是因为map键必须保持不同
        maps[0].put("壬0", 10.0f);
        maps[1].put("癸0", 20.0f);
        maps[2].put("0", 0.0f);
        maps[0].put("己1", 18.0f);
        maps[1].put("辛1", 3.0f);
        maps[2].put("癸1", 9.0f);
        maps[0].put("甲2", 16.0f);
        maps[1].put("丙2", 7.0f);
        maps[2].put("戊2", 7.0f);
        maps[0].put("甲3", 10.0f);
        maps[1].put("乙3", 20.0f);
        maps[2].put("3", 0.0f);
        maps[0].put("乙4", 9.0f);
        maps[1].put("戊4", 18.0f);
        maps[2].put("癸4", 3.0f);
        maps[0].put("丙5", 16.0f);
        maps[1].put("戊5", 5.0f);
        maps[2].put("庚5", 9.0f);
        maps[0].put("丙6", 10.0f);
        maps[1].put("丁6", 11.0f);
        maps[2].put("己6", 9.0f);
        maps[0].put("乙7", 3.0f);
        maps[1].put("丁7", 9.0f);
        maps[2].put("己7", 18.0f);
        maps[0].put("戊8", 3.0f);
        maps[1].put("己8", 7.0f);
        maps[2].put("庚8", 17.0f);
        maps[0].put("庚9", 10.0f);
        maps[1].put("辛9", 20.0f);
        maps[2].put("9", 0.0f);
        maps[0].put("丁a", 3.0f);
        maps[1].put("戊a", 18.0f);
        maps[2].put("辛a", 9.0f);
        maps[0].put("甲b", 5.0f);
        maps[1].put("戊b", 7.0f);
        maps[2].put("壬b", 18.0f);
        for (String zhu : zhus) {
            DZFind(maps, zhu);
        }

    }

    /**
     * 步骤4：月支加权，根据出生时的月令（八字结构中的月柱地支）加权。
     * 根据表3，
     * 天干变量属“休”的五行取为中值，即乘以1；
     * 天干变量属“旺”的五行，乘以1.2；
     * 天干变量属“相”的五行，乘以1.1；
     * 天干变量属“囚”的五行，乘以0.9；
     * 天干变量属“死”的五行，乘以0.8。
     */////步骤4
    private void YZNumber(String[] zhus) {
        //月令加权表
        String[][] YLJQTable = {
                // *1.2 *1.1 *1.0 *0.9 *0.8
                {"壬", "癸", "甲", "乙", "庚", "辛", "戊", "己", "丙", "丁"},//子
                {"壬", "癸", "戊", "己", "庚", "辛", "甲", "乙", "丙", "丁"},//丑
                {"甲", "乙", "丙", "丁", "壬", "癸", "庚", "辛", "戊", "己"},//寅
                {"甲", "乙", "丙", "丁", "壬", "癸", "庚", "辛", "戊", "己"},//卯
                {"甲", "乙", "戊", "己", "丙", "丁", "壬", "癸", "庚", "辛"},//辰
                {"丙", "丁", "戊", "己", "甲", "乙", "壬", "癸", "庚", "辛"},//巳
                {"丙", "丁", "戊", "己", "甲", "乙", "壬", "癸", "庚", "辛"},//午
                {"戊", "己", "丙", "丁", "庚", "辛", "甲", "乙", "壬", "癸"},//未
                {"庚", "辛", "壬", "癸", "戊", "己", "丙", "丁", "甲", "乙"},//申
                {"庚", "辛", "壬", "癸", "戊", "己", "丙", "丁", "甲", "乙"},//酉
                {"戊", "己", "庚", "辛", "丙", "丁", "壬", "癸", "甲", "乙"},//戌
                {"壬", "癸", "甲", "乙", "庚", "辛", "戊", "己", "丙", "丁"},//亥
        };
        String DZVal = zhus[1].substring(1, 2);//取出地支
        int DZindex = 0;
        for (int i = 0; i < DZTable.length; i++) {
            if (DZVal.equals(DZTable[i])) {
                DZindex = i;
            }
        }
        float[] JQVal = {1.2f, 1.1f, 1.0f, 0.9f, 0.8f};
        for (int i = 0; i < YLJQTable[0].length; i++) {
            String t = YLJQTable[DZindex][i];//表中的String值
            float a = TGMap.get(t) * JQVal[(i / 2)];//进行月支加权,保留一位小数(四舍五入)
            TGMap.put(t, a);//将计算的值放入TGMap
        }
    }

    /**
     * 步骤5：天干均值。首先将每一个天干变量除以变量值的总和，求得百分比。
     * 然后将所得数值，按不同的天干，减去它的“中值”。
     *///步骤5
    private void TGJZNumber() {
        //天干的中值
        float[] midValue = {8.6f, 8.9f, 9.2f, 6.4f, 16.0f, 14.2f, 10.0f, 8.9f, 8.9f, 8.9f};
        float total = 0.0f;
        for (int i = 0; i < TGMap.size(); i++) {
            total += TGMap.get(TGTable[i]);
        }
        for (int i = 0; i < TGMap.size(); i++) {
            float d = TGMap.get(TGTable[i]) / total * 100 - midValue[i];
            TGMap.put(TGTable[i], d);
        }
    }

    /**
     * 步骤6：确定五行所属和所缺。根据所得的10个天干变量同行相加，并输出结果。
     *///步骤6
    private float[] getResult() {
        float[] result = new float[5];
        for (int i = 0; i < TGMap.size(); i = i + 2) {
            float d = TGMap.get(TGTable[i]) + TGMap.get(TGTable[i + 1]);
            result[i / 2] = Math.round(d * 10) / 10f;
        }
        return result;
    }

    /**
     * 天干取数
     *
     * @param TGJQTableI 天干加权表
     * @param zhu        年月日时柱
     * @param val        加权值
     * @return 是否找到匹配
     */
    private boolean TGFind(String[] TGJQTableI, String zhu, float val) {
        for (String aTGJQTableI : TGJQTableI) {
            if (zhu.equals(aTGJQTableI)) {
                String TGVal = zhu.substring(0, 1);//取出天干值
                TGMap.put(TGVal, TGMap.get(TGVal) + val);
                return true;
            }
        }
        return false;
    }

    /**
     * 地支藏天干取数
     *
     * @param maps 地支藏天干配数表
     * @param zhu  年月日时柱
     * @return 是否找到匹配
     */
    private boolean DZFind(Map[] maps, String zhu) {
        String DZVal = zhu.substring(1, 2);//取出地支
        //确定地支的index
        int DZindex = 0;
        for (int i = 0; i < DZTable.length; i++) {
            if (DZVal.equals(DZTable[i])) {
                DZindex = i;
            }
        }
        for (int i = 0; i < 3; i++) {
            //获取配数i的地支序数为DZindex的键值() 配数键值
            String PZKeyStr = maps[i].keySet().toArray()[DZindex].toString();
            if (PZKeyStr.length() == 2) {
                String PZKeyChar = PZKeyStr.substring(0, 1);
                TGMap.put(PZKeyChar, TGMap.get(PZKeyChar) + (float) maps[i].get(PZKeyStr));
            }
        }
        return false;
    }
    //endregion

    /**
     * 【先天】计算先天五行值-羊老师先天五行方案
     *
     * @param horoscope 八字
     * @return 五行值
     */
    public float[] getCongenital2(String horoscope) {
        float[] result = {0f, 0f, 0f, 0f, 0f};
        float[] tianganValues = new float[10];
        Map<Character, Integer> tianganMap = new HashMap<Character, Integer>() {
            {
                put('甲', 0);
                put('乙', 1);
                put('丙', 2);
                put('丁', 3);
                put('戊', 4);
                put('己', 5);
                put('庚', 6);
                put('辛', 7);
                put('壬', 8);
                put('癸', 9);
            }
        };
        Map<Character, String> zhi2ganMap = new HashMap<Character, String>() {
            {
                put('子', "癸");
                put('丑', "己癸辛");
                put('寅', "甲丙戊");
                put('卯', "乙");
                put('辰', "戊癸乙");
                put('巳', "丙庚戊");
                put('午', "丁己");
                put('未', "己乙丁");
                put('申', "戊壬庚");
                put('酉', "辛");
                put('戌', "戊丁辛");
                put('亥', "壬甲");
            }
        };
        int index;
        StringBuilder zhi2gan = new StringBuilder();
        for (int i = 0; i < horoscope.length(); i++) {
            if (i % 2 == 0) {
                index = tianganMap.get(horoscope.charAt(i));
                tianganValues[index] = tianganValues[index] + 7;
            } else {
                zhi2gan.append(zhi2ganMap.get(horoscope.charAt(i)));
            }
        }
        float wight = 72f / zhi2gan.length();
        for (int i = 0; i < zhi2gan.length(); i++) {
            index = tianganMap.get(zhi2gan.charAt(i));
            tianganValues[index] = tianganValues[index] + wight;
        }
        for (int i = 0; i < tianganValues.length; i++) {
            result[i / 2] += tianganValues[i] - 10;
        }
        return result;
    }

    /**
     * 【后天】计算后天五行值
     *
     * @param category 选项条目
     * @return 五行值
     */
    public int[] getPostnatal(Category category, char sex) {
        try {
            int postnatal[] = {0, 0, 0, 0, 0};
            postnatal[category.getLianXing().charAt(0) - 'A']++;
            postnatal[category.getMianSe().charAt(0) - 'A']++;
            postnatal[category.getQuGan().charAt(0) - 'A']++;
            postnatal[category.getSiZhi().charAt(0) - 'A']++;
            postnatal[category.getYuYin().charAt(0) - 'A']++;
            postnatal[category.getXingLi().charAt(0) - 'A']++;
            /*寒热*/
            if (category.getHanRe().charAt(0) != 'C') {
                postnatal[0]++;
                postnatal[1]++;
            }
            /*汗*/
            char c = category.getHan().charAt(0);
            if (c == 'A' || c == 'B') {
                postnatal[3]++;
            } else if (c == 'D' || c == 'G') {
                postnatal[0]++;
                postnatal[4]++;
            } else if (c == 'E' || c == 'F') {
                postnatal[1]++;
            }
            /*饮食口味*/
            c = category.getYinShiKouWei().charAt(0);
            if (c == 'A' || c == 'B' || c == 'E' || c == 'H') {
                postnatal[2]++;
            } else if (c == 'D' || c == 'G') {
                postnatal[1]++;
            } else if (c == 'F') {
                postnatal[0]++;
            } else if (c == 'I') {
                postnatal[3]++;
            }
            /*大便*/
            c = category.getDaBian().charAt(0);
            if (c != 'C') {
                postnatal[2]++;
            }
            if (c == 'D' || c == 'E') {
                postnatal[3]++;
            }
            /*小便*/
            c = category.getXiaoBian().charAt(0);
            if (c != 'C') {
                postnatal[4]++;
            }
            if (c == 'D' || c == 'E') {
                postnatal[1]++;
            }
            /*睡眠*/
            c = category.getShuiMian().charAt(0);
            if (c != 'B' && c != 'D') {
                postnatal[0]++;
            }
            if (c == 'B' || c == 'C') {
                postnatal[1]++;
            }
            /*精神状态*/
            c = category.getJingShengZhuangTai().charAt(0);
            if (c == 'A') {
                postnatal[0]++;
                postnatal[2]++;
            } else if (c == 'B') {
                postnatal[1]++;
            } else if (c == 'C') {
                postnatal[3]++;
            } else if (c == 'D') {
                postnatal[0]++;
                postnatal[1]++;
                postnatal[2]++;
                postnatal[3]++;
            }
            /*头部-木*/
            c = category.getTouBu().charAt(0);
            if (c == 'D' || c == 'E') {
                postnatal[0]++;
            }
            /*双目-木*/
            if (category.getShuangMu().charAt(0) != 'C') {
                postnatal[0]++;
            }
            /*胸胁-木*/
            if (category.getXiongXie().charAt(0) != 'C') {
                postnatal[0]++;
            }
            /*肢体-木*/
            if (category.getZhiTi().charAt(0) == 'A') {
                postnatal[0]++;
            }
            /*月经-木*/
            if (category.getYueJing().charAt(0) != 'C' && sex == '女') {
                postnatal[0]++;
            }
            /*易发-木*/
            if (category.getYiFaMu().charAt(0) != 'B') {
                postnatal[0]++;
            }
            /*口唇-火*/
            if (category.getKouChun().charAt(0) != 'C') {
                postnatal[1]++;
            }
            /*心胸-火*/
            if (category.getXinXiong().charAt(0) != 'C') {
                postnatal[1]++;
            }
            /*易发-火*/
            if (category.getYiFaHuo().charAt(0) != 'B') {
                postnatal[1]++;
            }
            /*头身-土*/
            if (category.getTouShen().charAt(0) != 'C') {
                postnatal[2]++;
            }
            postnatal[2]++;
            /*胃脘-土*/
            c = category.getWeiWan().charAt(0);
            if (c == 'A' || c == 'B') {
                postnatal[2]++;
            }
            /*腹部-土*/
            if (category.getFuBu().charAt(0) != 'C') {
                postnatal[2]++;
            }
            /*易发-土*/
            if (category.getYiFaTu().charAt(0) == 'A') {
                postnatal[2]++;
            }
            /*咳嗽-金*/
            if (category.getKeSou().charAt(0) != 'C') {
                postnatal[3]++;
            }
            /*咯痰-金*/
            if (category.getGeTan().charAt(0) != 'C') {
                postnatal[3]++;
            }
            /*鼻部-金*/
            if (category.getBiBu().charAt(0) != 'C') {
                postnatal[3]++;
            }
            /*皮肤-金*/
            if (category.getPiFu().charAt(0) == 'C') {
                postnatal[3]++;
            }
            /*腰膝-水*/
            c = category.getYaoQi().charAt(0);
            if (c == 'A' || c == 'B') {
                postnatal[4]++;
            }
            /*性欲-水*/
            if (category.getXingYu().charAt(0) != 'B') {
                postnatal[4]++;
            }
            /*遗精-水*/
            if (category.getYiJing().charAt(0) != 'B' && sex == '男') {
                postnatal[4]++;
            }
            /*带下-水*/
            if (category.getDaiXia().charAt(0) != 'C' && sex == '女') {
                postnatal[4]++;
            }
            postnatal[category.getHaoFaJiJie().charAt(0) - 'A']++;
            postnatal[category.getHaoFaBingWei().charAt(0) - 'A']++;
            return postnatal;
        } catch (Exception e) {
            throw new ElementsException(ResultEnum.SERVICE_ERROR);
        }
    }

    /**
     * 【先天】计算所属、所缺
     *
     * @param elementValues 五行值
     * @return 所属-所缺
     */
    public String getBelongLack(float[] elementValues) {
        List<String> valuesList = getInbornValuesList(elementValues);
        setValuesList(valuesList, 0);
        return valuesList.get(0) + "-" + valuesList.get(2);
    }

    /**
     * 【后天】计算所属、所缺、所次
     *
     * @param elementValues 五行值
     * @return 所属-所缺-所次
     */
    public String getBelongLackMinor(int[] elementValues) {
        List<String> valuesList = getAcquireValuesList(elementValues);
        for (int i = 0; i < 6; i += 4) {//i += 4：跳过i=2的情况 i=2时为所缺，所缺显示全部属性
            setValuesList(valuesList, i);
        }
        return valuesList.get(0) + "-" + valuesList.get(2) + "-" + valuesList.get(4);
    }

    private void setValuesList(List<String> valuesList, int i) {
        switch (valuesList.get(i + 1)) {
            case "2":
                valuesList.set(i, getTwo2One(valuesList.get(i)));
                break;
            case "3":
                valuesList.set(i, getThree2One(valuesList.get(i)));
                break;
            case "4":
                valuesList.set(i, getFour2One(valuesList.get(i)));
                break;
        }
    }

    public Integer[] getYinYangValue(Category category) {
        Integer yinYangValues[] = {0, 0, 0, 0, 0};
        // TODO: 2018/5/15 需测试，算法需优化
        /*面色特点*/
        yinYangValues[category.getMianSe().charAt(0) - 'A'] += getAttributeValue(category.getMianSe().substring(1));
        /*心理特征*/
        yinYangValues[category.getXingLi().charAt(0) - 'A'] += getAttributeValue(String.valueOf(category.getMianSe().charAt(1) + 1));
        /*寒热*/
        int hanRe = getAttributeValue(category.getHanRe());
        yinYangValues[0] += hanRe;
        yinYangValues[1] += hanRe;
        /*汗*/
        int[] han = {-2, -1, 0, 1, 1, 2, 2};
        int ha = han[category.getHan().charAt(0) - 'A'];
        switch (category.getHan()) {
            case "D":
            case "G":
                yinYangValues[0] += ha;
                yinYangValues[4] += ha;
                break;
            case "E":
            case "F":
                yinYangValues[1] += ha;
                break;
            case "A":
            case "B":
                yinYangValues[3] += ha;
                break;
        }
        /*饮食口味*/
        int[] yinShi = {-2, -1, 0, 1, 1, 2, 2, 2, 2};
        int yinS = yinShi[category.getYinShiKouWei().charAt(0) - 'A'];
        switch (category.getYinShiKouWei()) {
            case "F":
                yinYangValues[0] += yinS;
                break;
            case "D":
            case "G":
                yinYangValues[1] += yinS;
                break;
            case "A":
            case "B":
            case "E":
            case "H":
                yinYangValues[2] += yinS;
                break;
            case "I":
                yinYangValues[3] += yinS;
                break;
        }
        /*大便*/
        int daBian = getAttributeValue(category.getDaBian());
        yinYangValues[2] += daBian;
        if ("D".equals(category.getDaBian()) || "E".equals(category.getDaBian())) {
            yinYangValues[3] += daBian;
        }
        /*小便*/
        int xiaoBian = getAttributeValue(category.getXiaoBian());
        yinYangValues[4] += xiaoBian;
        if ("D".equals(category.getXiaoBian()) || "E".equals(category.getXiaoBian())) {
            yinYangValues[1] += xiaoBian;
        }
        /*睡眠*/
        int[] shuiMian = {-2, -2, -1, 0, 1, 2};
        int shuiM = shuiMian[category.getShuiMian().charAt(0) - 'A'];
        switch (category.getShuiMian()) {
            case "A":
            case "E":
            case "F":
                yinYangValues[0] += shuiM;
                break;
            case "B":
                yinYangValues[1] += shuiM;
                break;
            case "C":
                yinYangValues[0] += shuiM;
                yinYangValues[1] += shuiM;
                break;
        }
        /*精神状态*/
        int[] jingShen = {-2, -2, -2, -1, 0, 0, 0};
        int jingS = jingShen[category.getJingShengZhuangTai().charAt(0) - 'A'];
        switch (category.getJingShengZhuangTai()) {
            case "B":
                yinYangValues[1] += jingS;
                break;
            case "C":
                yinYangValues[3] += jingS;
                break;
            case "D":
                yinYangValues[0] += jingS;
                yinYangValues[2] += jingS;
            case "A":
                yinYangValues[1] += jingS;
                yinYangValues[3] += jingS;
                break;
        }
        /*木*/
        /*头部*/
        int[] touBu = {0, 0, 0, 1, 2};
        yinYangValues[0] += touBu[category.getTouBu().charAt(0) - 'A'];
        yinYangValues[0] += getAttributeValue(category.getShuangMu());/*双目症状*/
        yinYangValues[0] += getAttributeValue(category.getXiongXie());/*胸胁症状*/
        /*肢体症状*/
        if ("A".equals(category.getZhiTi())) {
            yinYangValues[0] -= 1;
        }
        yinYangValues[0] += getAttributeValue(category.getYueJing());/*月经症状*/
        yinYangValues[0] += getAttributeValue(String.valueOf(category.getYiFaMu().charAt(0) + 1));/*易发症状*/
        /*火*/
        yinYangValues[1] += getAttributeValue(category.getKouChun());/*口唇症状*/
        yinYangValues[1] += getAttributeValue(category.getXinXiong());/*心胸症状*/
        yinYangValues[1] += getAttributeValue(String.valueOf(category.getYiFaHuo().charAt(0) + 1));/*易发症状*/
        /*土*/
        yinYangValues[2] += getAttributeValue(category.getTouShen());/*头身症状*/
        yinYangValues[2] += getAttributeValue(category.getSheChun());/*舌唇症状*/
        /*胃脘症状*/
        int[] weiWan = {-2, -1, 0, 0, 0};
        yinYangValues[2] += weiWan[category.getWeiWan().charAt(0) - 'A'];
        yinYangValues[2] += getAttributeValue(category.getFuBu());/*腹部症状*/
        /*易发症状*/
        if ("A".equals(category.getYiFaTu())) {
            yinYangValues[2] -= 1;
        }
        /*金*/
        yinYangValues[3] += getAttributeValue(category.getKeSou());/*咳嗽*/
        yinYangValues[3] += getAttributeValue(category.getGeTan());/*咯痰*/
        yinYangValues[3] += getAttributeValue(category.getBiBu());/*鼻部症状*/
        /*皮肤*/
        if ("C".equals(category.getPiFu())) {
            yinYangValues[3] += 1;
        }
        /*水*/
        /*腰膝症状*/
        int[] yaoQi = {-2, -1, 0, 0, 0};
        yinYangValues[4] += yaoQi[category.getYaoQi().charAt(0) - 'A'];
        yinYangValues[4] += getAttributeValue(String.valueOf(category.getXingYu().charAt(0) + 1));/*性欲*/
        yinYangValues[4] += getAttributeValue(String.valueOf(category.getYiJing().charAt(0) + 1));/*遗精*/
        yinYangValues[4] += getAttributeValue(category.getDaiXia());/*带下症状*/
        return yinYangValues;
    }

    /**
     * 【先天】将 “00001-20000” 格式转换为 “所属：水、所缺：木”
     *
     * @param value 五行01串
     * @return 五行
     */
    public static String convertInborn(String value) {
        StringBuilder sb = new StringBuilder();
        String[] elements = {"木", "火", "土", "金", "水"};
        sb.append("所属：");
        for (int i = 0; i < 5; i++) {
            if (value.charAt(i) == '1') {
                sb.append(elements[i]);
            }
        }

        StringBuilder tmp = new StringBuilder();
        for (int i = 6; i < 11; i++) {
            if (value.charAt(i) == '2') {
                tmp.append(elements[i % 6]);
            }
        }
        if (tmp.length() != 0) {
            sb.append("、所缺：");
            sb.append(tmp);
        }
        return sb.toString();
    }

    /**
     * 【后天】将 “00001-20000-01000” 格式转换为 “所属：水、所缺：木、所次：火”
     *
     * @param acquire acquire
     * @return 五行
     */
    public static String convertAcquire(Acquire acquire) {
        String value = acquire.getAcquire();
        int[] yinYangValue = {acquire.getYinYangWood(), acquire.getYinYangFire(), acquire.getYinYangEarth(), acquire.getYinYangMetal(), acquire.getYinYangWater()};
        StringBuilder sb = new StringBuilder();
        String[] elements = {"木", "火", "土", "金", "水"};
        sb.append("所属：");
        for (int i = 0; i < 5; i++) {
            if (value.charAt(i) == '1') {
                sb.append(elements[i]);
                if (yinYangValue[i] != 0) {
                    sb.append("(").append(yinYangValue[i] > 0 ? "阳" : "阴").append(")");
                }
            }
        }
        StringBuilder tmp = new StringBuilder();
        for (int i = 6; i < 11; i++) {
            if (value.charAt(i) == '2') {
                tmp.append(elements[i % 6]);
            }
        }
        if (tmp.length() != 0) {
            sb.append("、所缺：");
            sb.append(tmp);
        }
        tmp.delete(0, tmp.length());
        for (int i = 12; i < 17; i++) {
            if (value.charAt(i) == '1') {
                tmp.append(elements[i % 12]);
                if (yinYangValue[i % 12] != 0) {
                    tmp.append("(").append(yinYangValue[i % 12] > 0 ? "阳" : "阴").append(")");
                }
            }
        }
        if (tmp.length() != 0) {
            sb.append("、所次：");
            sb.append(tmp);
        }
        return sb.toString();
    }

    /**
     * 获取Acquire中的所属所次阴阳值的序号
     *
     * @param acquire 后天
     * @return 所属、所次的序号
     */
    public static Integer[] acquire2Index(Acquire acquire) {
        Integer[] indexs = new Integer[2];
        String acquireStr = acquire.getAcquire();
        for (int i = 0; i < 5; i++) {
            if (acquireStr.charAt(i) == '1') {
                indexs[0] = i;
            }
            if (acquireStr.charAt(i + 12) == '1') {
                indexs[1] = i;
            }
        }
        return indexs;
    }

    /**
     * 获取Acquire中的所属所次阴阳值，String格式
     *
     * @param acquire 后天
     * @return 所属、所次
     */
    public static String acquire2YinYang(Acquire acquire) {
        Integer[] indexs = acquire2Index(acquire);
        float[] postnatal = {acquire.getYinYangWood(), acquire.getYinYangFire(), acquire.getYinYangEarth(), acquire.getYinYangMetal(), acquire.getYinYangWater()};
        if (indexs[1] == null) {
            return "所属：" + postnatal[indexs[0]];
        }
        return "所属：" + postnatal[indexs[0]] + "、所次：" + postnatal[indexs[1]];
    }

    /**
     * 【后天】将五行值转换为所属、所缺、所次的string表示方式。
     *
     * @param elementValues 五行值
     * @return list
     * 0:所属（10000） 1:所缺（00002/00000） 2:所次（00001/00000）
     * 3:所属个数 4:所缺个数 5:所次个数
     */
    public List<String> getAcquireValuesList(int[] elementValues) {
        List<String> list = new ArrayList<>(6);
        StringBuilder belong = new StringBuilder();//所属
        StringBuilder lack = new StringBuilder();//所缺
        StringBuilder minor = new StringBuilder();//所次
        float max = Float.MIN_VALUE;
        float tmp = Float.MIN_VALUE;
        for (float elementValue : elementValues) {//循环查找最大值。
            if (elementValue > max) {
                max = elementValue;
            }
        }
        for (float elementValue : elementValues) {//循环查找不等于最大值的最大值。
            if (elementValue > tmp && elementValue != max) {
                tmp = elementValue;
            }
        }
        int belongCount = 0;
        int lackCount = 0;
        int minorCount = 0;
        for (float elementValue : elementValues) {
            if (elementValue == max) {//所属为最大值
                belong.append(1);
                belongCount++;
            } else {
                belong.append(0);
            }
            if (elementValue == 0) {//所缺为0
                lack.append(2);
                lackCount++;
            } else {
                lack.append(0);
            }
            if (elementValue == tmp) {//所次为第二大值
                minor.append(1);
                minorCount++;
            } else {
                minor.append(0);
            }
        }
        list.add(belong.toString());
        list.add(String.valueOf(belongCount));
        list.add(lack.toString());
        list.add(String.valueOf(lackCount));
        list.add(minor.toString());
        list.add(String.valueOf(minorCount));
        return list;
    }

    /**
     * 【先天】将五行值转换为所属、所缺的string表示方式。
     *
     * @param elementValues 五行值
     * @return list
     * 0:所属（10000） 1:所缺（00002/00000）
     * 3:所属个数 4:所缺个数 5:所次个数
     */
    private List<String> getInbornValuesList(float[] elementValues) {
        List<String> list = new ArrayList<>(4);
        StringBuilder belong = new StringBuilder();//所属
        StringBuilder lack = new StringBuilder();//所缺
        float max = Float.MIN_VALUE;
        float min = Float.MAX_VALUE;
        for (float elementValue : elementValues) {//循环查找最大值。
            if (elementValue > max) {
                max = elementValue;
            }
            if (elementValue < min) {
                min = elementValue;
            }
        }
        int belongCount = 0;
        int lackCount = 0;
        for (float elementValue : elementValues) {
            if (elementValue == max) {//所属为最大值
                belong.append(1);
                belongCount++;
            } else {
                belong.append(0);
            }
            if (elementValue == min) {//所缺为最小值
                lack.append(2);
                lackCount++;
            } else {
                lack.append(0);
            }
        }
        list.add(belong.toString());
        list.add(String.valueOf(belongCount));
        list.add(lack.toString());
        list.add(String.valueOf(lackCount));
        return list;
    }

    //region 五行取舍原则
    //二主
    private String getTwo2One(String value) {
        switch (value) {
            case "11000":
                return "01000";
            case "10100":
                return "10000";
            case "10010":
                return "00010";
            case "10001":
                return "10000";
            case "01100":
                return "00100";
            case "01010":
                return "01000";
            case "01001":
                return "00001";
            case "00110":
                return "00010";
            case "00101":
                return "00100";
            case "00011":
                return "00001";
        }
        return null;
    }

    //三主
    private String getThree2One(String value) {
        switch (value) {
            case "11100":
                return "10000";
            case "10110":
                return "00010";
            case "11010":
                return "01000";
            case "11001":
                return "00001";
            case "10101":
                return "10000";
            case "10011":
                return "00010";
            case "01110":
                return "01000";
            case "01101":
                return "00100";
            case "00111":
                return "00100";
            case "01011":
                return "00001";
        }
        return null;
    }

    //四主
    private String getFour2One(String value) {
        switch (value) {
            case "11110":
                return "01000";
            case "11011":
                return "00001";
            case "10111":
                return "00010";
            case "01111":
                return "00100";
            case "11101":
                return "10000";
        }
        return null;
    }
    //endregion

    private Integer getAttributeValue(String option) {
        switch (option.toUpperCase()) {
            case "A":
                return -2;
            case "B":
                return -1;
            case "C":
                return 0;
            case "D":
                return 1;
            case "E":
                return 2;
        }
        return 0;
    }
}