package com.cdutcm.elements.service;

import com.cdutcm.elements.entity.Inborn;
import com.cdutcm.elements.entity.InbornPre;
import com.cdutcm.elements.form.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 14:27 星期一
 * Description:
 */
public interface InbornService {
    Inborn insertInborn(Person person);

    Person deleteInborn(Person person);

    Inborn updateInborn(Person person);

    Inborn selectInborn(Person person);

    List<Inborn> selectInbornList(Person person);

    boolean printConclusion(HttpServletRequest request, HttpServletResponse response);

    Person Inborn2Person(Inborn inborn);
}
