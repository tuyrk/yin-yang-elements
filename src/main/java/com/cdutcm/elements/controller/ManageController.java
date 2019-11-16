package com.cdutcm.elements.controller;

import com.cdutcm.elements.entity.Doctor;
import com.cdutcm.elements.enums.ResultEnum;
import com.cdutcm.elements.exception.ElementsException;
import com.cdutcm.elements.service.DoctorService;
import com.cdutcm.elements.service.impl.MailUtils;
import com.cdutcm.elements.utils.ResultVOUtils;
import com.cdutcm.elements.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/17 10:58 星期四
 * Description:
 */
@Slf4j
@RestController
@RequestMapping("/doctor/manage")
public class ManageController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private MailUtils mailUtils;

    @PostMapping("/info")
    public ResultVO Info(HttpSession session) {
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        return ResultVOUtils.success(doctorService.selectDoctor(new Doctor(doctor.getUsername())));
    }

    @PostMapping("/modify")
    public ResultVO Modify(Doctor doctor, HttpSession session) {
        log.info("【修改邮箱/密码】doctor = " + doctor);
        Doctor sessionDoctor = (Doctor) session.getAttribute("doctor");
        Doctor selectDoctor = doctorService.selectDoctor(sessionDoctor);
        session.setAttribute("doctor", doctorService.updateDoctor(doctor, selectDoctor));
        return ResultVOUtils.success();
    }

    @PostMapping("/sendCode")
    public ResultVO SendCode(Doctor doctor, HttpSession session, Boolean isRegis) {
        log.info("【发送验证码】doctor = " + doctor);
        session.setAttribute("SendCodeDoctor", doctor);
        return ResultVOUtils.success(mailUtils.sendInlineMail(doctor.getMail(), isRegis));
    }

    @PostMapping("/regis")
    public ResultVO Regis(Doctor doctor) {
        log.info("【用户注册】doctor = " + doctor);
        /* 需要验证码的注册
        Doctor sessionDoctor = (Doctor) session.getAttribute("SendCodeDoctor");
        doctorService.insertDoctor(doctor, sessionDoctor);
        session.invalidate();
         */
        /* 不需要验证码的注册
         */
        doctorService.insertDoctor(doctor, null);
        return ResultVOUtils.success();
    }

    @PostMapping("/login")
    public ResultVO Login(Doctor doctor, HttpSession session) {
        log.info("【用户登录】doctor = " + doctor);
        doctor.setPassword(DigestUtils.md5DigestAsHex(doctor.getPassword().getBytes()));
        session.setAttribute("doctor", doctorService.selectDoctor(doctor));
        return ResultVOUtils.success();
    }


    @PostMapping("/retrieve")
    public ResultVO Retrieve(Doctor doctor, HttpSession session) {
        log.info("【找回密码】doctor = " + doctor);
        Doctor sessionDoctor = (Doctor) session.getAttribute("SendCodeDoctor");
        if (!sessionDoctor.getMail().equals(doctor.getMail())) {
            throw new ElementsException(ResultEnum.USER_ERROR);
        }
        Doctor selectDoctor = new Doctor();
        selectDoctor.setMail(selectDoctor.getMail());
        selectDoctor = doctorService.selectDoctor(selectDoctor);
        doctorService.updateDoctor(doctor, selectDoctor);
        session.invalidate();
        return ResultVOUtils.success();
    }
}
