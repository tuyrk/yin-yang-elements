package com.cdutcm.elements.service.impl;

import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/17 11:50 星期四
 * Description:
 */
@Slf4j
@Service
public class MailUtils {
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private FreeMarkerConfigurer configurer;

    public void sendSimpleMail() {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo("766564616@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        javaMailSender.send(message);
    }

    public void sendAttachmentsMail() {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo("766564616@qq.com");
            helper.setSubject("主题：有附件");
            helper.setText("有附件的邮件");

            FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
            helper.addAttachment("附件-1.jpg", file);
            helper.addAttachment("附件-2.jpg", file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        javaMailSender.send(mimeMessage);
    }

    public String sendInlineMail(String mail, Boolean isRegis) {
        String code = getCode();
        String action;
        if (isRegis) {
            action = "注册阴阳五行人体质研究平台";
        } else {
            action = "找回您的密码";
        }
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(mail);
            helper.setSubject(code);
            String emailMsg = "<div style=\"background-color:#d0d0d0;background-image:url(http://weixin.qq.com/zh_CN/htmledition/images/weixin/letter/mmsgletter_2_bg.png);text-align:center;padding:20px\"><div class=\"x_mmsgLetter\"style=\"max-width:600px;margin:0 auto;color:rgb(51,51,51);background-color:rgb(255,255,255);border:0 solid rgb(170,170,170);border-radius:5px;font-family:Verdana,sans-serif,serif,EmojiFont;\"><div class=\"x_mmsgLetterHeader\"style=\"height:23px;background:url(http://weixin.qq.com/zh_CN/htmledition/images/weixin/letter/mmsgletter_2_bg_topline.png) repeat-x 0 0\"></div><div class=\"x_mmsgLetterContent\"style=\"text-align:left;padding:30px;font-size:14px;line-height:1.5;background:url(http://www.expertsonchina.com/images/top.gif) no-repeat top center;background-size:65% 10.5%;\"><div><br><p>您好!</p><p>感谢您使用阴阳五行人体质研究平台<br>您正在" + action + "。请回填如下6位验证码：</p><p class=\"x_mmsgLetterDigital\"style=\"font-size:22px;letter-spacing:10px;\">" + code + "</p><p>验证码在30分钟内有效，30分钟后需要重新发送验证码</p></div><div class=\"x_mmsgLetterInscribe\"style=\"padding:40px 0 0\"><img data-imagetype=\"External\"src=\"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=328327349,855323749&fm=27&gp=0.jpg\"class=\"x_mmsgAvatar\"style=\"float:left\"height=\"45px\"width=\"45px\"><div class=\"x_mmsgSender\"style=\"margin:0 0 0 54px\"><p class=\"x_mmsgName\"style=\"margin:0 0 10px\">TYK</p><p class=\"x_mmsgInfo\"style=\"font-size:12px;margin:0;line-height:1.2\">开发人员<br><a href=\"mailto:766564616@qq.com\"target=\"_blank\"rel=\"noopener noreferrer\"style=\"color:#407700\">766564616@qq.com</a></p></div></div></div><div class=\"x_mmsgLetterFooter\"style=\"margin:16px;text-align:center;font-size:12px;color:#888\"><img data-imagetype=\"External\"data-imageerror=\"RelWithoutBase\"originalsrc=\"/cgi-bin/readtemplate?sid=$SID$&amp;loc=pushmail1,weixiniphone,show,44\"src=\"data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAEALAAAAAABAAEAAAIBTAA7\"onload=\"InlineImageLoader.GetLoader().Load(this)\"style=\"width:1px;height:1px\"crossorigin=\"anonymous\"><img data-imagetype=\"External\"src=\"http://weixin.qq.com/cgi-bin/reportforpromote?uin=$RCPTUIN$&amp;sdate=$SDATE$&amp;tver=$TVER$\"style=\"width:1px;height:1px\"></div></div></div>";
            helper.setText(emailMsg, true);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("【发送验证码】mail = " + mail + "\n是否注册：" + isRegis);
        }
        javaMailSender.send(mimeMessage);
        return code;
    }

    public void sendTemplateMail() {
        String to = "766564616@qq.com";
        String title = "测试消息通知";
        String templateName = "mail/message.ftl";
        Map<String, Object> params = new HashMap<>();
        params.put("messageCode", "MissingParameter");
        params.put("messageStatus", "Failed");
        params.put("cause", "缺少参数,请确认");

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(InternetAddress.parse(to));//发送给谁
            helper.setSubject("【" + title + "-" + LocalDate.now() + " " + LocalTime.now().withNano(0) + "】");//邮件标题

            Map<String, Object> model = new HashMap<>();
            model.put("params", params);
            Template template = configurer.getConfiguration().getTemplate(templateName);
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            helper.setText(text, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }

    private String getCode() {
        StringBuilder code = new StringBuilder(6);
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            char c = (char) (r.nextInt(10) + '0');
            code.append(String.valueOf(c));
        }
        return code.toString();
    }
}
