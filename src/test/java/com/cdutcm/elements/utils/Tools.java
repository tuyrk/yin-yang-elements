package com.cdutcm.elements.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Tools {
    public float[] Five(String bazi) {

        String y_g = bazi.substring(0, 1);
        String y_z = bazi.substring(1, 2);
        String m_g = bazi.substring(2, 3);
        String m_z = bazi.substring(3, 4);
        String d_g = bazi.substring(4, 5);
        String d_z = bazi.substring(5, 6);
        String h_g = bazi.substring(6, 7);
        String h_z = bazi.substring(7);

        int p = 0, q = 0;//p位天干，q为地支

//年天干取数
        p = NUM(y_g);
        q = NUM_1(y_z);


        double n = NUM_2(p, q);
        double jia2 = 0, yi2 = 0, bin2 = 0, din2 = 0, wu2 = 0, ji2 = 0, gen2 = 0, xin2 = 0, ren2 = 0, gui2 = 0;
        if (p == 1) jia2 = 18 + n + jia2;
        if (p == 2) yi2 = 18 + n + yi2;
        if (p == 3) bin2 = 18 + n + bin2;
        if (p == 4) din2 = 18 + n + din2;
        if (p == 5) wu2 = 18 + n + wu2;
        if (p == 6) ji2 = 18 + n + ji2;
        if (p == 7) gen2 = 18 + n + gen2;
        if (p == 8) xin2 = 18 + n + xin2;
        if (p == 9) ren2 = n + 18 + ren2;
        if (p == 10) gui2 = n + 18 + gui2;

        //地支藏天干取数
        double jia = 0, yi = 0, bin = 0, din = 0, wu = 0, ji = 0, gen = 0, xin = 0, ren = 0, gui = 0;
        double jia_1 = 0, yi_1 = 0, bin_1 = 0, din_1 = 0, wu_1 = 0, ji_1 = 0, gen_1 = 0, xin_1 = 0, ren_1 = 0, gui_1 = 0;

        if (q == 1) {
            ren = 10;
            gui = 20;
            jia = 0;
            yi = 0;
            bin = 0;
            din = 0;
            wu = 0;
            ji = 0;
            gen = 0;
            xin = 0;
        }
        if (q == 2) {
            ji = 18;
            xin = 3;
            gui = 9;
            jia = 0;
            yi = 0;
            bin = 0;
            din = 0;
            wu = 0;
            gen = 0;
            ren = 0;
        }
        if (q == 3) {
            jia = 16;
            bin = 7;
            wu = 7;
            yi = 0;
            din = 0;
            ji = 0;
            gen = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 4) {
            jia = 10;
            yi = 20;
            bin = 0;
            din = 0;
            wu = 0;
            ji = 0;
            gen = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 5) {
            yi = 9;
            wu = 18;
            gui = 3;
            jia = 0;
            bin = 0;
            din = 0;
            ji = 0;
            gen = 0;
            xin = 0;
            ren = 0;
        }
        if (q == 6) {
            bin = 16;
            wu = 5;
            gen = 9;
            jia = 0;
            yi = 0;
            din = 0;
            ji = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 7) {
            bin = 10;
            din = 11;
            ji = 9;
            jia = 0;
            yi = 0;
            wu = 0;
            gen = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 8) {
            yi = 3;
            din = 9;
            ji = 18;
            jia = 0;
            bin = 0;
            wu = 0;
            gen = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 9) {
            wu = 3;
            ji = 7;
            gen = 17;
            jia = 0;
            yi = 0;
            bin = 0;
            din = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 10) {
            gen = 10;
            xin = 20;
            jia = 0;
            yi = 0;
            bin = 0;
            din = 0;
            wu = 0;
            ji = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 11) {
            din = 3;
            wu = 18;
            xin = 9;
            jia = 0;
            yi = 0;
            bin = 0;
            ji = 0;
            gen = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 12) {
            jia = 5;
            wu = 7;
            ren = 18;
            yi = 0;
            bin = 0;
            din = 0;
            ji = 0;
            gen = 0;
            xin = 0;
            gui = 0;
        }

        jia_1 = jia_1 + jia;
        yi_1 = yi_1 + yi;
        bin_1 = bin_1 + bin;
        din_1 = din_1 + din;
        wu_1 = wu_1 + wu;
        ji_1 = ji_1 + ji;
        gen_1 = gen_1 + gen;
        xin_1 = xin_1 + xin;
        ren_1 = ren_1 + ren;
        gui_1 = gui_1 + gui;


//月天干取数
        p = NUM(m_g);
        q = NUM_1(m_z);

        //月支加权调用
        int q_1 = q;

        n = NUM_2(p, q);
        if (p == 1) jia2 = 18 + n + jia2;
        if (p == 2) yi2 = 18 + n + yi2;
        if (p == 3) bin2 = 18 + n + bin2;
        if (p == 4) din2 = 18 + n + din2;
        if (p == 5) wu2 = 18 + n + wu2;
        if (p == 6) ji2 = 18 + n + ji2;
        if (p == 7) gen2 = 18 + n + gen2;
        if (p == 8) xin2 = 18 + n + xin2;
        if (p == 9) ren2 = n + 18 + ren2;
        if (p == 10) gui2 = n + 18 + gui2;

        //地支藏天干取数

        if (q == 1) {
            ren = 10;
            gui = 20;
            jia = 0;
            yi = 0;
            bin = 0;
            din = 0;
            wu = 0;
            ji = 0;
            gen = 0;
            xin = 0;
        }
        if (q == 2) {
            ji = 18;
            xin = 3;
            gui = 9;
            jia = 0;
            yi = 0;
            bin = 0;
            din = 0;
            wu = 0;
            gen = 0;
            ren = 0;
        }
        if (q == 3) {
            jia = 16;
            bin = 7;
            wu = 7;
            yi = 0;
            din = 0;
            ji = 0;
            gen = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 4) {
            jia = 10;
            yi = 20;
            bin = 0;
            din = 0;
            wu = 0;
            ji = 0;
            gen = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 5) {
            yi = 9;
            wu = 18;
            gui = 3;
            jia = 0;
            bin = 0;
            din = 0;
            ji = 0;
            gen = 0;
            xin = 0;
            ren = 0;
        }
        if (q == 6) {
            bin = 16;
            wu = 5;
            gen = 9;
            jia = 0;
            yi = 0;
            din = 0;
            ji = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 7) {
            bin = 10;
            din = 11;
            ji = 9;
            jia = 0;
            yi = 0;
            wu = 0;
            gen = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 8) {
            yi = 3;
            din = 9;
            ji = 18;
            jia = 0;
            bin = 0;
            wu = 0;
            gen = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 9) {
            wu = 3;
            ji = 7;
            gen = 17;
            jia = 0;
            yi = 0;
            bin = 0;
            din = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 10) {
            gen = 10;
            xin = 20;
            jia = 0;
            yi = 0;
            bin = 0;
            din = 0;
            wu = 0;
            ji = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 11) {
            din = 3;
            wu = 18;
            xin = 9;
            jia = 0;
            yi = 0;
            bin = 0;
            ji = 0;
            gen = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 12) {
            jia = 5;
            wu = 7;
            ren = 18;
            yi = 0;
            bin = 0;
            din = 0;
            ji = 0;
            gen = 0;
            xin = 0;
            gui = 0;
        }

        jia_1 = jia_1 + jia;
        yi_1 = yi_1 + yi;
        bin_1 = bin_1 + bin;
        din_1 = din_1 + din;
        wu_1 = wu_1 + wu;
        ji_1 = ji_1 + ji;
        gen_1 = gen_1 + gen;
        xin_1 = xin_1 + xin;
        ren_1 = ren_1 + ren;
        gui_1 = gui_1 + gui;

//日天干取数
        p = NUM(d_g);
        q = NUM_1(d_z);

        n = NUM_2(p, q);
        if (p == 1) jia2 = 18 + n + jia2;
        if (p == 2) yi2 = 18 + n + yi2;
        if (p == 3) bin2 = 18 + n + bin2;
        if (p == 4) din2 = 18 + n + din2;
        if (p == 5) wu2 = 18 + n + wu2;
        if (p == 6) ji2 = 18 + n + ji2;
        if (p == 7) gen2 = 18 + n + gen2;
        if (p == 8) xin2 = 18 + n + xin2;
        if (p == 9) ren2 = n + 18 + ren2;
        if (p == 10) gui2 = n + 18 + gui2;

        //地支藏天干取数

        if (q == 1) {
            ren = 10;
            gui = 20;
            jia = 0;
            yi = 0;
            bin = 0;
            din = 0;
            wu = 0;
            ji = 0;
            gen = 0;
            xin = 0;
        }
        if (q == 2) {
            ji = 18;
            xin = 3;
            gui = 9;
            jia = 0;
            yi = 0;
            bin = 0;
            din = 0;
            wu = 0;
            gen = 0;
            ren = 0;
        }
        if (q == 3) {
            jia = 16;
            bin = 7;
            wu = 7;
            yi = 0;
            din = 0;
            ji = 0;
            gen = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 4) {
            jia = 10;
            yi = 20;
            bin = 0;
            din = 0;
            wu = 0;
            ji = 0;
            gen = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 5) {
            yi = 9;
            wu = 18;
            gui = 3;
            jia = 0;
            bin = 0;
            din = 0;
            ji = 0;
            gen = 0;
            xin = 0;
            ren = 0;
        }
        if (q == 6) {
            bin = 16;
            wu = 5;
            gen = 9;
            jia = 0;
            yi = 0;
            din = 0;
            ji = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 7) {
            bin = 10;
            din = 11;
            ji = 9;
            jia = 0;
            yi = 0;
            wu = 0;
            gen = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 8) {
            yi = 3;
            din = 9;
            ji = 18;
            jia = 0;
            bin = 0;
            wu = 0;
            gen = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 9) {
            wu = 3;
            ji = 7;
            gen = 17;
            jia = 0;
            yi = 0;
            bin = 0;
            din = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 10) {
            gen = 10;
            xin = 20;
            jia = 0;
            yi = 0;
            bin = 0;
            din = 0;
            wu = 0;
            ji = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 11) {
            din = 3;
            wu = 18;
            xin = 9;
            jia = 0;
            yi = 0;
            bin = 0;
            ji = 0;
            gen = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 12) {
            jia = 5;
            wu = 7;
            ren = 18;
            yi = 0;
            bin = 0;
            din = 0;
            ji = 0;
            gen = 0;
            xin = 0;
            gui = 0;
        }

        jia_1 = jia_1 + jia;
        yi_1 = yi_1 + yi;
        bin_1 = bin_1 + bin;
        din_1 = din_1 + din;
        wu_1 = wu_1 + wu;
        ji_1 = ji_1 + ji;
        gen_1 = gen_1 + gen;
        xin_1 = xin_1 + xin;
        ren_1 = ren_1 + ren;
        gui_1 = gui_1 + gui;

//时天干取数
        p = NUM(h_g);
        q = NUM_1(h_z);

        n = NUM_2(p, q);
        if (p == 1) jia2 = 18 + n + jia2;
        if (p == 2) yi2 = 18 + n + yi2;
        if (p == 3) bin2 = 18 + n + bin2;
        if (p == 4) din2 = 18 + n + din2;
        if (p == 5) wu2 = 18 + n + wu2;
        if (p == 6) ji2 = 18 + n + ji2;
        if (p == 7) gen2 = 18 + n + gen2;
        if (p == 8) xin2 = 18 + n + xin2;
        if (p == 9) ren2 = n + 18 + ren2;
        if (p == 10) gui2 = n + 18 + gui2;

        //地支藏天干取数

        if (q == 1) {
            ren = 10;
            gui = 20;
            jia = 0;
            yi = 0;
            bin = 0;
            din = 0;
            wu = 0;
            ji = 0;
            gen = 0;
            xin = 0;
        }
        if (q == 2) {
            ji = 18;
            xin = 3;
            gui = 9;
            jia = 0;
            yi = 0;
            bin = 0;
            din = 0;
            wu = 0;
            gen = 0;
            ren = 0;
        }
        if (q == 3) {
            jia = 16;
            bin = 7;
            wu = 7;
            yi = 0;
            din = 0;
            ji = 0;
            gen = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 4) {
            jia = 10;
            yi = 20;
            bin = 0;
            din = 0;
            wu = 0;
            ji = 0;
            gen = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 5) {
            yi = 9;
            wu = 18;
            gui = 3;
            jia = 0;
            bin = 0;
            din = 0;
            ji = 0;
            gen = 0;
            xin = 0;
            ren = 0;
        }
        if (q == 6) {
            bin = 16;
            wu = 5;
            gen = 9;
            jia = 0;
            yi = 0;
            din = 0;
            ji = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 7) {
            bin = 10;
            din = 11;
            ji = 9;
            jia = 0;
            yi = 0;
            wu = 0;
            gen = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 8) {
            yi = 3;
            din = 9;
            ji = 18;
            jia = 0;
            bin = 0;
            wu = 0;
            gen = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 9) {
            wu = 3;
            ji = 7;
            gen = 17;
            jia = 0;
            yi = 0;
            bin = 0;
            din = 0;
            xin = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 10) {
            gen = 10;
            xin = 20;
            jia = 0;
            yi = 0;
            bin = 0;
            din = 0;
            wu = 0;
            ji = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 11) {
            din = 3;
            wu = 18;
            xin = 9;
            jia = 0;
            yi = 0;
            bin = 0;
            ji = 0;
            gen = 0;
            ren = 0;
            gui = 0;
        }
        if (q == 12) {
            jia = 5;
            wu = 7;
            ren = 18;
            yi = 0;
            bin = 0;
            din = 0;
            ji = 0;
            gen = 0;
            xin = 0;
            gui = 0;
        }

        jia_1 = jia_1 + jia;
        yi_1 = yi_1 + yi;
        bin_1 = bin_1 + bin;
        din_1 = din_1 + din;
        wu_1 = wu_1 + wu;
        ji_1 = ji_1 + ji;
        gen_1 = gen_1 + gen;
        xin_1 = xin_1 + xin;
        ren_1 = ren_1 + ren;
        gui_1 = gui_1 + gui;

        //同类数值相加
        jia = jia2 + jia_1;
        yi = yi2 + yi_1;
        bin = bin2 + bin_1;
        din = din2 + din_1;
        wu = wu2 + wu_1;
        ji = ji2 + ji_1;
        gen = gen2 + gen_1;
        xin = xin2 + xin_1;
        ren = ren2 + ren_1;
        gui = gui2 + gui_1;

//月支加权
        if (q_1 == 3 || q_1 == 4) {
            jia = (1.2 * jia);
            yi = 1.2 * yi;
            bin = 1.1 * bin;
            din = 1.1 * din;
            ren = 1.0 * ren;
            gui = gui * 1.0;
            gen = gen * 0.9;
            xin = xin * 0.9;
            wu = wu * 0.8;
            ji = ji * 0.8;
        }
        if (q_1 == 5) {
            jia = 1.2 * jia;
            yi = 1.2 * yi;
            wu = wu * 1.1;
            ji = 1.1 * ji;
            bin = 1.0 * bin;
            din = 1.0 * din;
            ren = 0.9 * ren;
            gui = gui * 0.9;
            gen = gen * 0.8;
            xin = xin * 0.8;
        }
        if (q_1 == 6 || q_1 == 7) {
            bin = 1.2 * bin;
            din = 1.2 * din;
            wu = 1.1 * wu;
            ji = ji * 1.1;
            jia = 1.0 * jia;
            yi = yi * 1.0;
            ren = 0.9 * ren;
            gui = gui * 0.9;
            gen = gen * 0.8;
            xin = xin * 0.8;
        }
        if (q_1 == 8) {
            wu = 1.2 * wu;
            ji = 1.2 * ji;
            bin = 1.1 * bin;
            din = din * 1.1;
            gen = 1.0 * gen;
            xin = xin * 1.0;
            jia = 0.9 * jia;
            yi = yi * 0.9;
            ren = 0.8 * ren;
            gui = gui * 0.8;
        }
        if (q_1 == 9 || q_1 == 10) {
            gen = gen * 1.2;
            xin = xin * 1.2;
            ren = ren * 1.1;
            gui = gui * 1.1;
            wu = wu * 1.0;
            ji = ji * 1.0;
            bin = bin * 0.9;
            din = din * 0.9;
            jia = jia * 0.8;
            yi = yi * 0.8;
        }
        if (q_1 == 11) {
            wu = 1.2 * wu;
            ji = 1.2 * ji;
            gen = gen * 1.1;
            xin = xin * 1.1;
            bin = 1.0 * bin;
            din = 1.0 * din;
            ren = 0.9 * ren;
            gui = gui * 0.9;
            jia = jia * 0.8;
            yi = yi * 0.8;
        }
        if (q_1 == 12 || q_1 == 1) {
            ren = ren * 1.2;
            gui = gui * 1.2;
            jia = jia * 1.1;
            yi = yi * 1.1;
            gen = 1.0 * gen;
            xin = xin * 1.0;
            wu = wu * 0.9;
            ji = ji * 0.9;
            bin = bin * 0.8;
            din = din * 0.8;
        }
        if (q_1 == 2) {
            ren = ren * 1.2;
            gui = gui * 1.2;
            wu = wu * 1.1;
            ji = 1.1 * ji;
            gen = 1.0 * gen;
            xin = xin * 1.0;
            jia = 0.9 * jia;
            yi = yi * 0.9;
            bin = bin * 0.8;
            din = din * 0.8;
        }

//天干均值;
        double sum = 0;
        sum = jia + yi + bin + din + wu + ji + gen + xin + ren + gui;

        jia = jia / sum * 100 - 8.6;
        yi = yi / sum * 100 - 8.9;
        bin = bin / sum * 100 - 9.2;
        din = din / sum * 100 - 6.4;
        wu = wu / sum * 100 - 16.0;
        ji = ji / sum * 100 - 14.2;
        gen = gen / sum * 100 - 10.0;
        xin = xin / sum * 100 - 8.9;
        ren = ren / sum * 100 - 8.9;
        gui = gui / sum * 100 - 8.9;

        //同行相加
        double jin = 0, mu = 0, shui = 0, huo = 0, tu = 0;
        jin = gen + xin;
        mu = jia + yi;
        shui = ren + gui;
        huo = bin + din;
        tu = wu + ji;

        //四舍五入格式化数字
        DecimalFormat df1 = new DecimalFormat("#.0");

        float JIN_1 = Float.valueOf(df1.format(new BigDecimal(jin)));
        float MU_1 = Float.valueOf(df1.format(new BigDecimal(mu)));
        float SHUI_1 = Float.valueOf(df1.format(new BigDecimal(shui)));
        float HUO_1 = Float.valueOf(df1.format(new BigDecimal(huo)));
        float TU_1 = Float.valueOf(df1.format(new BigDecimal(tu)));

        float WX_array[] = new float[5];
        WX_array[0] = MU_1;
        WX_array[1] = HUO_1;
        WX_array[2] = TU_1;
        WX_array[3] = JIN_1;
        WX_array[4] = SHUI_1;

        return WX_array;
    }


    //以下为方法
    private int NUM(String y_g) {
        int p = 0;
        if (y_g.equals("甲")) p = 1;
        if (y_g.equals("乙")) p = 2;
        if (y_g.equals("丙")) p = 3;
        if (y_g.equals("丁")) p = 4;
        if (y_g.equals("戊")) p = 5;
        if (y_g.equals("己")) p = 6;
        if (y_g.equals("庚")) p = 7;
        if (y_g.equals("辛")) p = 8;
        if (y_g.equals("壬")) p = 9;
        if (y_g.equals("癸")) p = 10;
        return p;
    }

    private int NUM_1(String y_z) {
        int q = 0;
        if (y_z.equals("子")) q = 1;
        if (y_z.equals("丑")) q = 2;
        if (y_z.equals("寅")) q = 3;
        if (y_z.equals("卯")) q = 4;
        if (y_z.equals("辰")) q = 5;
        if (y_z.equals("巳")) q = 6;
        if (y_z.equals("午")) q = 7;
        if (y_z.equals("未")) q = 8;
        if (y_z.equals("申")) q = 9;
        if (y_z.equals("酉")) q = 10;
        if (y_z.equals("戌")) q = 11;
        if (y_z.equals("亥")) q = 12;
        return q;
    }

    private double NUM_2(int p, int q) {
        float n = 0;
        if (p == 1 && q == 9 || p == 2 && q == 10 || p == 3 && q == 1 || p == 4 && q == 12 || p == 5 && q == 3 || p == 6 && q == 4 || p == 7 && q == 7 || p == 8 && q == 6 || p == 9 && q == 11 || p == 10 && q == 8)
            n = 0;
        if (p == 1 && q == 11 || p == 2 && q == 2 || p == 3 && q == 9 || p == 4 && q == 10 || p == 5 && q == 1 || p == 6 && q == 12 || p == 7 && q == 3 || p == 8 && q == 4 || p == 9 && q == 7 || p == 10 && q == 6)
            n = 2;
        if (p == 1 && q == 7 || p == 2 && q == 6 || p == 3 && q == 5 || p == 4 && q == 2 || p == 5 && q == 9 || p == 6 && q == 10 || p == 7 && q == 1 || p == 8 && q == 12 || p == 9 && q == 3 || p == 10 && q == 4)
            n = 4;
        if (p == 1 && q == 5 || p == 2 && q == 8 || p == 3 && q == 11 || p == 4 && q == 8 || p == 5 && q == 5 || p == 6 && q == 2 || p == 7 && q == 11 || p == 8 && q == 8 || p == 9 && q == 5 || p == 10 && q == 2)
            n = 6;
        if (p == 1 && q == 1 || p == 2 && q == 12 || p == 3 && q == 3 || p == 4 && q == 4 || p == 5 && q == 11 || p == 6 && q == 8 || p == 7 && q == 5 || p == 8 && q == 2 || p == 9 && q == 9 || p == 10 && q == 10)
            n = 8;
        if (p == 1 && q == 3 || p == 2 && q == 4 || p == 3 && q == 7 || p == 4 && q == 6 || p == 5 && q == 7 || p == 6 && q == 6 || p == 7 && q == 9 || p == 8 && q == 10 || p == 9 && q == 1 || p == 10 && q == 12)
            n = 10;
        return n;
    }
}
