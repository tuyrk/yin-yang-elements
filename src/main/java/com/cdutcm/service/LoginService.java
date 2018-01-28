package com.cdutcm.service;

import com.cdutcm.entity.Doctor;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/26
 * Time: 16:13 星期二
 * Description:
 */
public interface LoginService {

    String sendMail(String email, String flag);

    Doctor checkDoctor(Doctor doctor);

    boolean checkDoctorByUsername(String username);

    boolean checkDoctorByMail(String mail);

    boolean regist(Doctor doctor);

    boolean modifyPassword(Doctor doctor);

    boolean modifyMail(String newMail, Doctor doctor);

    boolean checkPassword(String modifyPassword, Doctor doctor);
}
