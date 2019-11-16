package com.cdutcm.elements.controller;

import com.cdutcm.elements.dao.InbornDao;
import com.cdutcm.elements.entity.Inborn;
import com.cdutcm.elements.enums.ResultEnum;
import com.cdutcm.elements.exception.ElementsException;
import com.cdutcm.elements.form.Category;
import com.cdutcm.elements.form.Person;
import com.cdutcm.elements.service.AcquireService;
import com.cdutcm.elements.service.EAQService;
import com.cdutcm.elements.service.InbornService;
import com.cdutcm.elements.utils.ResultVOUtils;
import com.cdutcm.elements.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 13:34 星期一
 * Description:
 * 数据采集
 */
@Slf4j
@RestController
@RequestMapping("/doctor/scada")
public class ScadaController {

    @Autowired
    private InbornDao inbornDao;
    @Autowired
    private InbornService inbornService;
    @Autowired
    private AcquireService acquireService;
    @Autowired
    private EAQService eaqService;

    @PostMapping("/collect")
    @Transactional
    public ResultVO Collect(Person person, Category category, Boolean isUpdate) {
        log.info("【数据采集-采集】person = " + person + "\nisUpdate：" + isUpdate);
        log.info("【数据采集-采集】category = " + category);
        if (isUpdate) {//确认更新信息。
            inbornService.updateInborn(person);
            acquireService.updateAcquire(person, category);
            eaqService.updateEAQ(category, person.getPhone());
        } else {
            Inborn inborn = new Inborn();
            inborn.setPhone(person.getPhone());
            if (inbornDao.selectInborn(inborn).size() != 0) {
                throw new ElementsException(ResultEnum.INFO_EXIST);
            }
            inbornService.insertInborn(person);
            acquireService.insertAcquire(person, category);
            eaqService.insertEAQ(category, person.getPhone());
        }

        return ResultVOUtils.success();
    }

    @PostMapping("/query")
    public ResultVO Query(Person person) {
        log.info("【数据采集-查询】person = " + person);
        List<Inborn> inbornList = inbornService.selectInbornList(person);
        List<Object> objectList = new ArrayList<>();
        if (inbornList.size() == 1) {
            person = inbornService.Inborn2Person(inbornList.get(0));
            Category category = eaqService.selectCategory(person.getPhone());
            objectList.add(person);
            objectList.add(category);
            return ResultVOUtils.success(objectList);
        }
        if (inbornList.size() > 1) {
            for (Inborn i : inbornList) {
                objectList.add(i.getPhone());
            }
        }
        return ResultVOUtils.success(ResultEnum.NAME_REPEAT, objectList);
    }

    @PostMapping("/delete")
    @Transactional
    public ResultVO Delete(Person person) {
        log.info("【数据采集-删除】person = " + person);
        List<Inborn> inbornList = inbornService.selectInbornList(person);
        List<Object> objectList = new ArrayList<>();
        if (inbornList.size() == 1) {
            person = inbornService.Inborn2Person(inbornList.get(0));
            person = inbornService.deleteInborn(person);
            acquireService.deleteAcquire(person);
            eaqService.deleteCategory(person);
            return ResultVOUtils.success();
        }
        if (inbornList.size() > 1) {
            for (Inborn i : inbornList) {
                objectList.add(i.getPhone());
            }
        }
        return ResultVOUtils.success(ResultEnum.NAME_REPEAT, objectList);
    }

    @GetMapping("/export")
    public void Export(HttpServletRequest request, HttpServletResponse response) {
        inbornService.printConclusion(request, response);
    }
}
