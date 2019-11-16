package com.cdutcm.elements.service.impl;

import com.cdutcm.elements.dao.AcquireDao;
import com.cdutcm.elements.dao.InbornDao;
import com.cdutcm.elements.dao.InbornPreDao;
import com.cdutcm.elements.entity.Acquire;
import com.cdutcm.elements.entity.Inborn;
import com.cdutcm.elements.entity.InbornPre;
import com.cdutcm.elements.enums.ResultEnum;
import com.cdutcm.elements.exception.ElementsException;
import com.cdutcm.elements.form.Person;
import com.cdutcm.elements.service.InbornService;
import com.cdutcm.elements.utils.ElementsUtils;
import com.cdutcm.elements.utils.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 14:33 星期一
 * Description:
 */
@Slf4j
@Service
public class InbornServiceImpl implements InbornService {

    @Autowired
    private ElementsUtils elementsUtils;
    @Autowired
    private InbornDao inbornDao;
    @Autowired
    private InbornPreDao inbornPreDao;
    @Autowired
    private AcquireDao acquireDao;

    @Override
    @Transactional
    public Inborn insertInborn(Person person) {
        Inborn inborn = Person2Inborn(person);
        InbornPre inbornPre = Inborn2InbornPre(inborn);
        if (inbornDao.insertInborn(inborn) && inbornPreDao.insertInbornPre(inbornPre)) {//6
            log.info("【数据采集】inborn = " + inborn);
            return inborn;
        }
        throw new ElementsException(ResultEnum.INFO_SAVE_ERROR);
    }

    @Override
    public Person deleteInborn(Person person) {
        Inborn inborn = new Inborn();
        inborn.setPhone(person.getPhone());
        InbornPre inbornPre = new InbornPre();
        inbornPre.setPhone(person.getPhone());
        if (inbornDao.deleteInborn(inborn) && inbornPreDao.deleteInbornPre(inbornPre)) {
            return person;
        }
        throw new ElementsException(ResultEnum.DELETE_ERROR);
    }

    @Override
    public Inborn updateInborn(Person person) {
        Inborn inborn = Person2Inborn(person);
        InbornPre inbornPre = Inborn2InbornPre(inborn);
        if (inbornDao.updateInborn(inborn) && inbornPreDao.updateInbornPre(inbornPre)) {//6
            log.info("【数据采集】inborn = " + inborn);
            return inborn;
        }
        throw new ElementsException(ResultEnum.INFO_SAVE_ERROR);
    }

    @Override
    public Inborn selectInborn(Person person) {
        List<Inborn> inbornList = selectInbornList(person);
        if (inbornList.size() > 1) {//查找结果多条数据，即姓名重复
            log.error("【数据采集/先天五行-查询】姓名重复：inbornList = " + inbornList);
            throw new ElementsException(ResultEnum.NAME_REPEAT);
        }
        return inbornList.get(0);
    }

    @Override
    public List<Inborn> selectInbornList(Person person) {
        Inborn inborn = new Inborn();
        inborn.setName(person.getName());
        inborn.setPhone(person.getPhone());
        List<Inborn> inbornList = inbornDao.selectInborn(inborn);
        if (inbornList.size() == 0) {//查找不存在
            log.error("【数据采集/先天五行-查询】查找不存在：person = " + person);
            throw new ElementsException(ResultEnum.NOT_FIND);
        }
        return inbornList;
    }

    @Override
    public boolean printConclusion(HttpServletRequest request, HttpServletResponse response) {
        List<Inborn> inbornList = inbornDao.selectInborn(null);
        List<Acquire> acquireList = acquireDao.selectAcquire(null);
        String filename = "阴阳五行数据表";
        String title = "阴阳五行数据表";
        String[] rowName = {"编号", "手机号", "姓名", "性别", "公历出生日期", "农历出生日期", "八字", "先天", "后天", "阴阳值"};

        try {
            SXSSFWorkbook sxssfWorkbook = ExcelUtils.createConclusionExcel(title, rowName, inbornList, acquireList);
            String agent = request.getHeader("User-Agent").toLowerCase();
            System.out.println("agent = " + agent);
            if (
                    agent.contains("edge") ||
                            agent.contains("msie") ||
                            agent.contains("rv") && !agent.contains("firefox")) {
                filename = URLEncoder.encode(filename, "UTF-8");
            } else {
                filename = new String((filename).getBytes("UTF-8"), "ISO-8859-1");
            }
            response.setHeader("Content-Disposition", "attachment;filename=" + filename + ".xlsx");
            response.setContentType("application/msexcel");
            if (sxssfWorkbook != null) {
                ServletOutputStream out = response.getOutputStream();
                sxssfWorkbook.write(out);
                out.flush();// 清除缓存
            }
        } catch (Exception e) {
            e.printStackTrace();
//            throw new ElementsException(ResultEnum.SERVICE_ERROR);
        }
        return true;
    }

    @Override
    public Person Inborn2Person(Inborn inborn) {
        Person person = new Person();
        person.setName(inborn.getName());
        person.setBirth(inborn.getSolarBirth() + inborn.getLunarBirth());
        person.setSex(inborn.getSex());
        person.setPhone(inborn.getPhone());
        return person;
    }

    private InbornPre Inborn2InbornPre(Inborn inborn) {
        InbornPre inbornPre = new InbornPre();
        inbornPre.setPhone(inborn.getPhone());
        inbornPre.setName(inborn.getName());
        float[] congenital = elementsUtils.getCongenital1(inborn.getHoroscope());
        inbornPre.setWood(congenital[0]);
        inbornPre.setFire(congenital[1]);
        inbornPre.setEarth(congenital[2]);
        inbornPre.setMetal(congenital[3]);
        inbornPre.setWater(congenital[4]);
        inbornPre.setInborn(elementsUtils.getBelongLack(congenital));//5
        return inbornPre;
    }

    private Inborn Person2Inborn(Person person) {
        // 1. 将Person转换为inborn
        // 2. 根据农历计算公历（或根据公历计算农历）
        // 3. 计算八字
        // 4. 计算先天五行值
        // 5. 计算先天所属、所缺次
        Inborn inborn = elementsUtils.BirthConverter(person);
        inborn.setName(person.getName());
        inborn.setSex(person.getSex());
        inborn.setPhone(person.getPhone());
        String horoscope = elementsUtils.getHoroscope(inborn.getSolarBirth());//3
        inborn.setHoroscope(horoscope);
        float[] congenital = elementsUtils.getCongenital2(horoscope);//4
        inborn.setWood(congenital[0]);
        inborn.setFire(congenital[1]);
        inborn.setEarth(congenital[2]);
        inborn.setMetal(congenital[3]);
        inborn.setWater(congenital[4]);
        inborn.setInborn(elementsUtils.getBelongLack(congenital));//5
        return inborn;
    }
}
