package com.cdutcm.elements.entity;

import lombok.Data;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/18 9:28 星期五
 * Description:
 */
@Data
public class Acquire {
    private Integer id;
    private String phone;
    private String name;
    private Integer wood;
    private Integer fire;
    private Integer earth;
    private Integer metal;
    private Integer water;
    private Integer yinYangWood;
    private Integer yinYangFire;
    private Integer yinYangEarth;
    private Integer yinYangMetal;
    private Integer yinYangWater;
    private String acquire;

    public Acquire() {
    }

    public Acquire(Integer id, String phone, String name, Integer wood, Integer fire, Integer earth, Integer metal, Integer water, Integer yinYangWood, Integer yinYangFire, Integer yinYangEarth, Integer yinYangMetal, Integer yinYangWater, String acquire) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.wood = wood;
        this.fire = fire;
        this.earth = earth;
        this.metal = metal;
        this.water = water;
        this.yinYangWood = yinYangWood;
        this.yinYangFire = yinYangFire;
        this.yinYangEarth = yinYangEarth;
        this.yinYangMetal = yinYangMetal;
        this.yinYangWater = yinYangWater;
        this.acquire = acquire;
    }
}
