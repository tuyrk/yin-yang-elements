package com.cdutcm.entity;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/13
 * Time: 15:32 星期三
 * Description:
 */
public class ItemEarth {
    /**
     * ID
     */
    private Integer id;
    /**
     * 土
     */
    private String earth;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 面色特点
     */
    private String earthComplexion;
    /**
     * 心理特征
     */
    private String earthPsychology;
    /**
     * 饮食口味
     */
    private String earthDiet;
    /**
     * 大便
     */
    private String earthShit;
    /**
     * 精神状态
     */
    private String earthMental;
    /**
     * 头身症状
     */
    private String earthBody;
    /**
     * 口唇症状
     */
    private String earthLips;
    /**
     * 胃脘症状
     */
    private String earthStomach;
    /**
     * 好发季节
     */
    private String earthSeason;
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
        return "ItemEarth{" + "id=" + id + ", earth=" + earth + ", phone='" + phone + '\'' + ", earthComplexion='" + earthComplexion + '\'' + ", earthPsychology='" + earthPsychology + '\'' + ", earthDiet='" + earthDiet + '\'' + ", earthShit='" + earthShit + '\'' + ", earthMental='" + earthMental + '\'' + ", earthBody='" + earthBody + '\'' + ", earthLips='" + earthLips + '\'' + ", earthStomach='" + earthStomach + '\'' + ", earthSeason='" + earthSeason + '\'' + ", qualitativeA=" + qualitativeA + ", qualitativeK=" + qualitativeK + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEarth() {
        return earth;
    }

    public void setEarth(String earth) {
        this.earth = earth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEarthComplexion() {
        return earthComplexion;
    }

    public void setEarthComplexion(String earthComplexion) {
        this.earthComplexion = earthComplexion;
    }

    public String getEarthPsychology() {
        return earthPsychology;
    }

    public void setEarthPsychology(String earthPsychology) {
        this.earthPsychology = earthPsychology;
    }

    public String getEarthDiet() {
        return earthDiet;
    }

    public void setEarthDiet(String earthDiet) {
        this.earthDiet = earthDiet;
    }

    public String getEarthShit() {
        return earthShit;
    }

    public void setEarthShit(String earthShit) {
        this.earthShit = earthShit;
    }

    public String getEarthMental() {
        return earthMental;
    }

    public void setEarthMental(String earthMental) {
        this.earthMental = earthMental;
    }

    public String getEarthBody() {
        return earthBody;
    }

    public void setEarthBody(String earthBody) {
        this.earthBody = earthBody;
    }

    public String getEarthLips() {
        return earthLips;
    }

    public void setEarthLips(String earthLips) {
        this.earthLips = earthLips;
    }

    public String getEarthStomach() {
        return earthStomach;
    }

    public void setEarthStomach(String earthStomach) {
        this.earthStomach = earthStomach;
    }

    public String getEarthSeason() {
        return earthSeason;
    }

    public void setEarthSeason(String earthSeason) {
        this.earthSeason = earthSeason;
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
