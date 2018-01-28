package com.cdutcm.service;

import com.cdutcm.entity.Category;
import com.cdutcm.model.Respondent;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/17
 * Time: 23:55 星期日
 * Description:
 */
public interface ConclusionService {
    /**
     * 保存Respondent到Conclusion,基本信息保存
     * @param respondent
     * @param category
     * @param repeat
     * @param status
     * @return
     */
    Respondent saveRespondent(Respondent respondent, Category category, Boolean repeat, String status);

    /**
     * 设置阴阳值
     * @param list
     * @param phone
     * @return
     */
    boolean setYinYangValue(List<Integer> list, String phone);

    /**
     * 生成HSSFWorkbook,打印Excel
     * @return
     * @throws IOException
     */
    HSSFWorkbook printConclusion() throws IOException;

    /**
     * 删除Conclusion
     * @param phone
     * @return
     */
    boolean deleteConclusion(String phone);

    /**
     * 通过name\phone查询Conclusion,
     * @param name
     * @param phone
     * @return -1.没有找到 0.找到1个 1.找到多个
     */
    List<String> queryConclusion(String name, String phone);
}
