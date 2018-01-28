package com.cdutcm.model;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/17
 * Time: 0:08 星期日
 * Description:
 * 受访者类(被采访的人)
 */
public class Respondent {
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
     * 出生日期
     */
    private Birth birth;

    /**
     * 先天所属
     */
    private String acquireGenus;

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

    public Birth getBirth() {
        return birth;
    }

    public void setBirth(Birth birth) {
        this.birth = birth;
    }

    public String getAcquireGenus() {
        return acquireGenus;
    }

    public void setAcquireGenus(String acquireGenus) {
        this.acquireGenus = acquireGenus;
    }
}

