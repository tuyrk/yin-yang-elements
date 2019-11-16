package com.cdutcm.elements.utils;

import com.cdutcm.elements.enums.ResultEnum;
import com.cdutcm.elements.vo.ResultVO;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 13:39 星期一
 * Description:
 */
public class ResultVOUtils {
    public static ResultVO success(ResultEnum resultEnum, Object object) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMsg());
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(Object object) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("success");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success() {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("success");
        return resultVO;
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
