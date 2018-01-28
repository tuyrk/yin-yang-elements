package com.cdutcm.controller;

import com.cdutcm.entity.Doctor;
import com.cdutcm.service.LoginService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/28
 * Time: 18:03 星期四
 * Description:
 */
@Controller
@RequestMapping("/doctor")
public class SettingController {

    private Map<String, String> map = new HashMap<>(1);
    private Gson gson = new Gson();

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/{pageName}", method = RequestMethod.GET)
    public ModelAndView pageSetting(@PathVariable String pageName) {
        ModelAndView mav = new ModelAndView("doctor/pageBase");
        mav.addObject("pageName", pageName);
        return mav;
    }

    @RequestMapping(value = "/page/setting", method = RequestMethod.GET)
    public String setting() {
        return "doctor/tpls/setting";
    }

    @GetMapping("/page/modifyPassword")
    public String modifyPassword() {
        return "doctor/tpls/modifyPassword";
    }

    @ResponseBody
    @PostMapping("/modifyPwd")
    public String modifyPassword(String modifyPassword, String newPassword, HttpSession session) {
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        if (!loginService.checkPassword(modifyPassword, doctor)) {
            map.put("status", "error");
            return gson.toJson(map);//旧密码错误
        }
        doctor.setPassword(newPassword);
        if (loginService.modifyPassword(doctor)) {
            map.put("status", "success");
            return gson.toJson(map);//修改成功
        }
        map.put("status", "fail");
        return gson.toJson(map);//修改失败
    }

    @ResponseBody
    @PostMapping("/modifyMail")
    public String setting(String newMail, HttpSession session) {
        System.out.println("newMail = " + newMail);
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        if (loginService.checkDoctorByMail(newMail)) {
            map.put("status", "bound");
            return gson.toJson(map);//邮箱已绑定
        }
        if (loginService.modifyMail(newMail, doctor)) {
            doctor.setMail(newMail.trim());
            session.setAttribute("doctor", doctor);
            map.put("status", "success");
            return gson.toJson(map);//修改成功
        }
        map.put("status", "fail");
        return gson.toJson(map);//修改失败
    }
}
