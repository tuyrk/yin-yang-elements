package com.cdutcm.dao;

import com.cdutcm.entity.*;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/18
 * Time: 15:12 星期一
 * Description:
 */
public interface ItemDao {
    ItemWood selectWoodByCard(String phone);

    boolean saveWood(ItemWood itemWood);

    boolean updateWood(ItemWood itemWood);

    ItemFire selectFireByCard(String phone);

    boolean saveFire(ItemFire itemFire);

    boolean updateFire(ItemFire itemFire);

    ItemEarth selectEarthByCard(String phone);

    boolean saveEarth(ItemEarth itemEarth);

    boolean updateEarth(ItemEarth itemEarth);

    ItemMetal selectMetalByCard(String phone);

    boolean saveMetal(ItemMetal itemEarth);

    boolean updateMetal(ItemMetal itemEarth);

    ItemWater selectWaterByCard(String phone);

    boolean saveWater(ItemWater itemWater);

    boolean updateWater(ItemWater itemWater);

    void deleteItem(String phone);
}
