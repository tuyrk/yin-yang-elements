package com.cdutcm.util;

import com.cdutcm.BaseTest;
import com.cdutcm.entity.Category;
import org.junit.Test;

import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/18
 * Time: 14:45 星期一
 * Description:
 */
public class ElementsUtilTest extends BaseTest {

    @Test
    public void ensureElements(){
        Category category = new Category();
        category.setFeature("A");
        category.setComplexion("A");
        category.setTrunk("B");
        category.setLimb("B");
        category.setVoice("C");
        category.setPsychology("D");
        category.setDisease("E");
        List<String> list = ElementsUtil.ensureElements(category);
        for (String l : list) {
            System.out.println(l);
        }
    }
}
