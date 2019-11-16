package com.cdutcm.elements.service.impl;

import com.cdutcm.elements.ElementsApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MailUtilsTest extends ElementsApplicationTests {

    @Autowired
    private MailUtils mailUtils;

    @Test
    public void sendSimpleMail() {
        mailUtils.sendSimpleMail();
    }

    @Test
    public void sendAttachmentsMail() {
    }

    @Test
    public void sendInlineMail() {
        String mail = "766564616@qq.com";
        System.out.println("Code = " + mailUtils.sendInlineMail(mail, true));
        System.out.println("Code = " + mailUtils.sendInlineMail(mail, false));

    }

    @Test
    public void sendTemplateMail() {
        mailUtils.sendTemplateMail();
    }
}