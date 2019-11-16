package com.cdutcm.elements.entity;

import lombok.Data;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 0:13 星期一
 * Description:
 */
@Data
public class Admin {
    private Integer aId;
    private String username;
    private String password;
    private Integer power;

    public Admin(Integer aId, String username, String password, Integer power) {
        this.aId = aId;
        this.username = username;
        this.password = password;
        this.power = power;
    }
}