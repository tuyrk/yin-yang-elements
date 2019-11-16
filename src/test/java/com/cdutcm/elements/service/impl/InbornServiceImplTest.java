package com.cdutcm.elements.service.impl;

import com.cdutcm.elements.ElementsApplicationTests;
import com.cdutcm.elements.form.Category;
import com.cdutcm.elements.form.Person;
import com.cdutcm.elements.service.InbornService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

public class InbornServiceImplTest extends ElementsApplicationTests {


    @Autowired
    private InbornService inbornService;

    @Test
    public void insertInborn() {
        Person person = new Person("涂元坤", "公历:1996-05-15 08", "男", "18382471393");
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
        System.out.println("insertInborn:" + inbornService.insertInborn(person));
    }

    @Test
    public void printConclusion() {
        try {
            mockMvc.perform(get("/doctor/scada/export"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}