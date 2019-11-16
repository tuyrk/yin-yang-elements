package com.cdutcm.elements.service;

import com.cdutcm.elements.entity.EAQ;
import com.cdutcm.elements.form.Category;
import com.cdutcm.elements.form.Person;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 14:27 星期一
 * Description:
 */
public interface EAQService {
    EAQ insertEAQ(Category category, String phone);

    EAQ deleteCategory(Person person);

    EAQ updateEAQ(Category category, String phone);

    EAQ selectEAQ(String phone);

    Category selectCategory(String phone);
}
