package com.cdutcm.entity;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/13
 * Time: 15:37 星期三
 * Description:
 */
public class ItemMetal {
    /**
     * ID
     */
    private Integer id;
    /**
     * 金
     */
    private String metal;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 面色特点
     */
    private String metalComplexion;
    /**
     * 心理特征
     */
    private String metalPsychology;
    /**
     * 汗证
     */
    private String metalSweat;
    /**
     * 饮食口味
     */
    private String metalDiet;
    /**
     * 大便
     */
    private String metalShit;
    /**
     * 精神状态
     */
    private String metalMental;
    /**
     * 咳嗽
     */
    private String metalCough;
    /**
     * 咯痰
     */
    private String metalExpectoration;
    /**
     * 鼻部症状
     */
    private String metalNose;
    /**
     * 皮肤
     */
    private String metalSkin;
    /**
     * 好发季节
     */
    private String metalSeason;
    /**
     * 定性正值
     */
    private Integer qualitativeA;
    /**
     * 定性负值
     */
    private Integer qualitativeK;

    @Override
    public String toString() {
        return "ItemMetal{" + "id=" + id + ", metal=" + metal + ", phone='" + phone + '\'' + ", metalComplexion='" + metalComplexion + '\'' + ", metalPsychology='" + metalPsychology + '\'' + ", metalSweat='" + metalSweat + '\'' + ", metalDiet='" + metalDiet + '\'' + ", metalShit='" + metalShit + '\'' + ", metalMental='" + metalMental + '\'' + ", metalCough='" + metalCough + '\'' + ", metalExpectoration='" + metalExpectoration + '\'' + ", metalNose='" + metalNose + '\'' + ", metalSkin='" + metalSkin + '\'' + ", metalSeason='" + metalSeason + '\'' + ", qualitativeA=" + qualitativeA + ", qualitativeK=" + qualitativeK + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMetalComplexion() {
        return metalComplexion;
    }

    public void setMetalComplexion(String metalComplexion) {
        this.metalComplexion = metalComplexion;
    }

    public String getMetalPsychology() {
        return metalPsychology;
    }

    public void setMetalPsychology(String metalPsychology) {
        this.metalPsychology = metalPsychology;
    }

    public String getMetalSweat() {
        return metalSweat;
    }

    public void setMetalSweat(String metalSweat) {
        this.metalSweat = metalSweat;
    }

    public String getMetalDiet() {
        return metalDiet;
    }

    public void setMetalDiet(String metalDiet) {
        this.metalDiet = metalDiet;
    }

    public String getMetalShit() {
        return metalShit;
    }

    public void setMetalShit(String metalShit) {
        this.metalShit = metalShit;
    }

    public String getMetalMental() {
        return metalMental;
    }

    public void setMetalMental(String metalMental) {
        this.metalMental = metalMental;
    }

    public String getMetalCough() {
        return metalCough;
    }

    public void setMetalCough(String metalCough) {
        this.metalCough = metalCough;
    }

    public String getMetalExpectoration() {
        return metalExpectoration;
    }

    public void setMetalExpectoration(String metalExpectoration) {
        this.metalExpectoration = metalExpectoration;
    }

    public String getMetalNose() {
        return metalNose;
    }

    public void setMetalNose(String metalNose) {
        this.metalNose = metalNose;
    }

    public String getMetalSkin() {
        return metalSkin;
    }

    public void setMetalSkin(String metalSkin) {
        this.metalSkin = metalSkin;
    }

    public String getMetalSeason() {
        return metalSeason;
    }

    public void setMetalSeason(String metalSeason) {
        this.metalSeason = metalSeason;
    }

    public Integer getQualitativeA() {
        return qualitativeA;
    }

    public void setQualitativeA(Integer qualitativeA) {
        this.qualitativeA = qualitativeA;
    }

    public Integer getQualitativeK() {
        return qualitativeK;
    }

    public void setQualitativeK(Integer qualitativeK) {
        this.qualitativeK = qualitativeK;
    }
}
