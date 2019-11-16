package com.cdutcm.elements.entity;

import lombok.Data;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 0:15 星期一
 * Description:
 */
@Data
public class Inborn {
    private Integer cId;
    private String phone;
    private String name;
    private String sex;
    private String solarBirth;
    private String lunarBirth;
    private String horoscope;
    private Float wood;
    private Float fire;
    private Float earth;
    private Float metal;
    private Float water;
    private String inborn;

    public Inborn() {
    }

    public Inborn(Integer cId, String phone, String name, String sex, String solarBirth, String lunarBirth, String horoscope, Float wood, Float fire, Float earth, Float metal, Float water, String inborn) {
        this.cId = cId;
        this.phone = phone;
        this.name = name;
        this.sex = sex;
        this.solarBirth = solarBirth;
        this.lunarBirth = lunarBirth;
        this.horoscope = horoscope;
        this.wood = wood;
        this.fire = fire;
        this.earth = earth;
        this.metal = metal;
        this.water = water;
        this.inborn = inborn;
    }
}