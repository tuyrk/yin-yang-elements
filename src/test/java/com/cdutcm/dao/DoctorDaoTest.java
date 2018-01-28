package com.cdutcm.dao;

import com.cdutcm.BaseTest;
import com.cdutcm.entity.Doctor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/28
 * Time: 12:34 星期四
 * Description:
 */
public class DoctorDaoTest extends BaseTest {

    @Autowired
    private DoctorDao doctorDao;

    @Test
    public void selectByUsername() {
        Doctor doctor = new Doctor();
        doctor.setUsername("tyk");
        doctor.setPassword("e10adc3949ba59abbe56e057f20f883e");
        doctor.setMail("766564616@qq.com");
        System.out.println("result = " + doctorDao.selectDoctor(doctor));
    }

    @Test
    public void updateDoctor() {
        Doctor doctor = new Doctor();
        doctor.setPassword("123456");
        doctor.setMail("766564616@qq.com");
        System.out.println("result = " + doctorDao.updateDoctor(null, doctor));
    }
}
