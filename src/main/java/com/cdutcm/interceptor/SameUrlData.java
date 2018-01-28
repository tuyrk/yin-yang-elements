package com.cdutcm.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/21
 * Time: 0:26 星期四
 * Description:
 * 一个用户 相同url 同时提交 相同数据 验证
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SameUrlData {
}
