package com.cdutcm.elements.service.impl;

import com.cdutcm.elements.dao.EAQDao;
import com.cdutcm.elements.entity.EAQ;
import com.cdutcm.elements.enums.ResultEnum;
import com.cdutcm.elements.exception.ElementsException;
import com.cdutcm.elements.form.Category;
import com.cdutcm.elements.form.Person;
import com.cdutcm.elements.service.EAQService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 14:37 星期一
 * Description:
 */
@Slf4j
@Service
public class EAQServiceImpl implements EAQService {

    @Autowired
    private EAQDao eaqDao;

    @Override
    @Transactional
    public EAQ insertEAQ(Category category, String phone) {
        // 1.将Category转化为EAQ，存入`e_a_q`
        // 2.存入`inborn`表
        EAQ eaq = Category2EAQ(category, phone);
        if (eaqDao.insertEAQ(eaq)) {
            log.info("【数据采集-采集-分类条目】eaq = " + eaq);
            return eaq;
        }
        log.error("【数据采集-采集-分类条目】保存失败：category = " + category);
        throw new ElementsException(ResultEnum.INFO_SAVE_ERROR);
    }

    public EAQ deleteCategory(Person person) {
        EAQ eaq = new EAQ();
        eaq.setPhone(person.getPhone());
        if (eaqDao.deleteEAQ(eaq)) {
            return eaq;
        }
        throw new ElementsException(ResultEnum.DELETE_ERROR);
    }

    @Override
    public EAQ updateEAQ(Category category, String phone) {
        EAQ eaq = Category2EAQ(category, phone);
        if (eaqDao.updateEAQ(eaq)) {
            log.info("【数据采集-采集-分类条目】eaq = " + eaq);
            return eaq;
        }
        log.error("【数据采集-采集-分类条目】保存失败：category = " + category);
        throw new ElementsException(ResultEnum.INFO_SAVE_ERROR);
    }

    @Override
    public EAQ selectEAQ(String phone) {
        EAQ eaq = eaqDao.selectEAQByPhone(phone);
        if (eaq == null) {
            throw new ElementsException((ResultEnum.NOT_FIND));
        }
        log.info("【数据采集-查询】eaq = " + eaq);
        return eaq;
    }

    @Override
    public Category selectCategory(String phone) {
        return EAQ2Category(selectEAQ(phone));
    }


    private EAQ Category2EAQ(Category category, String phone) {
        EAQ eaq = new EAQ();
        eaq.setPhone(phone);
        eaq.setPF(category.getLianXing() + "-" + category.getMianSe() + "-" + category.getQuGan() + "-" + category.getSiZhi() + "-" + category.getYuYin());
        eaq.setPP(category.getXingLi());
        eaq.setVS(category.getHanRe() + "-" + category.getHan() + "-" + category.getYinShiKouWei() + "-" + category.getDaBian() + "-" + category.getXiaoBian() + "-" + category.getShuiMian() + "-" + category.getJingShengZhuangTai());
        eaq.setTM(category.getTouBu() + "-" + category.getShuangMu() + "-" + category.getXiongXie() + "-" + category.getZhiTi() + "-" + category.getYueJing() + "-" + category.getYiFaTu());
        eaq.setFM(category.getKouChun() + "-" + category.getXinXiong() + "-" + category.getYiFaHuo());
        eaq.setSM(category.getTouShen() + "-" + category.getSheChun() + "-" + category.getWeiWan() + "-" + category.getFuBu() + "-" + category.getYiFaTu());
        eaq.setGM(category.getKeSou() + "-" + category.getGeTan() + "-" + category.getBiBu() + "-" + category.getPiFu());
        eaq.setWM(category.getYaoQi() + "-" + category.getXingYu() + "-" + category.getYiJing() + "-" + category.getDaiXia());
        eaq.setHS(category.getHaoFaJiJie());
        eaq.setHD(category.getHaoFaBingWei());
        return eaq;
    }

    private Category EAQ2Category(EAQ eaq) {
        Category category = new Category();
        String temp[];
        temp = eaq.getPF().split("-");
        category.setLianXing(temp[0]);
        category.setMianSe(temp[1]);
        category.setQuGan(temp[2]);
        category.setSiZhi(temp[3]);
        category.setYuYin(temp[4]);
        temp = eaq.getPP().split("-");
        category.setXingLi(temp[0]);
        temp = eaq.getVS().split("-");
        category.setHanRe(temp[0]);
        category.setHan(temp[1]);
        category.setYinShiKouWei(temp[2]);
        category.setDaBian(temp[3]);
        category.setXiaoBian(temp[4]);
        category.setShuiMian(temp[5]);
        category.setJingShengZhuangTai(temp[6]);
        temp = eaq.getTM().split("-");
        category.setTouBu(temp[0]);
        category.setShuangMu(temp[1]);
        category.setXiongXie(temp[2]);
        category.setZhiTi(temp[3]);
        category.setYueJing(temp[4]);
        category.setYiFaMu(temp[5]);
        temp = eaq.getFM().split("-");
        category.setKouChun(temp[0]);
        category.setXinXiong(temp[1]);
        category.setYiFaHuo(temp[2]);
        temp = eaq.getSM().split("-");
        category.setTouShen(temp[0]);
        category.setSheChun(temp[1]);
        category.setWeiWan(temp[2]);
        category.setFuBu(temp[3]);
        category.setYiFaTu(temp[4]);
        temp = eaq.getGM().split("-");
        category.setKeSou(temp[0]);
        category.setGeTan(temp[1]);
        category.setBiBu(temp[2]);
        category.setPiFu(temp[3]);
        temp = eaq.getWM().split("-");
        category.setYaoQi(temp[0]);
        category.setXingYu(temp[1]);
        category.setYiJing(temp[2]);
        category.setDaiXia(temp[3]);
        temp = eaq.getHS().split("-");
        category.setHaoFaJiJie(temp[0]);
        temp = eaq.getHD().split("-");
        category.setHaoFaBingWei(temp[0]);
        return category;
    }
}
