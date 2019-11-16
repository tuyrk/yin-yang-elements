package com.cdutcm.elements.service.impl;

import com.cdutcm.elements.dao.InbornPreDao;
import com.cdutcm.elements.entity.InbornPre;
import com.cdutcm.elements.enums.ResultEnum;
import com.cdutcm.elements.exception.ElementsException;
import com.cdutcm.elements.form.Person;
import com.cdutcm.elements.service.InbornPreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/6/6 11:05 星期三
 * Description:
 */
@Slf4j
@Service
public class InbornPreServiceImpl implements InbornPreService {

    @Autowired
    private InbornPreDao inbornPreDao;

    @Override
    public InbornPre selectInbornPre(Person person) {
        List<InbornPre> inbornPreList = selectInbornPreList(person);
        if (inbornPreList.size() > 1) {//查找结果多条数据，即姓名重复
            log.error("【数据采集/先天五行-查询】姓名重复：inbornPreList = " + inbornPreList);
            throw new ElementsException(ResultEnum.NAME_REPEAT);
        }
        return inbornPreList.get(0);
    }

    @Override
    public List<InbornPre> selectInbornPreList(Person person) {
        InbornPre inbornPre = new InbornPre();
        inbornPre.setName(person.getName());
        inbornPre.setPhone(person.getPhone());
        List<InbornPre> inbornPreList = inbornPreDao.selectInbornPre(inbornPre);
        if (inbornPreList.size() == 0) {//查找不存在
            log.error("【数据采集/先天五行-查询】查找不存在：person = " + person);
            throw new ElementsException(ResultEnum.NOT_FIND);
        }
        return inbornPreList;
    }
}
