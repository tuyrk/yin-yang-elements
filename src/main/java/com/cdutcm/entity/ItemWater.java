package com.cdutcm.entity;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/13
 * Time: 15:38 星期三
 * Description:
 */
public class ItemWater {
    /**
     * ID
     */
    private Integer id;
    /**
     * 水
     */
    private String water;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 面色特点
     */
    private String waterComplexion;
    /**
     * 心理特征
     */
    private String waterPsychology;
    /**
     * 汗证
     */
    private String waterSweat;
    /**
     * 小便
     */
    private String waterUrine;
    /**
     * 腰膝症状
     */
    private String waterWaist;
    /**
     * 性欲
     */
    private String waterSexuality;
    /**
     * 遗精
     */
    private String waterSpermatorrhea;
    /**
     * 月经症状
     */
    private String waterMenstruate;
    /**
     * 带下症状
     */
    private String waterLeucorrhea;
    /**
     * 好发季节
     */
    private String waterSeason;
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
        return "ItemWater{" + "id=" + id + ", water=" + water + ", phone='" + phone + '\'' + ", waterComplexion='" + waterComplexion + '\'' + ", waterPsychology='" + waterPsychology + '\'' + ", waterSweat='" + waterSweat + '\'' + ", waterUrine='" + waterUrine + '\'' + ", waterWaist='" + waterWaist + '\'' + ", waterSexuality='" + waterSexuality + '\'' + ", waterSpermatorrhea='" + waterSpermatorrhea + '\'' + ", waterMenstruate='" + waterMenstruate + '\'' + ", waterLeucorrhea='" + waterLeucorrhea + '\'' + ", waterSeason='" + waterSeason + '\'' + ", qualitativeA=" + qualitativeA + ", qualitativeK=" + qualitativeK + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWaterComplexion() {
        return waterComplexion;
    }

    public void setWaterComplexion(String waterComplexion) {
        this.waterComplexion = waterComplexion;
    }

    public String getWaterPsychology() {
        return waterPsychology;
    }

    public void setWaterPsychology(String waterPsychology) {
        this.waterPsychology = waterPsychology;
    }

    public String getWaterSweat() {
        return waterSweat;
    }

    public void setWaterSweat(String waterSweat) {
        this.waterSweat = waterSweat;
    }

    public String getWaterUrine() {
        return waterUrine;
    }

    public void setWaterUrine(String waterUrine) {
        this.waterUrine = waterUrine;
    }

    public String getWaterWaist() {
        return waterWaist;
    }

    public void setWaterWaist(String waterWaist) {
        this.waterWaist = waterWaist;
    }

    public String getWaterSexuality() {
        return waterSexuality;
    }

    public void setWaterSexuality(String waterSexuality) {
        this.waterSexuality = waterSexuality;
    }

    public String getWaterSpermatorrhea() {
        return waterSpermatorrhea;
    }

    public void setWaterSpermatorrhea(String waterSpermatorrhea) {
        this.waterSpermatorrhea = waterSpermatorrhea;
    }

    public String getWaterMenstruate() {
        return waterMenstruate;
    }

    public void setWaterMenstruate(String waterMenstruate) {
        this.waterMenstruate = waterMenstruate;
    }

    public String getWaterLeucorrhea() {
        return waterLeucorrhea;
    }

    public void setWaterLeucorrhea(String waterLeucorrhea) {
        this.waterLeucorrhea = waterLeucorrhea;
    }

    public String getWaterSeason() {
        return waterSeason;
    }

    public void setWaterSeason(String waterSeason) {
        this.waterSeason = waterSeason;
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
