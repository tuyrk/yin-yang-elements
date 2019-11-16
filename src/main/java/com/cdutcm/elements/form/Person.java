package com.cdutcm.elements.form;

import lombok.Data;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 12:01 星期一
 * Description:
 */
@Data
public class Person {
    private String name;
    private String birth;
    private String sex;
    private String phone;

    public Person() {
    }

    public Person(String name, String birth, String sex, String phone) {
        this.name = name;
        this.birth = birth;
        this.sex = sex;
        this.phone = phone;
    }
}
