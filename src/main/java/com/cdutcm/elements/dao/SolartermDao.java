package com.cdutcm.elements.dao;

import com.cdutcm.elements.entity.Solarterm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/14 18:00 星期一
 * Description:
 */
@Mapper
@Component
public interface SolartermDao {
    Boolean saveSolarterm(@Param("solarterm") String solarterm, @Param("date") String date);

    Date selectLichunByYear(Integer year);

    Solarterm selectSolartermByDate(Date date);

    Date selectDateByID(Integer id);
}
