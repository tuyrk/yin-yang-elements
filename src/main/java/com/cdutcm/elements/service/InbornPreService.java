package com.cdutcm.elements.service;

import com.cdutcm.elements.entity.InbornPre;
import com.cdutcm.elements.form.Person;

import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/6/6 11:03 星期三
 * Description:
 */
public interface InbornPreService {
    InbornPre selectInbornPre(Person person);

    List<InbornPre> selectInbornPreList(Person person);
}
