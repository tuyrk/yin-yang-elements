package com.cdutcm.elements.entity;

import lombok.Data;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 0:19 星期一
 * Description:
 */
@Data
public class EAQ {
    private Integer eId;
    private String phone;
    private String pF;
    private String pP;
    private String vS;
    private String tM;
    private String fM;
    private String sM;
    private String gM;
    private String wM;
    private String hS;
    private String hD;

    public EAQ() {
    }

    public EAQ(Integer eId, String phone, String pF, String pP, String vS, String tM, String fM, String sM, String gM, String wM, String hS, String hD) {
        this.eId = eId;
        this.phone = phone;
        this.pF = pF;
        this.pP = pP;
        this.vS = vS;
        this.tM = tM;
        this.fM = fM;
        this.sM = sM;
        this.gM = gM;
        this.wM = wM;
        this.hS = hS;
        this.hD = hD;
    }
}