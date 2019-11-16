package com.cdutcm.elements.dao;

import com.cdutcm.elements.entity.Admin;
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
public interface AdminDao {
    Boolean insertAdmin(Admin admin);

    Boolean deleteAdmin(@Param("admin") Admin admin);

    Boolean updateAdmin(Admin admin);

    List<Admin> selectAdmin(@Param("admin") Admin admin);
}
