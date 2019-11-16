package com.cdutcm.elements.dao;

import com.cdutcm.elements.entity.Acquire;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/18 9:31 星期五
 * Description:
 */
@Mapper
@Component
public interface AcquireDao {
    Boolean insertAcquire(Acquire acquire);

    Boolean deleteAcquire(@Param("acquire") Acquire acquire);

    Boolean updateAcquire(Acquire acquire);

    List<Acquire> selectAcquire(@Param("acquire") Acquire acquire);
}
