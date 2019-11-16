package com.cdutcm.elements.service.impl;

import com.cdutcm.elements.entity.Acquire;
import com.cdutcm.elements.entity.Inborn;
import com.cdutcm.elements.enums.ResultEnum;
import com.cdutcm.elements.exception.ElementsException;
import com.cdutcm.elements.service.ElementService;
import com.cdutcm.elements.utils.ChartUtil;
import com.cdutcm.elements.utils.ElementsUtils;
import lombok.extern.slf4j.Slf4j;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/5/18 14:34 星期五
 * Description:
 */
@Slf4j
@Service
public class ElementServiceImpl implements ElementService {

    @Override
    public String inbornChart(Inborn inborn) {
        float[] attributes = {inborn.getWood(), inborn.getFire(), inborn.getEarth(), inborn.getMetal(), inborn.getWater()};
        String[] WXTable = {"木", "火", "土", "金", "水"};
        Integer[] indexs = {0, 1, 2, 3, 4};
        String url = "img/inborn/" + inborn.getPhone() + ".jpg";
        CreateChart("", attributes, WXTable, indexs, url);/*先天五行结构图*/
        return url;
    }

    @Override
    public String acquireElementChart(Acquire acquire) {
        float[] attributes = {acquire.getWood(), acquire.getFire(), acquire.getEarth(), acquire.getMetal(), acquire.getWater()};
        String[] WXTable = {"木", "火", "土", "金", "水"};
        Integer[] indexs = {0, 1, 2, 3, 4};
        String url = "img/acquire/element/" + acquire.getPhone() + ".jpg";
        CreateChart("", attributes, WXTable, indexs, url);/*后天五行结构图*/
        return url;
    }

    @Override
    public String acquireYinYangChart(Acquire acquire) {
        float[] postnatal = {acquire.getYinYangWood(), acquire.getYinYangFire(), acquire.getYinYangEarth(), acquire.getYinYangMetal(), acquire.getYinYangWater()};
        String[] WXTable = {"所属", "所次"};
        Integer[] indexs = ElementsUtils.acquire2Index(acquire);
        float[] attributes;
        if (indexs[1] == null) {//所次不存在
            attributes = new float[]{postnatal[indexs[0]], 0};
        } else {
            attributes = new float[]{postnatal[indexs[0]], postnatal[indexs[1]]};
        }
        String url = "img/acquire/yinyang/" + acquire.getPhone() + ".jpg";
        CreateChart("", attributes, WXTable, indexs, url);/*后天阴阳结构图*/
        return url;
    }

    private void CreateChart(String title, float[] attributes, String[] WXTable, Integer[] indexs, String filename) {
        JFreeChart chart = ChartUtil.getJFreeChart(title, attributes, WXTable, indexs);
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        try {
            URL url = ResourceUtils.getURL("classpath:static/img/chart/img_bg.png");
            Image image = new ImageIcon(url).getImage();
            categoryPlot.setBackgroundPaint(null);
            categoryPlot.setBackgroundImage(image);
            chart.setBackgroundImage(image);
            File dir = new File(filename.substring(0, filename.lastIndexOf('/')));
            if (!dir.mkdirs() && !dir.exists()) {
                throw new ElementsException(ResultEnum.SERVICE_ERROR);
            }
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(filename)));
            ChartUtils.writeChartAsJPEG(out, chart, 600, 350);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ElementsException(ResultEnum.SERVICE_ERROR);
        }
    }
}
