package com.cdutcm.elements.dao;

import com.cdutcm.elements.entity.EAQ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 9:11 星期一
 * Description:
 */
@Mapper
@Component
public interface EAQDao {
    Boolean insertEAQ(EAQ eaq);

    Boolean deleteEAQ(@Param("eaq") EAQ eaq);

    Boolean updateEAQ(EAQ eaq);

    EAQ selectEAQByEaq(@Param("eaq") EAQ eaq);

    EAQ selectEAQByPhone(String phone);
}
