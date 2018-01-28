package com.cdutcm.controller;

import com.cdutcm.constant.Constant;
import com.cdutcm.entity.Doctor;
import com.cdutcm.service.LoginService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/25
 * Time: 20:26 星期一
 * Description:
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    private Map<String, String> map = new HashMap<>(1);
    private Gson gson = new Gson();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    public String sendCode(String mail, String flag, HttpSession session) {
        String code = loginService.sendMail(mail, flag);
        if (code == null) {
            map.put("status", "fail");
            return gson.toJson(map);//发送失败
        }
        if (Constant.USERSENDEMAIL_REG.equals(flag)) {
            session.setAttribute("code", code.trim());
        } else if (Constant.USERSENDEMAIL_FORGETPWD.equals(flag)) {
            session.setAttribute("forgetCode", code.trim());
        }
        map.put("status", "success");
        return gson.toJson(map);//发送成功
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Doctor doctor, HttpSession session) {
        doctor = loginService.checkDoctor(doctor);
        if (doctor == null) {//验证用户是否存在
            map.put("status", "fail");
            return gson.toJson(map);//登录失败,用户名或密码错误
        }
        if ("0".equals(doctor.getState())) {//已关闭验证功能
            session.setAttribute("doctor", doctor);
            map.put("status", "success");
            return gson.toJson(map);//登录成功
        }
        map.put("status", "unaudited");
        return gson.toJson(map);//管理员尚未审核
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Doctor doctor, HttpServletRequest request) {//String validateCode
        HttpSession session = request.getSession();
//        String code = (String) session.getAttribute("code");
//        if (!validateCode.equals(code)) {//验证验证码是否正确
//            map.put("status", "error");
//            return gson.toJson(map);//验证码错误
//        }
        session.removeAttribute("code");//移除Session中的code
        if (loginService.checkDoctorByUsername(doctor.getUsername())) {//验证用户是否已经注册
            map.put("status", "registered");
            return gson.toJson(map);//已注册
        }
        if (loginService.checkDoctorByMail(doctor.getMail())) {
            map.put("status", "bound");
            return gson.toJson(map);//邮箱已绑定
        }
        if (loginService.regist(doctor)) {//注册
            map.put("status", "success");
            return gson.toJson(map);//注册成功
        }
        map.put("status", "fail");
        return gson.toJson(map);//注册失败
    }

    @ResponseBody
    @RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
    public String modifyPassword(Doctor doctor, String validateCode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("forgetCode");
        if (!validateCode.equals(code)) {//验证验证码是否正确
            map.put("status", "error");
            return gson.toJson(map);//验证码错误
        }
        session.removeAttribute("forgetCode");//移除Session中的forgetCode
        if (!loginService.checkDoctorByMail(doctor.getMail())) {//验证用户是否已经注册
            map.put("status", "unregistered");
            return gson.toJson(map);//用户未注册
        }
        if (loginService.modifyPassword(doctor)) {//修改密码
            map.put("status", "success");
            return gson.toJson(map);//修改成功
        }
        map.put("status", "fail");
        return gson.toJson(map);//修改失败
    }
}
