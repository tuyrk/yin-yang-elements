package com.cdutcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/13
 * Time: 16:53 星期三
 * Description:
 */
@Controller
public class TestController {

    @RequestMapping("/admin/logs/info")
    public String info() {
        return "admin/logs/info";
    }

    @RequestMapping("/admin/logs/info/{data}")
    public String info(@PathVariable String data, HttpSession session) {
        File file = new File(session.getServletContext().getRealPath("/WEB-INF/views/admin/logs/info.jsp") + data + ".jsp");
        if (file.exists()) {
            return "admin/logs/info.jsp" + data;
        }
        return "admin/logs/info";
    }
}
