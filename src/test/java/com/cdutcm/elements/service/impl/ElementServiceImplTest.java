package com.cdutcm.elements.service.impl;

import com.cdutcm.elements.ElementsApplicationTests;
import com.cdutcm.elements.entity.Acquire;
import com.cdutcm.elements.entity.Inborn;
import com.cdutcm.elements.form.Person;
import com.cdutcm.elements.service.AcquireService;
import com.cdutcm.elements.service.ElementService;
import com.cdutcm.elements.service.InbornService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ElementServiceImplTest extends ElementsApplicationTests {

    @Autowired
    private ElementService elementService;
    @Autowired
    private InbornService inbornService;
    @Autowired
    private AcquireService acquireService;

    @Test
    public void inbornChart() {
        String phone = "18382471393";
        Person person = new Person();
        person.setPhone(phone);
        Inborn inborn = inbornService.selectInborn(person);
        elementService.inbornChart(inborn);
    }

    @Test
    public void acquireElementChart() {
        String phone = "18382471393";
        Person person = new Person();
        person.setPhone(phone);
        Acquire acquire = acquireService.selectAcquire(person);
        elementService.acquireElementChart(acquire);
    }

    @Test
    public void acquireYinYangChart() {
        String phone = "18382471393";
        Person person = new Person();
        person.setPhone(phone);
        Acquire acquire = acquireService.selectAcquire(person);
        elementService.acquireYinYangChart(acquire);
    }
}