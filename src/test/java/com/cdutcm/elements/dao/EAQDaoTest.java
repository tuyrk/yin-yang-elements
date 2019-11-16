package com.cdutcm.elements.dao;

import com.cdutcm.elements.ElementsApplicationTests;
import com.cdutcm.elements.entity.EAQ;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class EAQDaoTest extends ElementsApplicationTests {

    @Autowired
    private EAQDao eaqDao;

    @Test
    public void insertEAQ() {
        EAQ eaq = new EAQ(1, "18382471393", "A-Ab-C-D-B", "Bc", "A-C-I-D-E-B-D", "A-B-C-A-A-C", "A-B-C", "A-B-C-A-A", "A-B-C-A", "A-B-C-A", "C", "D");
        System.out.println("insertEAQ:" + eaqDao.insertEAQ(eaq));
    }

    @Test
    public void deleteEAQ() {
        EAQ eaq = new EAQ(1, null, null, null, null, null, null, null, null, null, null, null);
        System.out.println("deleteEAQ:" + eaqDao.deleteEAQ(eaq));
    }

    @Test
    public void updateEAQ() {
        EAQ eaq = new EAQ(1, null, null, null, null, null, null, null, null, null, null, null);
        eaq = eaqDao.selectEAQByEaq(eaq);
        eaq.setPhone("13547193423");
        System.out.println("updateEAQ:" + eaqDao.updateEAQ(eaq));
    }

    @Test
    public void selectEAQByEaq() {
        EAQ eaq = new EAQ(1, null, null, null, null, null, null, null, null, null, null, null);
        System.out.println("selectEAQByEaq:" + eaqDao.selectEAQByEaq(eaq));
    }

    @Test
    public void selectEAQByPhone() {
        String phone = "18382471393";
        System.out.println("selectEAQByPhone:" + eaqDao.selectEAQByPhone(phone));
    }
}