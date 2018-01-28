package com.cdutcm.service.impl;

import com.cdutcm.BaseTest;
import com.cdutcm.entity.Category;
import com.cdutcm.model.Respondent;
import com.cdutcm.service.ConclusionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/18
 * Time: 10:46 星期一
 * Description:
 */
public class ConclusionServiceImplTest extends BaseTest {

    @Autowired
    private ConclusionService conclusionService;

    @Test
    public void saveRespondent() {
        Respondent respondent = new Respondent();
        respondent.setPhone("510823199611114417");
        respondent.setName("涂元坤");
        respondent.setSex("男");
        Category category = new Category();
        category.setPhone("18382471393");
        category.setFeature("A");
        category.setComplexion("A");
        category.setTrunk("B");
        category.setLimb("B");
        category.setVoice("C");
        category.setPsychology("D");
        category.setDisease("E");
        if (conclusionService.saveRespondent(respondent, category, false, "") != null) {
            System.out.println("Success");
        } else {
            System.out.println("fail");
        }
    }

    @Test
    public void splitTest() {
        String[] cals = "农历1996-11-11".substring(2).split("-");
        for (int i = 0; i < cals.length; i++) {
            System.out.println(cals[i]);
        }
    }
}
