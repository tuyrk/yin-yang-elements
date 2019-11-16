package com.cdutcm.elements.dao;

import com.cdutcm.elements.entity.Inborn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 9:10 星期一
 * Description:
 */
@Mapper
@Component
public interface InbornDao {
    Boolean insertInborn(Inborn inborn);

    Boolean deleteInborn(@Param("inborn") Inborn inborn);

    Boolean updateInborn(Inborn inborn);

    List<Inborn> selectInborn(@Param("inborn") Inborn inborn);
}
