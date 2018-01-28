package com.cdutcm.controller;

import com.cdutcm.entity.*;
import com.cdutcm.interceptor.SameUrlData;
import com.cdutcm.model.Respondent;
import com.cdutcm.service.CategoryService;
import com.cdutcm.service.ConclusionService;
import com.cdutcm.service.ItemService;
import com.google.gson.Gson;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Date: 2017/12/16
 * Time: 17:46 星期六
 * Description:
 */
@Controller
@RequestMapping("/doctor")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class DataController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ConclusionService conclusionService;
    @Autowired
    private ItemService itemService;

    /**
     * 首页
     *
     * @return
     */
    @GetMapping("")
    public String index() {
        return "doctor/index";
    }

    @ResponseBody
    @PostMapping("/checkPhone")
    public String checkPhone(String phone) {
        return categoryService.checkPhone(phone);
    }

    /**
     * @param respondent
     * @param category
     * @return
     */
    @SameUrlData
    @PostMapping("/qualitative")
    public ModelAndView qualitative(Respondent respondent, Category category, String status, HttpSession session) {
        ModelAndView mav = new ModelAndView("doctor/qualitative");
        Boolean repeat = (Boolean) session.getAttribute("repeat");//是否重复提交
        respondent = conclusionService.saveRespondent(respondent, category, repeat, status);
        mav.addObject("respondent", respondent);
        if (itemService.deleteItem(category, status, respondent.getAcquireGenus())) {//未修改Category
            char[] genus = respondent.getAcquireGenus().toCharArray();
            if (genus[0] == '1') {
                ItemWood itemWood = itemService.queryWood(category.getPhone());
                mav.addObject("itemWood", itemWood);
            }
            if (genus[1] == '1') {
                ItemFire itemFire = itemService.queryFire(category.getPhone());
                mav.addObject("itemFire", itemFire);
            }
            if (genus[2] == '1') {
                ItemEarth itemEarth = itemService.queryEarth(category.getPhone());
                mav.addObject("itemEarth", itemEarth);
            }
            if (genus[3] == '1') {
                ItemMetal itemMetal = itemService.queryMetal(category.getPhone());
                mav.addObject("itemMetal", itemMetal);
            }
            if (genus[4] == '1') {
                ItemWater itemWater = itemService.queryWater(category.getPhone());
                mav.addObject("itemWater", itemWater);
            }
        }
        if (!repeat) {
            categoryService.saveCategory(category, status);
        }
        return mav;
    }

    /**
     * /tpls/index 数据采集
     *
     * @param itemEarth
     * @param itemFire
     * @param itemMetal
     * @param itemWater
     * @param itemWood
     * @return
     */
    @PostMapping("/index")
    public String scada(ItemEarth itemEarth, ItemFire itemFire, ItemMetal itemMetal, ItemWater itemWater, ItemWood itemWood, HttpSession session) {
        try {
            List<Integer> list = new ArrayList<>(6);
            int[] tmp;
            if ("wood".equals(itemWood.getWood())) {
                tmp = itemService.saveItemWood(itemWood);
                list.add(tmp[0]);
                list.add(tmp[1]);
            }
            if ("fire".equals(itemFire.getFire())) {
                tmp = itemService.saveItemFire(itemFire);
                list.add(tmp[0]);
                list.add(tmp[1]);
            }
            if ("earth".equals(itemEarth.getEarth())) {
                tmp = itemService.saveItemEarth(itemEarth);
                list.add(tmp[0]);
                list.add(tmp[1]);
            }
            if ("metal".equals(itemMetal.getMetal())) {
                tmp = itemService.saveItemMetal(itemMetal);
                list.add(tmp[0]);
                list.add(tmp[1]);
            }
            if ("water".equals(itemWater.getWater())) {
                tmp = itemService.saveItemWater(itemWater);
                list.add(tmp[0]);
                list.add(tmp[1]);
            }
            conclusionService.setYinYangValue(list, itemWood.getPhone());
            session.setAttribute("state", "录入成功!");
        } catch (Exception e) {
            session.setAttribute("state", "录入失败!");
        }
        return "redirect:/doctor/";
    }

    @PostMapping("/queryData")
    public ModelAndView queryData(String name, String phone) {
        ModelAndView modelAndView = new ModelAndView("doctor/index");
        modelAndView.addObject("name", name);
        modelAndView.addObject("phone", phone);
        List<String> list = conclusionService.queryConclusion(name, phone);
        if (list.size() == 1) {//刚好找到一条记录
            modelAndView.addObject("status", "exists");
            modelAndView.addObject("category", categoryService.queryCategory(name, phone));
            modelAndView.addObject("state", "查找成功!");
        } else if (list.size() > 1) {//找到多条记录
            modelAndView.addObject("state", "姓名重复,请输入手机号码!");
        } else {//未找到记录
            modelAndView.addObject("state", "查无此人!");
        }
        return modelAndView;
    }

    @ResponseBody
    @PostMapping("/deleteData")
    public String deleteData(String name, String phone) {
        Map<String, String> map = new HashMap<>(1);
        List<String> list = conclusionService.queryConclusion(name, phone);
        if (list.size() == 1) {//刚好找到一条记录
            categoryService.deleteCategory(list.get(0));
            conclusionService.deleteConclusion(list.get(0));
            itemService.deleteItem(list.get(0));
            map.put("status", "success");//删除成功
        } else if (list.size() > 1) {//找到多条记录
            map.put("status", "repeat");
        } else {//未找到记录
            map.put("status", "no-exists");
        }
        return new Gson().toJson(map);
    }

    @GetMapping("/exportData")
    public void importData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = conclusionService.printConclusion();
        ServletOutputStream out = response.getOutputStream();
        String filename = "阴阳五行数据表";
        if (!request.getHeader("user-agent").contains("MSIE")) {
            filename = java.net.URLEncoder.encode(filename, "utf-8") + ".xls";
        } else {
            filename = new String(filename.getBytes("utf-8"), "iso-8859-1") + ".xls";
        }
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        response.setContentType("application/msexcel");
        workbook.write(out);
        out.flush();// 清除缓存
        out.close();
    }
}
