package com.cdutcm.elements.dao;

import com.cdutcm.elements.ElementsApplicationTests;
import com.cdutcm.elements.entity.Inborn;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class InbornDaoTest extends ElementsApplicationTests {

    @Autowired
    private InbornDao inbornDao;

    @Test
    public void insertInborn() {
        /*
        日期格式：
            公历:2018-05-15 08
            农历:2017-06-01 08
         */
        Inborn inborn = new Inborn(1, "18382471393", "涂元坤", "男", "2018-05-15 08", "2017-闰06-01 08", "甲子甲子甲子甲子", 0f, 0f, 0f, 0f, 0f, "10000-00001-01000");
        System.out.println("insertInborn:" + inbornDao.insertInborn(inborn));
    }

    @Test
    public void deleteInborn() {
        Inborn inborn = new Inborn(1, null, null, null, null, null, null, null, null, null, null, null, null);
        System.out.println("deleteInborn:" + inbornDao.deleteInborn(inborn));
    }

    @Test
    public void updateInborn() {
        Inborn inborn = new Inborn(1, null, null, null,  null, null, null, null, null, null, null, null, null);
        inborn = inbornDao.selectInborn(inborn).get(0);
        inborn.setLunarBirth("2017-闰06-05 08");
        System.out.println("updateInborn:" + inbornDao.updateInborn(inborn));
    }

    @Test
    public void selectInborn() {
        Inborn inborn = new Inborn();
        System.out.println("selectInborn:" + inbornDao.selectInborn(inborn));
        inborn.setCId(1);
        System.out.println("selectInborn:" + inbornDao.selectInborn(inborn));

    }


}