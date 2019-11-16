package com.cdutcm.elements.entity;

import lombok.Data;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 0:17 星期一
 * Description:
 */
@Data
public class Doctor {
    private Integer dId;
    private String username;
    private String password;
    private String realname;
    private String mail;
    private Integer state;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), obj.getClass());
                Method getMethod = pd.getReadMethod();
                Object o1 = getMethod.invoke(this);
                Object o2 = getMethod.invoke(obj);
                if ((o1 == null && o2 != null) || (o1 != null && o2 == null)) {
                    return false;
                } else if (o1 != null && !o1.toString().equals(o2.toString())) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Doctor() {
    }

    public Doctor(String username) {
        this.username = username;
    }

    public Doctor(Integer dId, String username, String password, String realname, String mail, Integer state) {
        this.dId = dId;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.mail = mail;
        this.state = state;
    }
}