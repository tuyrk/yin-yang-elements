package com.cdutcm.dao;

import com.cdutcm.entity.Doctor;
import org.apache.ibatis.annotations.Param;

import javax.print.Doc;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/26
 * Time: 21:22 星期二
 * Description:
 */
public interface DoctorDao {
    /**
     * 通过Doctor查找用户
     * @param doctor
     * @return
     */
    Doctor selectDoctor(Doctor doctor);

    /**
     * 医生注册,插入Doctor
     *
     * @param doctor
     * @return
     */
    boolean insertDoctor(Doctor doctor);

    /**
     * 根据mail更新Doctor
     * @param doctor
     * @return
     * @Param("mail") String mail,@Param("newPassword") String newPassword, @Param("newMail")String newMail
     */
    boolean updateDoctor(@Param("newMail") String newMail,@Param("doctor") Doctor doctor);
}
