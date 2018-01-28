package com.cdutcm.service.impl;

import com.cdutcm.dao.CategoryDao;
import com.cdutcm.dao.ConclusionDao;
import com.cdutcm.dao.ItemDao;
import com.cdutcm.entity.*;
import com.cdutcm.service.ItemService;
import com.cdutcm.util.ElementsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/18
 * Time: 15:11 星期一
 * Description:
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ConclusionDao conclusionDao;

    @Override
    public int[] saveItemWood(ItemWood itemWood) {
        int qualitativeA = 0;
        int qualitativeK = 0;
        //region addQualitativeA and addQualitativeK
        int iw1 = stringToInt(itemWood.getWoodComplexion());
        if (iw1 > 0) {
            qualitativeA += iw1;
        } else {
            qualitativeK += iw1;
        }
        int iw2 = stringToInt(itemWood.getWoodPsychology());
        if (iw2 > 0) {
            qualitativeA += iw2;
        } else {
            qualitativeK += iw2;
        }
        int iw3 = stringToInt(itemWood.getWoodCold());
        if (iw3 > 0) {
            qualitativeA += iw3;
        } else {
            qualitativeK += iw3;
        }
        int iw4 = stringToInt(itemWood.getWoodSweat());
        if (iw4 > 0) {
            qualitativeA += iw4;
        } else {
            qualitativeK += iw4;
        }
        int iw5 = stringToInt(itemWood.getWoodDiet());
        if (iw5 > 0) {
            qualitativeA += iw5;
        } else {
            qualitativeK += iw5;
        }
        int iw6 = stringToInt(itemWood.getWoodShit());
        if (iw6 > 0) {
            qualitativeA += iw6;
        } else {
            qualitativeK += iw6;
        }
        int iw7 = stringToInt(itemWood.getWoodUrine());
        if (iw7 > 0) {
            qualitativeA += iw7;
        } else {
            qualitativeK += iw7;
        }
        int iw8 = stringToInt(itemWood.getWoodSleep());
        if (iw8 > 0) {
            qualitativeA += iw8;
        } else {
            qualitativeK += iw8;
        }
        int iw9 = stringToInt(itemWood.getWoodDizzy());
        if (iw9 > 0) {
            qualitativeA += iw9;
        } else {
            qualitativeK += iw9;
        }
        int iw10 = stringToInt(itemWood.getWoodEyes());
        if (iw10 > 0) {
            qualitativeA += iw10;
        } else {
            qualitativeK += iw10;
        }
        int iw11 = stringToInt(itemWood.getWoodChest());
        if (iw11 > 0) {
            qualitativeA += iw11;
        } else {
            qualitativeK += iw11;
        }
        int iw12 = stringToInt(itemWood.getWoodLimbs());
        if (iw12 > 0) {
            qualitativeA += iw12;
        } else {
            qualitativeK += iw12;
        }
        try {
            int iw13 = stringToInt(itemWood.getWoodMenstruate());
            if (iw13 > 0) {
                qualitativeA += iw13;
            } else {
                qualitativeK += iw13;
            }
        } catch (Exception e) {
        }
        int iw14 = stringToInt(itemWood.getWoodSeason());
        if (iw14 > 0) {
            qualitativeA += iw14;
        } else {
            qualitativeK += iw14;
        }
        //endregion
        itemWood.setQualitativeA(qualitativeA);
        itemWood.setQualitativeK(qualitativeK);
        try {
            if (itemDao.selectWoodByCard(itemWood.getPhone()) != null) {//存在此人
                itemDao.updateWood(itemWood);//更新信息
            } else {
                itemDao.saveWood(itemWood);//插入信息
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new int[]{qualitativeA, qualitativeK};
    }

    @Override
    public int[] saveItemFire(ItemFire itemFire) {
        int qualitativeA = 0;
        int qualitativeK = 0;
        //region addQualitativeA and addQualitativeK
        int iw1 = stringToInt(itemFire.getFireComplexion());
        if (iw1 > 0) {
            qualitativeA += iw1;
        } else {
            qualitativeK += iw1;
        }
        int iw2 = stringToInt(itemFire.getFirePsychology());
        if (iw2 > 0) {
            qualitativeA += iw2;
        } else {
            qualitativeK += iw2;
        }
        int iw3 = stringToInt(itemFire.getFireCold());
        if (iw3 > 0) {
            qualitativeA += iw3;
        } else {
            qualitativeK += iw3;
        }
        int iw4 = stringToInt(itemFire.getFireSweat());
        if (iw4 > 0) {
            qualitativeA += iw4;
        } else {
            qualitativeK += iw4;
        }
        int iw5 = stringToInt(itemFire.getFireDiet());
        if (iw5 > 0) {
            qualitativeA += iw5;
        } else {
            qualitativeK += iw5;
        }
        int iw6 = stringToInt(itemFire.getFireUrine());
        if (iw6 > 0) {
            qualitativeA += iw6;
        } else {
            qualitativeK += iw6;
        }
        int iw7 = stringToInt(itemFire.getFireSleep());
        if (iw7 > 0) {
            qualitativeA += iw7;
        } else {
            qualitativeK += iw7;
        }
        int iw8 = stringToInt(itemFire.getFireMental());
        if (iw8 > 0) {
            qualitativeA += iw8;
        } else {
            qualitativeK += iw8;
        }
        int iw9 = stringToInt(itemFire.getFireLips());
        if (iw9 > 0) {
            qualitativeA += iw9;
        } else {
            qualitativeK += iw9;
        }
        int iw10 = stringToInt(itemFire.getFireMind());
        if (iw10 > 0) {
            qualitativeA += iw10;
        } else {
            qualitativeK += iw10;
        }
        int iw11 = stringToInt(itemFire.getFireProne());
        if (iw11 > 0) {
            qualitativeA += iw11;
        } else {
            qualitativeK += iw11;
        }
        int iw12 = stringToInt(itemFire.getFireSeason());
        if (iw12 > 0) {
            qualitativeA += iw12;
        } else {
            qualitativeK += iw12;
        }
        //endregion
        itemFire.setQualitativeA(qualitativeA);
        itemFire.setQualitativeK(qualitativeK);
        try {
            if (itemDao.selectFireByCard(itemFire.getPhone()) != null) {//存在此人
                itemDao.updateFire(itemFire);//更新信息
            } else {
                itemDao.saveFire(itemFire);//插入信息
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new int[]{qualitativeA, qualitativeK};
    }

    @Override
    public int[] saveItemEarth(ItemEarth itemEarth) {
        int qualitativeA = 0;
        int qualitativeK = 0;
        //region addQualitativeA and addQualitativeK
        int iw1 = stringToInt(itemEarth.getEarthComplexion());
        if (iw1 > 0) {
            qualitativeA += iw1;
        } else {
            qualitativeK += iw1;
        }
        int iw2 = stringToInt(itemEarth.getEarthPsychology());
        if (iw2 > 0) {
            qualitativeA += iw2;
        } else {
            qualitativeK += iw2;
        }
        int iw3 = stringToInt(itemEarth.getEarthDiet());
        if (iw3 > 0) {
            qualitativeA += iw3;
        } else {
            qualitativeK += iw3;
        }
        int iw4 = stringToInt(itemEarth.getEarthShit());
        if (iw4 > 0) {
            qualitativeA += iw4;
        } else {
            qualitativeK += iw4;
        }
        int iw5 = stringToInt(itemEarth.getEarthMental());
        if (iw5 > 0) {
            qualitativeA += iw5;
        } else {
            qualitativeK += iw5;
        }
        int iw6 = stringToInt(itemEarth.getEarthBody());
        if (iw6 > 0) {
            qualitativeA += iw6;
        } else {
            qualitativeK += iw6;
        }
        int iw7 = stringToInt(itemEarth.getEarthLips());
        if (iw7 > 0) {
            qualitativeA += iw7;
        } else {
            qualitativeK += iw7;
        }
        int iw8 = stringToInt(itemEarth.getEarthStomach());
        if (iw8 > 0) {
            qualitativeA += iw8;
        } else {
            qualitativeK += iw8;
        }
        int iw9 = stringToInt(itemEarth.getEarthSeason());
        if (iw9 > 0) {
            qualitativeA += iw9;
        } else {
            qualitativeK += iw9;
        }
        //endregion
        itemEarth.setQualitativeA(qualitativeA);
        itemEarth.setQualitativeK(qualitativeK);
        try {
            if (itemDao.selectEarthByCard(itemEarth.getPhone()) != null) {//存在此人
                itemDao.updateEarth(itemEarth);//更新信息
            } else {
                itemDao.saveEarth(itemEarth);//插入信息
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new int[]{qualitativeA, qualitativeK};
    }

    @Override
    public int[] saveItemMetal(ItemMetal itemMetal) {
        int qualitativeA = 0;
        int qualitativeK = 0;
        //region addQualitativeA and addQualitativeK
        int iw1 = stringToInt(itemMetal.getMetalComplexion());
        if (iw1 > 0) {
            qualitativeA += iw1;
        } else {
            qualitativeK += iw1;
        }
        int iw2 = stringToInt(itemMetal.getMetalPsychology());
        if (iw2 > 0) {
            qualitativeA += iw2;
        } else {
            qualitativeK += iw2;
        }
        int iw3 = stringToInt(itemMetal.getMetalSweat());
        if (iw3 > 0) {
            qualitativeA += iw3;
        } else {
            qualitativeK += iw3;
        }
        int iw4 = stringToInt(itemMetal.getMetalDiet());
        if (iw4 > 0) {
            qualitativeA += iw4;
        } else {
            qualitativeK += iw4;
        }
        int iw5 = stringToInt(itemMetal.getMetalShit());
        if (iw5 > 0) {
            qualitativeA += iw5;
        } else {
            qualitativeK += iw5;
        }
        int iw6 = stringToInt(itemMetal.getMetalMental());
        if (iw6 > 0) {
            qualitativeA += iw6;
        } else {
            qualitativeK += iw6;
        }
        int iw7 = stringToInt(itemMetal.getMetalCough());
        if (iw7 > 0) {
            qualitativeA += iw7;
        } else {
            qualitativeK += iw7;
        }
        int iw8 = stringToInt(itemMetal.getMetalExpectoration());
        if (iw8 > 0) {
            qualitativeA += iw8;
        } else {
            qualitativeK += iw8;
        }
        int iw9 = stringToInt(itemMetal.getMetalNose());
        if (iw9 > 0) {
            qualitativeA += iw9;
        } else {
            qualitativeK += iw9;
        }
        int iw10 = stringToInt(itemMetal.getMetalSkin());
        if (iw10 > 0) {
            qualitativeA += iw10;
        } else {
            qualitativeK += iw10;
        }
        int iw11 = stringToInt(itemMetal.getMetalSeason());
        if (iw11 > 0) {
            qualitativeA += iw11;
        } else {
            qualitativeK += iw11;
        }
        //endregion
        itemMetal.setQualitativeA(qualitativeA);
        itemMetal.setQualitativeK(qualitativeK);
        try {
            if (itemDao.selectMetalByCard(itemMetal.getPhone()) != null) {//存在此人
                itemDao.updateMetal(itemMetal);//更新信息
            } else {
                itemDao.saveMetal(itemMetal);//插入信息
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new int[]{qualitativeA, qualitativeK};
    }

    @Override
    public int[] saveItemWater(ItemWater itemWater) {
        int qualitativeA = 0;
        int qualitativeK = 0;
        //region addQualitativeA and addQualitativeK
        int iw1 = stringToInt(itemWater.getWaterComplexion());
        if (iw1 > 0) {
            qualitativeA += iw1;
        } else {
            qualitativeK += iw1;
        }
        int iw2 = stringToInt(itemWater.getWaterPsychology());
        if (iw2 > 0) {
            qualitativeA += iw2;
        } else {
            qualitativeK += iw2;
        }
        int iw3 = stringToInt(itemWater.getWaterSweat());
        if (iw3 > 0) {
            qualitativeA += iw3;
        } else {
            qualitativeK += iw3;
        }
        int iw4 = stringToInt(itemWater.getWaterUrine());
        if (iw4 > 0) {
            qualitativeA += iw4;
        } else {
            qualitativeK += iw4;
        }
        int iw5 = stringToInt(itemWater.getWaterWaist());
        if (iw5 > 0) {
            qualitativeA += iw5;
        } else {
            qualitativeK += iw5;
        }
        int iw6 = stringToInt(itemWater.getWaterSexuality());
        if (iw6 > 0) {
            qualitativeA += iw6;
        } else {
            qualitativeK += iw6;
        }
        try {
            int iw7 = stringToInt(itemWater.getWaterSpermatorrhea());
            if (iw7 > 0) {
                qualitativeA += iw7;
            } else {
                qualitativeK += iw7;
            }
            int iw8 = stringToInt(itemWater.getWaterMenstruate());
            if (iw8 > 0) {
                qualitativeA += iw8;
            } else {
                qualitativeK += iw8;
            }
        } catch (Exception e) {
        }
        int iw9 = stringToInt(itemWater.getWaterLeucorrhea());
        if (iw9 > 0) {
            qualitativeA += iw9;
        } else {
            qualitativeK += iw9;
        }
        int iw10 = stringToInt(itemWater.getWaterSeason());
        if (iw10 > 0) {
            qualitativeA += iw10;
        } else {
            qualitativeK += iw10;
        }
        //endregion
        itemWater.setQualitativeA(qualitativeA);
        itemWater.setQualitativeK(qualitativeK);
        try {
            if (itemDao.selectWaterByCard(itemWater.getPhone()) != null) {//存在此人
                itemDao.updateWater(itemWater);//更新信息
            } else {
                itemDao.saveWater(itemWater);//插入信息
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new int[]{qualitativeA, qualitativeK};
    }

    @Override
    public boolean deleteItem(Category category, String status, String acquireGenus) {
        if ("exists".equals(status)) {
            Category originCategory = categoryDao.selectCategory(null, category.getPhone());
            if (acquireGenus.equals(ElementsUtil.ensureElements(originCategory).get(0))) {//修改了Category
                return true;//未修改Category
            }
            itemDao.deleteItem(category.getPhone());
            conclusionDao.clearYinYangValue(category.getPhone());
            return false;//修改了Category
        }
        return false;//不存在Category
    }

    @Override
    public boolean deleteItem(String phone) {
        itemDao.deleteItem(phone);
        return true;
    }

    @Override
    public ItemWood queryWood(String phone) {
        return itemDao.selectWoodByCard(phone);
    }

    @Override
    public ItemFire queryFire(String phone) {
        return itemDao.selectFireByCard(phone);
    }

    @Override
    public ItemEarth queryEarth(String phone) {
        return itemDao.selectEarthByCard(phone);
    }

    @Override
    public ItemMetal queryMetal(String phone) {
        return itemDao.selectMetalByCard(phone);
    }

    @Override
    public ItemWater queryWater(String phone) {
        return itemDao.selectWaterByCard(phone);
    }

    private Integer stringToInt(String string) {
        switch (string) {
            case "A":
                return -2;
            case "B":
                return -1;
            case "C":
                return 0;
            case "D":
                return 1;
            case "E":
                return 2;
        }
        return 0;
    }
}
