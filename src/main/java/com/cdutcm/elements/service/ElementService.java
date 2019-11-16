package com.cdutcm.elements.service;

import com.cdutcm.elements.entity.Acquire;
import com.cdutcm.elements.entity.Inborn;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/18 14:34 星期五
 * Description:
 */
public interface ElementService {
    String inbornChart(Inborn inborn);

    String acquireElementChart(Acquire acquire);

    String acquireYinYangChart(Acquire acquire);
}
