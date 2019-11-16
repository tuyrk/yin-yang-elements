package com.cdutcm.elements.controller;

import com.cdutcm.elements.ElementsApplicationTests;
import com.cdutcm.elements.form.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ElementControllerTest extends ElementsApplicationTests {

    @Autowired
    private ElementController elementController;

    @Test
    public void inborn() {
        String phone = "18382471393";
        Person person = new Person();
        person.setPhone(phone);
        elementController.Inborn(person);
    }

    @Test
    public void acquire() {
        String phone = "18382471393";
        Person person = new Person();
        person.setPhone(phone);
        elementController.Acquire(person);
    }
}