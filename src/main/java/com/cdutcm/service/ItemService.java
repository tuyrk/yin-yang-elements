package com.cdutcm.service;

import com.cdutcm.entity.*;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/18
 * Time: 15:11 星期一
 * Description:
 */
public interface ItemService {
    int[] saveItemWood(ItemWood itemWood);

    int[] saveItemFire(ItemFire itemFire);

    int[] saveItemEarth(ItemEarth itemEarth);

    int[] saveItemMetal(ItemMetal itemMetal);

    int[] saveItemWater(ItemWater itemWater);

    /**
     * //如果修改了Category数据则删除Item,并设置yin_yangValue为null
     * @param category
     * @param status
     * @param acquireGenus
     * @return
     */
    boolean deleteItem(Category category, String status, String acquireGenus);

    boolean deleteItem(String phone);

    ItemWood queryWood(String phone);

    ItemFire queryFire(String phone);

    ItemEarth queryEarth(String phone);

    ItemMetal queryMetal(String phone);

    ItemWater queryWater(String phone);
}
