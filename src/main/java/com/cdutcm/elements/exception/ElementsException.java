package com.cdutcm.elements.exception;

import com.cdutcm.elements.enums.ResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/2/4 17:30 星期日
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ElementsException extends RuntimeException {
    private Integer code;

    public ElementsException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ElementsException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
