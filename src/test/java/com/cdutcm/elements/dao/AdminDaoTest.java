package com.cdutcm.elements.dao;

import com.cdutcm.elements.ElementsApplicationTests;
import com.cdutcm.elements.entity.Admin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class AdminDaoTest extends ElementsApplicationTests {

    @Autowired
    private AdminDao adminDao;

    @Test
    public void insertAdmin() {
        Admin admin = new Admin(1, "tyk", "123456", 1);
        System.out.println("insertAdmin:" + adminDao.insertAdmin(admin));
    }

    @Test
    public void deleteAdmin() {
        Admin admin = new Admin(1, null, null, null);
        System.out.println("deleteAdmin:" + adminDao.deleteAdmin(admin));
    }

    @Test
    public void updateAdmin() {
        Admin admin = new Admin(1, null, null, null);
        admin = adminDao.selectAdmin(admin).get(0);
        admin.setUsername("涂元坤");
        System.out.println("updateAdmin:" + adminDao.updateAdmin(admin));
    }

    @Test
    public void selectAdmin() {
        Admin admin = new Admin(1, null, null, null);
        System.out.println("selectAdmin:" + adminDao.selectAdmin(admin));
    }


}