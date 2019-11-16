package com.cdutcm.elements.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/20 22:43 星期日
 * Description:
 */
@Controller
@RequestMapping("/")
public class JumpController {

    @GetMapping("/")
    public String login() {
        return "view/login";
    }

    @GetMapping("/scada")
    public String index() {
        return "view/doctor/index";
    }

    @GetMapping("/inborn")
    public String xianTian() {
        return "view/doctor/xianTian";
    }

    @GetMapping("/acquire")
    public String houTian() {
        return "view/doctor/houTian";
    }

    @GetMapping("/setting")
    public String setting() {
        return "view/doctor/setting";
    }

    @GetMapping("/modify")
    public String modifyPassword() {
        return "view/doctor/modifyPassword";
    }

    @GetMapping("/exit")
    public String Exit(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
