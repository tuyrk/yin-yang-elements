package com.cdutcm.elements.controller;

import com.cdutcm.elements.utils.ElementsUtils;
import com.cdutcm.elements.utils.ResultVOUtils;
import com.cdutcm.elements.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/6/5 0:40 星期二
 * Description:
 */
@Slf4j
@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private ElementsUtils elementsUtils;

    @GetMapping("/horoscope")
    public ResultVO horoscope(String date) {
        return ResultVOUtils.success(elementsUtils.getHoroscope(date));
    }

}
