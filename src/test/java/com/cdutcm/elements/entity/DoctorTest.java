package com.cdutcm.elements.entity;

import org.junit.Test;

public class DoctorTest {

    @Test
    public void equals() {
        Doctor doctor1 = new Doctor();
        doctor1.setRealname("涂元坤");
        Doctor doctor2 = new Doctor();
        doctor2.setRealname("涂元坤");
        doctor2.setPassword("123456");
        System.out.println("doctor1.equals(doctor2) = " + doctor1.equals(doctor2));
    }
}