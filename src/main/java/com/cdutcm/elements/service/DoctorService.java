package com.cdutcm.elements.service;

import com.cdutcm.elements.entity.Doctor;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 14:27 星期一
 * Description:
 */
public interface DoctorService {
    boolean insertDoctor(Doctor doctor, Doctor sessionDoctor);

    boolean deleteDoctor(Doctor doctor);

    Doctor updateDoctor(Doctor doctor, Doctor selectDoctor);

    Doctor selectDoctor(Doctor doctor);
}
