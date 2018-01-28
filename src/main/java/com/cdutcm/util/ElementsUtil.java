package com.cdutcm.util;

import com.cdutcm.entity.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/18
 * Time: 14:44 星期一
 * Description:
 */
public class ElementsUtil {
    /**
     * 根据category确定所属
     *
     * @param category
     * @return
     */
    public static List<String> ensureElements(Category category) {
        int[] ele = {0, 0, 0, 0, 0};//木火土金水
        ele = getEle(ele, category.getFeature());// 1
        ele = getEle(ele, category.getComplexion());// 2
        ele = getEle(ele, category.getTrunk());// 3
        ele = getEle(ele, category.getLimb());// 4
        ele = getEle(ele, category.getVoice());// 5
        ele = getEle(ele, category.getPsychology());// 6
        ele = getEle(ele, category.getDisease());// 7
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ele.length; i++) {
            max = Math.max(ele[i], max);
            min = Math.min(ele[i], min);
        }
        StringBuilder attribute;//所属
        attribute = appendSB(ele, max, "1");
        StringBuilder defect;//所缺
        int count = 0;//记录大于min的个数,如果有4数个大于min则为所缺;否则为所次
        for (int i = 0; i < ele.length; i++) {
            if (ele[i] > min) {//记录大于min的个数,用来判断此时是所缺还是所次
                count++;
            }
        }
        if (count == 4 || min == 0) {//如果count=4则为所缺,用1填值
            defect = appendSB(ele, min, "1");
        } else {//否则为所次,用2填值
            defect = appendSB(ele, min, "2");
        }
        List<String> list = new ArrayList<>(2);
        list.add(attribute.toString());// i = 0
        list.add(defect.toString());// i = 1
        return list;
    }

    public static String byteToStr(String str, boolean isAcquireLack) {
        if (str == null) {
            return "";
        }
        String[] elements = {"木", "火", "土", "金", "水"};
        StringBuilder sb = new StringBuilder();
        char[] strArray = str.toCharArray();
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i] == '2') {
                sb.append("所次:");
                break;
            }
        }
        if (isAcquireLack && sb.toString().length() == 0) {
            sb.append("所缺:");
        }
        boolean flag = false;
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i] == '1' || strArray[i] == '2') {
                if (flag) {
                    sb.append("、");
                } else {
                    flag = true;
                }
                sb.append(elements[i]);
            }
        }

        return sb.toString();
    }

    /**
     * 判断ABCDE转化为五行元素值
     *
     * @param ele 五行元素数组
     * @param str ABCDE
     * @return
     */
    private static int[] getEle(int[] ele, String str) {
        switch (str) {
            case "A":
                ele[0]++;
                break;
            case "B":
                ele[1]++;
                break;
            case "C":
                ele[2]++;
                break;
            case "D":
                ele[3]++;
                break;
            case "E":
                ele[4]++;
                break;
        }
        return ele;
    }

    /**
     * 向StringBuilder填充值
     *
     * @param ele 木火土金水的数量值
     * @param m   ele中的最大值或最小值
     * @param str 需要填充的字符
     * @return
     */
    private static StringBuilder appendSB(int[] ele, int m, String str) {
        StringBuilder elements = new StringBuilder(5);//所属或者所缺
        for (int i = 0; i < ele.length; i++) {
            if (m == ele[i]) {
                elements.append(str);
            } else {
                elements.append("0");
            }
        }
        return elements;
    }
}
