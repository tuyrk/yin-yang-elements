package com.cdutcm.service.impl;

import com.cdutcm.BaseTest;
import com.cdutcm.entity.Category;
import com.cdutcm.service.CategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/16
 * Time: 22:52 星期六
 * Description:
 */
public class CategoryServiceImplTest extends BaseTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void saveCategory() {
        Category category = new Category();
        category.setPhone("510823199611114419");
        category.setFeature("A");
        category.setComplexion("A");
        category.setTrunk("B");
        category.setLimb("B");
        category.setVoice("C");
        category.setPsychology("D");
        category.setDisease("E");
        if (categoryService.saveCategory(category,"exists")) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }

    @Test
    public void queryCategory(){
        Category category = categoryService.queryCategory("涂元坤", "18382471393");
        if (category != null){
            System.out.println("-------find is ok--------");
        }else {
            System.out.println("-------not find--------");
        }
    }
}
