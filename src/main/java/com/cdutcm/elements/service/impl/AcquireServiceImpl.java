package com.cdutcm.elements.service.impl;

import com.cdutcm.elements.dao.AcquireDao;
import com.cdutcm.elements.entity.Acquire;
import com.cdutcm.elements.enums.ResultEnum;
import com.cdutcm.elements.exception.ElementsException;
import com.cdutcm.elements.form.Category;
import com.cdutcm.elements.form.Person;
import com.cdutcm.elements.service.AcquireService;
import com.cdutcm.elements.utils.ElementsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/18 11:16 星期五
 * Description:
 */
@Slf4j
@Service
public class AcquireServiceImpl implements AcquireService {
    @Autowired
    private ElementsUtils elementsUtils;
    @Autowired
    private AcquireDao acquireDao;

    @Override
    public Acquire insertAcquire(Person person, Category category) {
        Acquire acquire = Person2Acquire(person, category);
        if (acquireDao.insertAcquire(acquire)) {//5
            log.info("【数据采集】acquire = " + acquire);
            return acquire;
        }
        throw new ElementsException(ResultEnum.INFO_SAVE_ERROR);
    }

    @Override
    public Acquire deleteAcquire(Person person) {
        Acquire acquire = new Acquire();
        acquire.setPhone(person.getPhone());
        if (acquireDao.deleteAcquire(acquire)) {
            return acquire;
        }
        throw new ElementsException(ResultEnum.DELETE_ERROR);
    }

    @Override
    public Acquire updateAcquire(Person person, Category category) {
        Acquire acquire = Person2Acquire(person, category);
        if (acquireDao.updateAcquire(acquire)) {//5
            log.info("【数据采集】acquire = " + acquire);
            return acquire;
        }
        throw new ElementsException(ResultEnum.INFO_SAVE_ERROR);
    }

    @Override
    public Acquire selectAcquire(Person person) {
        Acquire acquire = new Acquire();
        acquire.setName(person.getName());
        acquire.setPhone(person.getPhone());
        List<Acquire> acquireList = acquireDao.selectAcquire(acquire);
        if (acquireList.size() == 0) {//查找不存在
            log.error("【后天五行-查询】查找不存在：person = " + person);
            throw new ElementsException(ResultEnum.NOT_FIND);
        } else if (acquireList.size() > 1) {//查找结果多条数据，即姓名重复
            log.error("【后天五行-查询】姓名重复：inbornList = " + acquireList);
            throw new ElementsException(ResultEnum.NAME_REPEAT);
        }
        return acquireList.get(0);
    }

    @Override
    public List<Acquire> selectAcquireList(Person person) {
        Acquire acquire = new Acquire();
        acquire.setName(person.getName());
        acquire.setPhone(person.getPhone());
        List<Acquire> acquireList = acquireDao.selectAcquire(acquire);
        if (acquireList.size() == 0) {//查找不存在
            log.error("【后天五行-查询】查找不存在：person = " + person);
            throw new ElementsException(ResultEnum.NOT_FIND);
        }
        return acquireList;
    }


    private Acquire Person2Acquire(Person person, Category category) {
        // 1.获取手机号码和姓名
        // 2.计算后天五行值
        // 3.计算后天所属、所缺次
        // 4.计算后天阴阳值
        Acquire acquire = new Acquire();
        acquire.setPhone(person.getPhone());// 1
        acquire.setName(person.getName());
        int[] postnatal = elementsUtils.getPostnatal(category, person.getSex().charAt(0));//2
        acquire.setWood(postnatal[0]);
        acquire.setFire(postnatal[1]);
        acquire.setEarth(postnatal[2]);
        acquire.setMetal(postnatal[3]);
        acquire.setWater(postnatal[4]);
        String belongLackMinor = elementsUtils.getBelongLackMinor(postnatal);//3
        acquire.setAcquire(belongLackMinor);
        Integer[] yinYangValue = elementsUtils.getYinYangValue(category);//4
        acquire.setYinYangWood(yinYangValue[0]);
        acquire.setYinYangFire(yinYangValue[1]);
        acquire.setYinYangEarth(yinYangValue[2]);
        acquire.setYinYangMetal(yinYangValue[3]);
        acquire.setYinYangWater(yinYangValue[4]);
        return acquire;
    }
}
