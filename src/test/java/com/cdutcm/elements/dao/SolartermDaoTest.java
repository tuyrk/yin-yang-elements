package com.cdutcm.elements.dao;

import com.cdutcm.elements.ElementsApplicationTests;
import com.cdutcm.elements.entity.Solarterm;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

public class SolartermDaoTest extends ElementsApplicationTests {

    @Autowired
    private SolartermDao solartermDao;

    @Test
    public void selectLichunByYear() {
        System.out.println("selectLichunByYear:" + solartermDao.selectLichunByYear(1900));
    }

    @Test
    public void selectSolartermByDate() {
        System.out.println("selectSolartermByDate:" + solartermDao.selectSolartermByDate(new Date()));
    }
}