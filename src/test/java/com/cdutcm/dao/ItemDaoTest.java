package com.cdutcm.dao;

import com.cdutcm.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/1/17 22:33 星期三
 * Description:
 */
public class ItemDaoTest extends BaseTest {

    @Autowired
    private ItemDao itemDao;

    @Test
    public void deleteItem() {
        String phone = "18382471391";
        itemDao.deleteItem(phone);
    }
}
