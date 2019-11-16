package com.cdutcm.elements.handle;

import com.cdutcm.elements.exception.ElementsException;
import com.cdutcm.elements.utils.ResultVOUtils;
import com.cdutcm.elements.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/3/22 14:06 星期四
 * Description:
 */
@RestControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler
    public ResultVO handle(ElementsException e){
        return ResultVOUtils.error(e.getCode(), e.getMessage());
    }
}
