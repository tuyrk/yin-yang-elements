package com.cdutcm.entity;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/13
 * Time: 15:24 星期三
 * Description:
 */
public class Conclusion {
    /**
     * ID
     */
    private int id;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 公历出生日期
     */
    private String solarBirth;
    /**
     * 农历出生日期
     */
    private String lunarBirth;
    /**
     * 年干
     */
    private String niangan;
    /**
     * 年支
     */
    private String nianzhi;
    /**
     * 月干
     */
    private String yuegan;
    /**
     * 月支
     */
    private String yuezhi;
    /**
     * 日干
     */
    private String rigan;
    /**
     * 日支
     */
    private String rizhi;
    /**
     * 时干
     */
    private String shigan;
    /**
     * 时支
     */
    private String shizhi;
    /**
     * 木
     */
    private Float wood;
    /**
     * 火
     */
    private Float fire;
    /**
     * 土
     */
    private Float earth;
    /**
     * 金
     */
    private Float metal;
    /**
     * 水
     */
    private Float water;
    /**
     * 先天五行所属
     */
    private String inbornGenus;
    /**
     * 先天五行所缺
     */
    private String inbornLack;
    /**
     * 后天五行所属 11000
     */
    private String acquireGenus;
    /**
     * 后天五行所缺次 00111[缺] 00222[次]
     */
    private String acquireLack;
    /**
     * 所属阳值1
     */
    private int yangValue1;
    /**
     * 所属阳值2
     */
    private int yangValue2;
    /**
     * 所属阳值3
     */
    private int yangValue3;
    /**
     * 所属阴值1
     */
    private int yinValue1;
    /**
     * 所属阴值2
     */
    private int yinValue2;
    /**
     * 所属阴值3
     */
    private int yinValue3;

    @Override
    public String toString() {
        return "Conclusion{" + "id=" + id + ", phone='" + phone + '\'' + ", name='" + name + '\'' + ", sex='" + sex + '\'' + ", solarBirth='" + solarBirth + '\'' + ", lunarBirth='" + lunarBirth + '\'' + ", niangan='" + niangan + '\'' + ", nianzhi='" + nianzhi + '\'' + ", yuegan='" + yuegan + '\'' + ", yuezhi='" + yuezhi + '\'' + ", rigan='" + rigan + '\'' + ", rizhi='" + rizhi + '\'' + ", shigan='" + shigan + '\'' + ", shizhi='" + shizhi + '\'' + ", wood=" + wood + ", fire=" + fire + ", earth=" + earth + ", metal=" + metal + ", water=" + water + ", inbornGenus='" + inbornGenus + '\'' + ", inbornLack='" + inbornLack + '\'' + ", acquireGenus='" + acquireGenus + '\'' + ", acquireLack='" + acquireLack + '\'' + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSolarBirth() {
        return solarBirth;
    }

    public void setSolarBirth(String solarBirth) {
        this.solarBirth = solarBirth;
    }

    public String getLunarBirth() {
        return lunarBirth;
    }

    public void setLunarBirth(String lunarBirth) {
        this.lunarBirth = lunarBirth;
    }

    public String getNiangan() {
        return niangan;
    }

    public void setNiangan(String niangan) {
        this.niangan = niangan;
    }

    public String getNianzhi() {
        return nianzhi;
    }

    public void setNianzhi(String nianzhi) {
        this.nianzhi = nianzhi;
    }

    public String getYuegan() {
        return yuegan;
    }

    public void setYuegan(String yuegan) {
        this.yuegan = yuegan;
    }

    public String getYuezhi() {
        return yuezhi;
    }

    public void setYuezhi(String yuezhi) {
        this.yuezhi = yuezhi;
    }

    public String getRigan() {
        return rigan;
    }

    public void setRigan(String rigan) {
        this.rigan = rigan;
    }

    public String getRizhi() {
        return rizhi;
    }

    public void setRizhi(String rizhi) {
        this.rizhi = rizhi;
    }

    public String getShigan() {
        return shigan;
    }

    public void setShigan(String shigan) {
        this.shigan = shigan;
    }

    public String getShizhi() {
        return shizhi;
    }

    public void setShizhi(String shizhi) {
        this.shizhi = shizhi;
    }

    public Float getWood() {
        return wood;
    }

    public void setWood(Float wood) {
        this.wood = wood;
    }

    public Float getFire() {
        return fire;
    }

    public void setFire(Float fire) {
        this.fire = fire;
    }

    public Float getEarth() {
        return earth;
    }

    public void setEarth(Float earth) {
        this.earth = earth;
    }

    public Float getMetal() {
        return metal;
    }

    public void setMetal(Float metal) {
        this.metal = metal;
    }

    public Float getWater() {
        return water;
    }

    public void setWater(Float water) {
        this.water = water;
    }

    public String getInbornGenus() {
        return inbornGenus;
    }

    public void setInbornGenus(String inbornGenus) {
        this.inbornGenus = inbornGenus;
    }

    public String getInbornLack() {
        return inbornLack;
    }

    public void setInbornLack(String inbornLack) {
        this.inbornLack = inbornLack;
    }

    public String getAcquireGenus() {
        return acquireGenus;
    }

    public void setAcquireGenus(String acquireGenus) {
        this.acquireGenus = acquireGenus;
    }

    public String getAcquireLack() {
        return acquireLack;
    }

    public void setAcquireLack(String acquireLack) {
        this.acquireLack = acquireLack;
    }

    public int getYangValue1() {
        return yangValue1;
    }

    public void setYangValue1(int yangValue1) {
        this.yangValue1 = yangValue1;
    }

    public int getYangValue2() {
        return yangValue2;
    }

    public void setYangValue2(int yangValue2) {
        this.yangValue2 = yangValue2;
    }

    public int getYangValue3() {
        return yangValue3;
    }

    public void setYangValue3(int yangValue3) {
        this.yangValue3 = yangValue3;
    }

    public int getYinValue1() {
        return yinValue1;
    }

    public void setYinValue1(int yinValue1) {
        this.yinValue1 = yinValue1;
    }

    public int getYinValue2() {
        return yinValue2;
    }

    public void setYinValue2(int yinValue2) {
        this.yinValue2 = yinValue2;
    }

    public int getYinValue3() {
        return yinValue3;
    }

    public void setYinValue3(int yinValue3) {
        this.yinValue3 = yinValue3;
    }

}
