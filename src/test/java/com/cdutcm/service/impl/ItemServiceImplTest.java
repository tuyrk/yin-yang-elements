package com.cdutcm.service.impl;

import com.cdutcm.BaseTest;
import com.cdutcm.entity.Category;
import com.cdutcm.service.ItemService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/1/16 12:52 星期二
 * Description:
 */
public class ItemServiceImplTest extends BaseTest {

    @Autowired
    private ItemService itemService;

    @Test
    public void categoryCompare() {
        Category category1 = new Category();
        category1.setPhone("18382471393");
        category1.setFeature("A");
        category1.setComplexion("A");
        category1.setTrunk("B");
        category1.setLimb("B");
        category1.setVoice("C");
        category1.setPsychology("D");
        category1.setDisease("E");
        Category category2 = new Category();
        category2.setPhone("18382471393");
        category2.setFeature("A");
        category2.setComplexion("A");
        category2.setTrunk("B");
        category2.setLimb("B");
        category2.setVoice("C");
        category2.setPsychology("D");
        category2.setDisease("E");
        if (category1.compareTo(category2) == 0) {
            System.out.println("category: equals");
        } else {
            System.out.println("category: not equals");
        }
    }

    @Test
    public void deleteItem() {
        String phone = "18382471393";
        System.out.println("delete " + phone + " " + itemService.deleteItem(phone));
    }

}
