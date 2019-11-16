package com.cdutcm.elements.controller;

import com.cdutcm.elements.entity.Acquire;
import com.cdutcm.elements.entity.Inborn;
import com.cdutcm.elements.entity.InbornPre;
import com.cdutcm.elements.enums.ResultEnum;
import com.cdutcm.elements.form.Person;
import com.cdutcm.elements.service.AcquireService;
import com.cdutcm.elements.service.ElementService;
import com.cdutcm.elements.service.InbornPreService;
import com.cdutcm.elements.service.InbornService;
import com.cdutcm.elements.utils.ElementsUtils;
import com.cdutcm.elements.utils.ResultVOUtils;
import com.cdutcm.elements.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/17 10:40 星期四
 * Description:
 */
@Slf4j
@RestController
@RequestMapping("/doctor/element")
public class ElementController {
    @Autowired
    private InbornService inbornService;
    @Autowired
    private InbornPreService inbornPreService;
    @Autowired
    private AcquireService acquireService;
    @Autowired
    private ElementService elementService;

    @PostMapping("/inbornPre")
    public ResultVO inbornPre(Person person) {
        log.info("【先天五行-查询】person = " + person);
        List<InbornPre> inbornPreList = inbornPreService.selectInbornPreList(person);
        List<Object> objectList = new ArrayList<>();
        if (inbornPreList.size() == 1) {
            InbornPre inbornPre = inbornPreList.get(0);
            Inborn inborn = inbornService.selectInborn(person);
            inborn.setInborn(ElementsUtils.convertInborn(inbornPre.getInborn()));
            inborn.setWood(inbornPre.getWood());
            inborn.setFire(inbornPre.getFire());
            inborn.setEarth(inbornPre.getEarth());
            inborn.setMetal(inbornPre.getMetal());
            inborn.setWater(inbornPre.getWater());
            String url = elementService.inbornChart(inborn);
            objectList.add(url);
            objectList.add(inborn);
            return ResultVOUtils.success(objectList);
        }
        if (inbornPreList.size() > 1) {
            for (InbornPre i : inbornPreList) {
                objectList.add(i.getPhone());
            }
        }
        return ResultVOUtils.success(ResultEnum.NAME_REPEAT, objectList);
    }

    @PostMapping("/inborn")
    public ResultVO Inborn(Person person) {
        log.info("【先天五行-查询】person = " + person);
        List<Inborn> inbornList = inbornService.selectInbornList(person);
        List<Object> objectList = new ArrayList<>();
        if (inbornList.size() == 1) {
            Inborn inborn = inbornList.get(0);
            inborn.setInborn(ElementsUtils.convertInborn(inborn.getInborn()));
            String url = elementService.inbornChart(inborn);
            objectList.add(url);
            objectList.add(inborn);
            return ResultVOUtils.success(objectList);
        }
        if (inbornList.size() > 1) {
            for (Inborn i : inbornList) {
                objectList.add(i.getPhone());
            }
        }
        return ResultVOUtils.success(ResultEnum.NAME_REPEAT, objectList);
    }

    @PostMapping("/acquire")
    public ResultVO Acquire(Person person) {
        log.info("【后天五行-查询】person = " + person);
        List<Acquire> acquireList = acquireService.selectAcquireList(person);
        List<Object> objectList = new ArrayList<>();
        if (acquireList.size() == 1) {
            Acquire acquire = acquireList.get(0);
            String urlElement = elementService.acquireElementChart(acquire);
            String urlYinYang = elementService.acquireYinYangChart(acquire);
            acquire.setAcquire(ElementsUtils.convertAcquire(acquire));
            objectList.add(urlElement);
            objectList.add(urlYinYang);
            objectList.add(acquire);
            return ResultVOUtils.success(objectList);
        }
        if (acquireList.size() > 1) {
            for (Acquire i : acquireList) {
                objectList.add(i.getPhone());
            }
        }
        return ResultVOUtils.success(ResultEnum.NAME_REPEAT, objectList);
    }
}
