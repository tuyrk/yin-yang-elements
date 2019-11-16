package com.cdutcm.elements.entity;

import lombok.Data;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/6/6 9:54 星期三
 * Description:
 */
@Data
public class InbornPre {
    private Integer id;
    private String phone;
    private String name;
    private Float wood;
    private Float fire;
    private Float earth;
    private Float metal;
    private Float water;
    private String inborn;

    public InbornPre() {
    }

    public InbornPre(Integer id, String phone, String name, Float wood, Float fire, Float earth, Float metal, Float water, String inborn) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.wood = wood;
        this.fire = fire;
        this.earth = earth;
        this.metal = metal;
        this.water = water;
        this.inborn = inborn;
    }
}
