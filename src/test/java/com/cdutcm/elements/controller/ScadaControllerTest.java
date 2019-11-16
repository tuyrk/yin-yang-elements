package com.cdutcm.elements.controller;

import com.cdutcm.elements.ElementsApplicationTests;
import com.cdutcm.elements.form.Category;
import com.cdutcm.elements.form.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ScadaControllerTest extends ElementsApplicationTests {

    @Autowired
    private ScadaController scadaController;

    @Test
    public void collect() {
        Person person = new Person("涂元坤", "公历:2018-05-15 08", "男", "18382471393");
        Category category = new Category(
                /*体貌特征*/"A", "Ba", "C", "B", "D",
                /*心理特征*/"Ea",
                /*生命特征*/"E", "F", "H", "B", "A", "D", "F",
                /*好发症状-木行人*/"B", "A", "D", "C", "E", "B",
                /*好发症状-火行人*/"C", "D", "B",
                /*好发症状-土行人*/"A", "B", "D", "C", "E",
                /*好发症状-金行人*/"A", "D", "E", "F",
                /*好发症状-水行人*/"B", "E", "F", "A",
                /*好发季节*/"D",
                /*好发病位*/"C");
        System.out.println("Collect = " + scadaController.Collect(person, category, false));
    }

    @Test
    public void query() {
        Person person = new Person("涂元坤", "公历:2018-05-15 08", "男", "18382471393");
        System.out.println("Query = " + scadaController.Query(person));
    }

    @Test
    public void delete() {
        Person person = new Person("涂元坤", "公历:2018-05-15 08", "男", "18382471393");
        System.out.println("Delete = " + scadaController.Delete(person));
    }

    @Test
    public void export() {

    }
}