package com.cdutcm.entity;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/13
 * Time: 15:21 星期三
 * Description:
 */
public class Category implements Comparable {
    /**
     * ID
     */
    private Integer id;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 脸形特点
     */
    private String feature;
    /**
     * 面色特点
     */
    private String complexion;
    /**
     * 躯干特点
     */
    private String trunk;
    /**
     * 四肢特点
     */
    private String limb;
    /**
     * 语音特点
     */
    private String voice;
    /**
     * 心理特征
     */
    private String psychology;
    /**
     * 好发病位
     */
    private String disease;

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", phone='" + phone + '\'' + ", feature='" + feature + '\'' + ", complexion='" + complexion + '\'' + ", trunk='" + trunk + '\'' + ", limb='" + limb + '\'' + ", voice='" + voice + '\'' + ", psychology='" + psychology + '\'' + ", disease='" + disease + '\'' + '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o != null && o instanceof Category) {
            Category category = (Category) o;
            if (this.feature.equals(category.feature) && this.complexion.equals(category.complexion) && this.trunk.equals(category.trunk) && this.limb.equals(category.limb) && this.voice.equals(category.voice) && this.psychology.equals(category.psychology) && this.disease.equals(category.disease)) {
                return 0;
            }
        }
        return 1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getComplexion() {
        return complexion;
    }

    public void setComplexion(String complexion) {
        this.complexion = complexion;
    }

    public String getTrunk() {
        return trunk;
    }

    public void setTrunk(String trunk) {
        this.trunk = trunk;
    }

    public String getLimb() {
        return limb;
    }

    public void setLimb(String limb) {
        this.limb = limb;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getPsychology() {
        return psychology;
    }

    public void setPsychology(String psychology) {
        this.psychology = psychology;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
