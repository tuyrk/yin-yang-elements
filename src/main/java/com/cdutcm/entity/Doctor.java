package com.cdutcm.entity;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/13
 * Time: 15:29 星期三
 * Description:
 */
public class Doctor {
    /**
     * ID
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 激活状态 0[未审核]、1[审核通过]
     */
    private String state;

    @Override
    public String toString() {
        return "Doctor{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", name='" + name + '\'' + ", mail='" + mail + '\'' + ", state='" + state + '\'' + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
