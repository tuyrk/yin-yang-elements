package com.cdutcm.elements.service;

import com.cdutcm.elements.entity.Acquire;
import com.cdutcm.elements.form.Category;
import com.cdutcm.elements.form.Person;

import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/18 10:24 星期五
 * Description:
 */
public interface AcquireService {

    Acquire insertAcquire(Person person, Category category);

    Acquire deleteAcquire(Person person);

    Acquire updateAcquire(Person person, Category category);

    Acquire selectAcquire(Person person);

    List<Acquire> selectAcquireList(Person person);
}
