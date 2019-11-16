package com.cdutcm.elements.dao;

import com.cdutcm.elements.entity.InbornPre;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/6/6 9:56 星期三
 * Description:
 */
@Mapper
@Component
public interface InbornPreDao {
    Boolean insertInbornPre(InbornPre inbornPre);

    Boolean deleteInbornPre(@Param("inbornPre") InbornPre inbornPre);

    Boolean updateInbornPre(InbornPre inbornPre);

    List<InbornPre> selectInbornPre(@Param("inbornPre") InbornPre inbornPre);
}
