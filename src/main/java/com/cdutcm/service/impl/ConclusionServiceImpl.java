package com.cdutcm.service.impl;

import com.cdutcm.dao.ConclusionDao;
import com.cdutcm.entity.Category;
import com.cdutcm.entity.Conclusion;
import com.cdutcm.model.Birth;
import com.cdutcm.model.Respondent;
import com.cdutcm.service.ConclusionService;
import com.cdutcm.util.ElementsUtil;
import com.cdutcm.util.ExcelUtil;
import com.cdutcm.util.calendarConverter.Lunar;
import com.cdutcm.util.calendarConverter.LunarSolarConverterUtil;
import com.cdutcm.util.calendarConverter.Solar;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/17
 * Time: 23:55 星期日
 * Description:
 */
@Service
public class ConclusionServiceImpl implements ConclusionService {
    private Logger log = Logger.getLogger(ConclusionServiceImpl.class);
    @Autowired
    private ConclusionDao conclusionDao;

    public Respondent saveRespondent(Respondent respondent, Category category, Boolean repeat, String status) {
        List<String> list = ElementsUtil.ensureElements(category);//获取后天所属,所缺\次
        respondent.setAcquireGenus(list.get(0));
        System.out.println("respondent = " + respondent.getAcquireGenus());
        if (!repeat) {
            Conclusion conclusion = new Conclusion();
            Birth birth = respondent.getBirth();
            String cal = birth.getDate().substring(0, 2);
            if ("公历".equals(cal)) {
                conclusion.setSolarBirth(birth.getDate().substring(2) + " " + birth.getHour() + ":" + birth.getMinute());
                String[] cals = birth.getDate().substring(2).split("-");
                Lunar lunar = LunarSolarConverterUtil.SolarToLunar(new Solar(Integer.parseInt(cals[0]), Integer.parseInt(cals[1]), Integer.parseInt(cals[2])));
                StringBuilder sb = new StringBuilder(20);
                sb.append(lunar.getLunarYear()).append("-");
                if (lunar.isIsleap()) {
                    sb.append("闰");
                }
                sb.append(lunar.getLunarMonth()).append("-").append(lunar.getLunarDay()).append(" ");
                sb.append(birth.getHour()).append(":").append(birth.getMinute());
                conclusion.setLunarBirth(sb.toString());
                log.info("this is 公历");
            } else {
                String[] cals = birth.getDate().substring(2).split("-");
                Solar solar = LunarSolarConverterUtil.LunarToSolar(new Lunar(Integer.parseInt(cals[0]), Integer.parseInt(cals[1]), Integer.parseInt(cals[2])));
                StringBuilder sb = new StringBuilder(20);
                sb.append(solar.getSolarYear()).append("-").append(solar.getSolarMonth()).append("-").append(solar.getSolarDay()).append(" ");
                sb.append(birth.getHour()).append(":").append(birth.getMinute());
                conclusion.setSolarBirth(sb.toString());
                conclusion.setLunarBirth(birth.getDate().substring(2) + " " + birth.getHour() + ":" + birth.getMinute());
                log.info("this is 公历");
            }
            conclusion.setPhone(respondent.getPhone());
            conclusion.setName(respondent.getName());
            conclusion.setSex(respondent.getSex());
            conclusion.setAcquireGenus(list.get(0));//后天所属
            conclusion.setAcquireLack(list.get(1));//后天所缺\次
            try {
                if ("exists".equals(status)) {//查询表中是否已有此人
                    conclusionDao.updateRespondent_Acquire(conclusion);//如果有此人,都数据进行修改即可
                    log.info("updateRespondent_Acquire is success");
                } else {
                    conclusionDao.saveRespondent(conclusion);//没有此人,添加此人数据
                    log.info("saveRespondent is success");
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error("saveRespondent is fail");
                return null;
            }
        }
        return respondent;
    }

    public boolean setYinYangValue(List<Integer> list, String phone) {
        Conclusion conclusion = new Conclusion();
        log.info("phone = " + phone);
        conclusion.setPhone(phone);
        int size = list.size();
        if (size >= 2) {
            conclusion.setYangValue1(list.get(0));
            conclusion.setYinValue1(list.get(1));
            if (size >= 4) {
                conclusion.setYangValue2(list.get(2));
                conclusion.setYinValue2(list.get(3));
                if (size >= 6) {
                    conclusion.setYangValue3(list.get(4));
                    conclusion.setYinValue3(list.get(5));
                }
            }
        }
        if (conclusionDao.setYinYangValue(conclusion)) {
            return true;
        }
        return false;
    }

    public HSSFWorkbook printConclusion() {
        List<Conclusion> conclusions = conclusionDao.printConclusion();
        String title = "阴阳五行数据表";
        String[] rowName = {"编号", "手机号", "姓名", "性别", "公历出生日期", "农历出生日期", "先天五行所属", "先天五行所缺", "后天五行所属", "后天五行所缺/次", "所属阳值1", "所属阳值2", "所属阳值3", "所属阴值1", "所属阴值2", "所属阴值3"};
        return ExcelUtil.createConclusionExcel(title, rowName, conclusions);
    }

    @Override
    public boolean deleteConclusion(String phone) {
        return conclusionDao.deleteConclusion(phone);
    }

    @Override
    public List<String> queryConclusion(String name, String phone) {
        name = name.trim();
        phone = phone.trim();
        if ("".equals(name)) {
            name = null;
        }
        if ("".equals(phone)) {
            phone = null;
        }
        return conclusionDao.selectConclusion(name, phone);
    }
}
