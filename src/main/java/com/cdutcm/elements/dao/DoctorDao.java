package com.cdutcm.elements.dao;

import com.cdutcm.elements.entity.Doctor;
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
public interface DoctorDao {
    Boolean insertDoctor(Doctor doctor);

    Boolean deleteDoctor(@Param("doctor") Doctor doctor);

    Boolean updateDoctor(Doctor doctor);

    List<Doctor> selectDoctor(@Param("doctor") Doctor doctor);

    Doctor selectDoctorByUsernameOrMail(@Param("username") String username, @Param("mail") String mail);
}
