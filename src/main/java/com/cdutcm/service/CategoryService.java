package com.cdutcm.service;

import com.cdutcm.entity.Category;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/16
 * Time: 22:06 星期六
 * Description:
 */
public interface CategoryService {
    boolean saveCategory(Category category,String status);

    String checkPhone(String phone);

    Category queryCategory(String name, String phone);

    boolean deleteCategory(String phone);
}