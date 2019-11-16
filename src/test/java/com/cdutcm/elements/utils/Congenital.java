package com.cdutcm.elements.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/6/5 21:47 星期二
 * Description:
 */
public class Congenital {
    private String[] TGTable = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};//天干表
    private String[] DZTable = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};//地支表
    private Map<String, Float> TGMap = new LinkedHashMap<>();

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
}
