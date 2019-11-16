package com.cdutcm.elements.form;

import lombok.Data;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 12:04 星期一
 * Description:
 * 属性命名根据前台 name 来命名的。
 */
@Data
public class Category {
    //p_f 体貌特征
    private String lianXing;
    private String mianSe;
    private String quGan;
    private String siZhi;
    private String yuYin;
    //p_p 心理特征
    private String xingLi;
    //v_s 生命特征
    private String hanRe;
    private String han;
    private String yinShiKouWei;
    private String daBian;
    private String xiaoBian;
    private String shuiMian;
    private String jingShengZhuangTai;
    //t_m 好发症状-木行人
    private String touBu;
    private String shuangMu;
    private String xiongXie;
    private String zhiTi;
    private String yueJing;
    private String yiFaMu;
    //f_m 好发症状-火行人
    private String kouChun;
    private String xinXiong;
    private String yiFaHuo;
    //s_m 好发症状-土行人
    private String touShen;
    private String sheChun;
    private String weiWan;
    private String fuBu;
    private String yiFaTu;
    //g_m 好发症状-金行人
    private String keSou;
    private String geTan;
    private String biBu;
    private String piFu;
    //w_m 好发症状-水行人
    private String yaoQi;
    private String xingYu;
    private String yiJing;
    private String daiXia;
    //h_s 好发季节
    private String haoFaJiJie;
    //h_d 好发病位
    private String haoFaBingWei;


    public Category() {
    }

    public Category(String lianXing, String mianSe, String quGan, String siZhi, String yuYin, String xingLi, String hanRe, String han, String yinShiKouWei, String daBian, String xiaoBian, String shuiMian, String jingShengZhuangTai, String touBu, String shuangMu, String xiongXie, String zhiTi, String yueJing, String yiFaMu, String kouChun, String xinXiong, String yiFaHuo, String touShen, String sheChun, String weiWan, String fuBu, String yiFaTu, String keSou, String geTan, String biBu, String piFu, String yaoQi, String xingYu, String yiJing, String daiXia, String haoFaJiJie, String haoFaBingWei) {
        this.lianXing = lianXing;
        this.mianSe = mianSe;
        this.quGan = quGan;
        this.siZhi = siZhi;
        this.yuYin = yuYin;
        this.xingLi = xingLi;
        this.hanRe = hanRe;
        this.han = han;
        this.yinShiKouWei = yinShiKouWei;
        this.daBian = daBian;
        this.xiaoBian = xiaoBian;
        this.shuiMian = shuiMian;
        this.jingShengZhuangTai = jingShengZhuangTai;
        this.touBu = touBu;
        this.shuangMu = shuangMu;
        this.xiongXie = xiongXie;
        this.zhiTi = zhiTi;
        this.yueJing = yueJing;
        this.yiFaMu = yiFaMu;
        this.kouChun = kouChun;
        this.xinXiong = xinXiong;
        this.yiFaHuo = yiFaHuo;
        this.touShen = touShen;
        this.sheChun = sheChun;
        this.weiWan = weiWan;
        this.fuBu = fuBu;
        this.yiFaTu = yiFaTu;
        this.keSou = keSou;
        this.geTan = geTan;
        this.biBu = biBu;
        this.piFu = piFu;
        this.yaoQi = yaoQi;
        this.xingYu = xingYu;
        this.yiJing = yiJing;
        this.daiXia = daiXia;
        this.haoFaJiJie = haoFaJiJie;
        this.haoFaBingWei = haoFaBingWei;
    }
}
