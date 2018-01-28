package com.cdutcm.service.impl;

import com.cdutcm.dao.CategoryDao;
import com.cdutcm.entity.Category;
import com.cdutcm.service.CategoryService;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/16
 * Time: 22:06 星期六
 * Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private Logger log = Logger.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public boolean saveCategory(Category category, String status) {
        if ("exists".equals(status)) {
            categoryDao.updateCategory(category);
            return true;
        } else if (categoryDao.saveCategory(category)) {
            return true;
        }
        log.error("saveCategory is error");
        return false;
    }

    public String checkPhone(String phone) {
        Map<String, String> map = new HashMap<>(1);
        if (categoryDao.selectCategory(null, phone) != null) {
            map.put("status", "exists");//已存在此电话号码
        } else {
            map.put("status", "no-exists");//不存在此电话号码
        }
        return new Gson().toJson(map);
    }

    @Override
    public Category queryCategory(String name, String phone) {
        name = name.trim();
        phone = phone.trim();
        if ("".equals(name)) {
            name = null;
        }
        if ("".equals(phone)) {
            phone = null;
        }
        return categoryDao.selectCategory(name, phone);
    }

    @Override
    public boolean deleteCategory(String phone) {
        return categoryDao.deleteCategory(phone);
    }
}
