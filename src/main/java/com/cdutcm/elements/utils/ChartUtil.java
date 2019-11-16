package com.cdutcm.elements.utils;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

public class ChartUtil {
    public static JFreeChart getJFreeChart(String title, float[] attributes, String[] abscissa, Integer[] indexs) {
        CategoryDataset dataset = getCategoryDataset(attributes, abscissa);
        JFreeChart chart = ChartFactory.createBarChart(title, // 图表标题
                null,    // x轴标签
                null,    // y轴标签
                dataset,    // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                true,        // 是否显示图例(对于简单的柱状图必须是false)
                false,        // 是否生成工具
                false        // 是否生成URL链接
        );
        updatePlot(chart, indexs);
        updateFont(chart, abscissa.length);
        return chart;
    }

    private static CategoryDataset getCategoryDataset(float[] attributes, String[] abscissa) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < abscissa.length; i++) {
            dataset.addValue(attributes[i], abscissa[i], abscissa[i]);
        }
        return dataset;
    }

    private static void updateFont(JFreeChart chart, int n) {
        // 图表(柱形图)
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();

        // 标题
        TextTitle textTitle = chart.getTitle();
        textTitle.setFont(new Font("黑体", Font.PLAIN, 20));

        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setUpperMargin(0.1);
        categoryAxis.setLowerMargin(0.1);
        // X轴字体
        categoryAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 16));
        ValueAxis valueAxis = categoryPlot.getRangeAxis();
        // y轴字体
        valueAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 16));

        //设置图例类别字体
        chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 16));

        for (int i = 0; i < n; i++) {
            //显示每个柱的数值，并修改该数值的字体属性
            renderer.setSeriesItemLabelGenerator(i, new StandardCategoryItemLabelGenerator());
            //设置柱子上数值的字体
            renderer.setSeriesItemLabelFont(i, new Font("宋体", Font.PLAIN, 16));
            renderer.setSeriesItemLabelsVisible(i, true);
        }
    }

    private static void updatePlot(JFreeChart chart, Integer[] indexs) {
        // 图表
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();

        // 阴影效果
        renderer.setShadowVisible(true);
        //X轴偏移量
        renderer.setShadowXOffset(5);
        //Y轴偏移量
        renderer.setShadowYOffset(5);

        ValueAxis rangeAxis = categoryPlot.getRangeAxis();
        //设置最高的一个柱与图片顶端的距离
        rangeAxis.setUpperMargin(0.1);
        //设置最低的一个柱与图片底端的距离
        rangeAxis.setLowerMargin(0.1);
        categoryPlot.setRangeAxis(rangeAxis);

        //设置每一组柱状体之间的间隔
        if (indexs.length == 2) {
            renderer.setItemMargin(0);
        } else {
            renderer.setItemMargin(-2.5);
        }

        //设置柱的透明度
        //categoryPlot.setForegroundAlpha(0.8f);

        categoryPlot.setBackgroundPaint(Color.LIGHT_GRAY);
        categoryPlot.setRangeGridlinePaint(Color.BLACK);//数据轴网格线条颜色

        Color[] colors = {
                new Color(178, 136, 80),
                new Color(226, 17, 12),
                new Color(160, 82, 45),
                new Color(255, 215, 0),
                new Color(0, 255, 255)
        };

        for (int i = 0; i < indexs.length; i++) {
            if (indexs[i] == null) {
                continue;
            }
            renderer.setSeriesPaint(i, colors[indexs[i]]);
        }
    }
}
