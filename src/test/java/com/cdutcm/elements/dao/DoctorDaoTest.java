package com.cdutcm.elements.dao;

import com.cdutcm.elements.ElementsApplicationTests;
import com.cdutcm.elements.entity.Doctor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DoctorDaoTest extends ElementsApplicationTests {

    @Autowired
    private DoctorDao doctorDao;

    @Test
    public void insertDoctor() {
        Doctor doctor = new Doctor(1, "tyk", "123456", "涂元坤", "766564616@qq.com", 1);
        System.out.println("insertDoctor:" + doctorDao.insertDoctor(doctor));
    }

    @Test
    public void deleteDoctor() {
        Doctor doctor = new Doctor(1, null, null, null, null, null);
        System.out.println("deleteDoctor:" + doctorDao.deleteDoctor(doctor));
    }

    @Test
    public void updateDoctor() {
        Doctor doctor = new Doctor(1, "tyk", null, null, null, null);
        doctor = doctorDao.selectDoctor(doctor).get(0);
        doctor.setPassword("507889");
        System.out.println("updateDoctor:" + doctorDao.updateDoctor(doctor));
    }

    @Test
    public void selectDoctor() {
        Doctor doctor = new Doctor(1, null, null, null, null, null);
        System.out.println("selectDoctor:" + doctorDao.selectDoctor(doctor));
    }

    @Test
    public void selectDoctorByUsernameOrMail() {
        System.out.println("doctorDao.selectDoctorByUsernameOrMail(\"tyk\", \"766564616@qq.com\") = " + doctorDao.selectDoctorByUsernameOrMail("tyk", "766564616@qq.com"));;
    }
}