package com.cdutcm.elements.vo;

import lombok.Data;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 13:37 星期一
 * Description:
 */
@Data
public class ResultVO<T> {
    /* 状态码 */
    private Integer code;
    /* 状态信息 */
    private String msg;
    /* 返回内容 */
    private T data;
}
