package com.cdutcm.dao;

import com.cdutcm.entity.Category;
import org.apache.ibatis.annotations.Param;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/18
 * Time: 9:44 星期一
 * Description:
 */
public interface CategoryDao {
    boolean saveCategory(Category category);

    boolean updateCategory(Category category);

    Category selectCategory(@Param("name") String name,@Param("phone") String phone);

    boolean deleteCategory(String phone);
}
