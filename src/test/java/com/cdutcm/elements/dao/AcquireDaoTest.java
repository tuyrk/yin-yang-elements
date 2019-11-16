package com.cdutcm.elements.dao;

import com.cdutcm.elements.ElementsApplicationTests;
import com.cdutcm.elements.entity.Acquire;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AcquireDaoTest extends ElementsApplicationTests {

    @Autowired
    private AcquireDao acquireDao;

    @Test
    public void insertAcquire() {
        Acquire acquire = new Acquire(1, "18382471393", "涂元坤",1, 2, 3, 4, 5, 5, 4, 3, 2, 1, "00001-00000-00010");
        System.out.println("insertAcquire = " + acquireDao.insertAcquire(acquire));
    }

    @Test
    public void deleteAcquire() {
        Acquire acquire = new Acquire(1, null, null, null, null, null, null, null, null, null, null, null, null, null);
        List<Acquire> acquireList = acquireDao.selectAcquire(acquire);
        acquire = acquireList.get(0);
        System.out.println("updateAcquire = " + acquireDao.deleteAcquire(acquire));
    }

    @Test
    public void updateAcquire() {
        Acquire acquire = new Acquire(1, null, null, null, null, null, null, null, null, null, null, null, null, null);
        List<Acquire> acquireList = acquireDao.selectAcquire(acquire);
        acquire = acquireList.get(0);
        acquire.setPhone("17711300214");
        System.out.println("updateAcquire = " + acquireDao.updateAcquire(acquire));
    }

    @Test
    public void selectAcquire() {
        Acquire acquire = new Acquire();
        System.out.println("insertAcquire = " + acquireDao.selectAcquire(acquire));
        acquire = new Acquire(1, null, null, null, null, null, null, null, null, null, null, null, null, null);
        System.out.println("insertAcquire = " + acquireDao.selectAcquire(acquire));
    }
}