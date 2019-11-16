package com.cdutcm.elements.enums;

import lombok.Getter;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 13:45 星期一
 * Description:
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "请求参数不正确"),
    USER_NOT_EXIST(2, "用户不存在"),
    USER_EXIST(3, "用户存在"),
    USER_ERROR(4, "用户错误"),
    REGISTRY_ERROR(5, "注册失败"),
    PASSWORD_ERROR(6, "密码错误"),
    UPDATE_ERROR(7, "修改失败"),

    MAIL_ERROR(8, "邮箱错误"),
    MAIL_EXIST(9, "邮箱已注册"),
    SEND_MAIL_ERROR(10, "邮件发送失败"),

    DATE_FORMAT_ERROR(11, "日期格式错误"),

    INFO_SAVE_ERROR(12, "信息保存失败"),

    NOT_FIND(13, "查找不存在"),
    NAME_REPEAT(14, "姓名重复"),
    DELETE_ERROR(15, "删除失败"),
    SERVICE_ERROR(16, "内部错误"),
    INFO_EXIST(17, "信息已存在");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
