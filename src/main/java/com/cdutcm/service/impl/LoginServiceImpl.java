package com.cdutcm.service.impl;

import com.cdutcm.constant.Constant;
import com.cdutcm.dao.DoctorDao;
import com.cdutcm.entity.Doctor;
import com.cdutcm.service.LoginService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Random;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/26
 * Time: 16:13 星期二
 * Description:
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private DoctorDao doctorDao;

    @Override
    public String sendMail(String mail, String flag) {
        System.out.println("mail = " + mail);
        System.out.println("flag = " + flag);
        //1.设置随机验证码
        StringBuilder code = new StringBuilder(6);
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            char c = (char) (r.nextInt(10) + '0');
            code.append(String.valueOf(c));
        }
        //2.设置发送信息
        String action = null;
        if (Constant.USERSENDEMAIL_REG.equals(flag)) {
            action = "注册阴阳五行人体质研究平台";
        } else if (Constant.USERSENDEMAIL_FORGETPWD.equals(flag)) {
            action = "找回您的密码";
        }
        String emailMsg = "<div style=\"background-color:#d0d0d0;background-image:url(http://weixin.qq.com/zh_CN/htmledition/images/weixin/letter/mmsgletter_2_bg.png);text-align:center;padding:20px\"><div class=\"x_mmsgLetter\"style=\"max-width:600px;margin:0 auto;color:rgb(51,51,51);background-color:rgb(255,255,255);border:0 solid rgb(170,170,170);border-radius:5px;font-family:Verdana,sans-serif,serif,EmojiFont;\"><div class=\"x_mmsgLetterHeader\"style=\"height:23px;background:url(http://weixin.qq.com/zh_CN/htmledition/images/weixin/letter/mmsgletter_2_bg_topline.png) repeat-x 0 0\"></div><div class=\"x_mmsgLetterContent\"style=\"text-align:left;padding:30px;font-size:14px;line-height:1.5;background:url(http://www.expertsonchina.com/images/top.gif) no-repeat top center;background-size:65% 10.5%;\"><div><br><p>您好!</p><p>感谢您使用阴阳五行人体质研究平台<br>您正在" + action + "。请回填如下6位验证码：</p><p class=\"x_mmsgLetterDigital\"style=\"font-size:22px;letter-spacing:10px;\">" + code + "</p><p>验证码在30分钟内有效，30分钟后需要重新发送验证码</p></div><div class=\"x_mmsgLetterInscribe\"style=\"padding:40px 0 0\"><img data-imagetype=\"External\"src=\"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=328327349,855323749&fm=27&gp=0.jpg\"class=\"x_mmsgAvatar\"style=\"float:left\"height=\"45px\"width=\"45px\"><div class=\"x_mmsgSender\"style=\"margin:0 0 0 54px\"><p class=\"x_mmsgName\"style=\"margin:0 0 10px\">TYK</p><p class=\"x_mmsgInfo\"style=\"font-size:12px;margin:0;line-height:1.2\">开发人员<br><a href=\"mailto:766564616@qq.com\"target=\"_blank\"rel=\"noopener noreferrer\"style=\"color:#407700\">766564616@qq.com</a></p></div></div></div><div class=\"x_mmsgLetterFooter\"style=\"margin:16px;text-align:center;font-size:12px;color:#888\"><img data-imagetype=\"External\"data-imageerror=\"RelWithoutBase\"originalsrc=\"/cgi-bin/readtemplate?sid=$SID$&amp;loc=pushmail1,weixiniphone,show,44\"src=\"data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAEALAAAAAABAAEAAAIBTAA7\"onload=\"InlineImageLoader.GetLoader().Load(this)\"style=\"width:1px;height:1px\"crossorigin=\"anonymous\"><img data-imagetype=\"External\"src=\"http://weixin.qq.com/cgi-bin/reportforpromote?uin=$RCPTUIN$&amp;sdate=$SDATE$&amp;tver=$TVER$\"style=\"width:1px;height:1px\"></div></div></div>";
        try {
            sendMail(mail, code.toString(), emailMsg);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return code.toString();
    }

    @Override
    public Doctor checkDoctor(Doctor doctor) {
        Doctor doctor1 = new Doctor();
        doctor1.setUsername(doctor.getUsername());
        doctor1.setPassword(DigestUtils.md5Hex(doctor.getPassword()));
        doctor = doctorDao.selectDoctor(doctor1);
        if (doctor == null) {
            return null;//用户未注册或密码错误,登录失败
        }
        return doctor;//用户注册,登录成功
    }

    @Override
    public boolean checkDoctorByUsername(String username) {//field = {username, mail}
        Doctor doctor1 = new Doctor();
        doctor1.setUsername(username);
        if (doctorDao.selectDoctor(doctor1) == null) {
            return false;//注册用户未注册
        }
        return true;//注册用户已注册
    }

    @Override
    public boolean checkDoctorByMail(String mail) {
        Doctor doctor = new Doctor();
        doctor.setMail(mail.trim());
        if (doctorDao.selectDoctor(doctor) == null) {
            return false;//注册用户未注册,未找到

        }
        return true;//注册用户已注册,找到
    }

    @Override
    public boolean regist(Doctor doctor) {
        doctor.setPassword(DigestUtils.md5Hex(doctor.getPassword()));
        if (doctorDao.insertDoctor(doctor)) {
            return true;//注册成功
        }
        return false;//注册失败
    }

    public boolean modifyPassword(Doctor doctor) {
        Doctor doctor1 = new Doctor();
        doctor1.setMail(doctor.getMail());
        doctor1.setPassword(DigestUtils.md5Hex(doctor.getPassword().trim()));
        if (doctorDao.updateDoctor(null, doctor1)) {
            return true;//修改密码成功
        }
        return false;//修改密码失败
    }

    @Override
    public boolean modifyMail(String newMail, Doctor doctor) {
        Doctor doctor1 = new Doctor();
        doctor1.setMail(doctor.getMail().trim());
        if (doctorDao.updateDoctor(newMail.trim(), doctor1)) {
            return true;//修改邮箱成功
        }
        return false;//修改邮箱失败
    }

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    /**
     * 单发
     *
     * @param recipient 收件人
     * @param subject   主题
     * @param content   内容
     */
    public boolean sendMail(String recipient, String subject, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("766564616@qq.com");
            // 收件人
            helper.setTo(recipient);
            // 标题
            helper.setSubject(subject);
            // 内容
            helper.setText(content, true);
            javaMailSender.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 修改密码时,验证输入旧密码是否正确
     *
     * @return
     */
    public boolean checkPassword(String modifyPassword, Doctor doctor) {
        if (DigestUtils.md5Hex(modifyPassword.trim()).equals(doctor.getPassword())) {
            return true;//旧密码正确
        }
        return false;//旧密码输入错误
    }
}
