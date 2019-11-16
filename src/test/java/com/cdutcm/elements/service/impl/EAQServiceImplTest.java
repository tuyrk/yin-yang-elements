package com.cdutcm.elements.service.impl;

import com.cdutcm.elements.ElementsApplicationTests;
import com.cdutcm.elements.form.Category;
import com.cdutcm.elements.service.EAQService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class EAQServiceImplTest extends ElementsApplicationTests {

    @Autowired
    private EAQService eaqService;

    @Test
    public void insertEAQ() {
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
        String phone = "18382471393";
        System.out.println("insertEAQ = " + eaqService.insertEAQ(category, phone));
    }

    @Test
    public void selectCategory() {
        String phone = "18382471393";
        System.out.println("selectCategory = " + eaqService.selectCategory(phone));
    }
}