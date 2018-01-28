package com.cdutcm.dao;

import com.cdutcm.entity.Conclusion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/18
 * Time: 10:13 星期一
 * Description:
 */
public interface ConclusionDao {
    /**
     * 查找数据,通过手机号码查找结论
     *
     * @param phone 手机号码
     * @return
     */
    List<String> selectConclusion(@Param("name") String name, @Param("phone") String phone);

    /**
     * 插入数据,保存Respondent(添加Respondent)
     *
     * @param conclusion
     * @return
     */
    boolean saveRespondent(Conclusion conclusion);

    /**
     * 设置阴值和阳值
     *
     * @param conclusion
     * @return
     */
    boolean setYinYangValue(Conclusion conclusion);

    /**
     * 更新数据,表中已有数据对其进行修改(添加后天五行数据)
     *
     * @param conclusion
     * @return
     */
    boolean updateRespondent_Acquire(Conclusion conclusion);

    /**
     * 更新数据,表中已有数据对其进行修改(添加先天五行数据)
     *
     * @return
     */
    boolean updateRespondent_Inborn();

    /**
     * 打印Conclusion表
     *
     * @return
     */
    List<Conclusion> printConclusion();

    boolean clearYinYangValue(String phone);

    boolean deleteConclusion(String phone);
}
