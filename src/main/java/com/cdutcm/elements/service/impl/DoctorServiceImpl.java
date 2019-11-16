package com.cdutcm.elements.service.impl;

import com.cdutcm.elements.dao.DoctorDao;
import com.cdutcm.elements.entity.Doctor;
import com.cdutcm.elements.enums.ResultEnum;
import com.cdutcm.elements.exception.ElementsException;
import com.cdutcm.elements.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/17 11:02 星期四
 * Description:
 */
@Slf4j
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDao doctorDao;

    @Override
    public boolean insertDoctor(Doctor doctor, Doctor sessionDoctor) {
        /* 需要验证码的注册
        if (!sessionDoctor.equals(doctor)) {
            throw new ElementsException(ResultEnum.USER_ERROR);
        }
         */
        if (doctorDao.selectDoctorByUsernameOrMail(doctor.getUsername(), doctor.getMail()) == null) {
            doctor.setPassword(DigestUtils.md5DigestAsHex(doctor.getPassword().getBytes()));
            doctor.setState(1);// 设置为激活状态
            if (doctorDao.insertDoctor(doctor)) {
                return true;
            }
            throw new ElementsException(ResultEnum.REGISTRY_ERROR);
        }
        throw new ElementsException(ResultEnum.USER_EXIST);
    }

    @Override
    public boolean deleteDoctor(Doctor doctor) {
        if (doctorDao.deleteDoctor(selectDoctor(doctor))) {
            return true;
        }
        throw new ElementsException(ResultEnum.DELETE_ERROR);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor, Doctor selectDoctor) {
        if (doctor.getMail() != null && !"".equals(doctor.getMail())) {
            selectDoctor.setMail(doctor.getMail());
        }
        if (doctor.getPassword() != null && !"".equals(doctor.getPassword())) {
            selectDoctor.setPassword(DigestUtils.md5DigestAsHex(doctor.getPassword().getBytes()));
        }
        if (doctorDao.updateDoctor(selectDoctor)) {
            return selectDoctor;
        }
        throw new ElementsException(ResultEnum.UPDATE_ERROR);
    }

    @Override
    public Doctor selectDoctor(Doctor doctor) {
        List<Doctor> doctorList = doctorDao.selectDoctor(doctor);
        if (doctorList.size() == 0) {
            throw new ElementsException(ResultEnum.USER_NOT_EXIST);
        }
        return doctorList.get(0);
    }
}
