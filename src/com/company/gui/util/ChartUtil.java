package com.company.gui.util;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;

import java.awt.*;

/*
* 图表工具
* */
public class ChartUtil {
    public static int max(double[] values) {
        int vMax = (int) values[0];
        for (double value : values) {
            if (vMax < value) vMax = (int) value;
        }

        return vMax;
    }

    private static double[] sampleValues() {

        double[] result = new double[30];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (Math.random() * 300);
        }
        return result;

    }

    private static String[] sampleLabels() {
        String[] sampleLabels = new String[30];

        for (int i = 0; i < sampleLabels.length; i++) {
            if (0 == i % 5)
                sampleLabels[i] = String.valueOf(i + 1 + "日");
        }
        return sampleLabels;
    }

    /*
    * 获得表格图片
    * @param width 图片的宽
    * @param height 图片的高
    * @return 表格图片
    * */
    public static Image getImage(int width, int height) {
        // 数据和标签
        double[] values = sampleValues();
        String[] labels = sampleLabels();

        Color[] colors = {ColorUtil.blueColor};
        BarChart chart = new BarChart();

        chart.setSampleCount(values.length);
        chart.setSampleValues(0, values);
        chart.setSampleLabels(labels);
        chart.setSampleColors(colors);
        chart.setRange(0, max(values) * 1.2);
        chart.setValueLinesOn(true);
        chart.setSampleLabelsOn(true);
        chart.setSampleLabelStyle(Chart.BELOW);
        chart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
        chart.setLegendOn(true);
        chart.setLegendPosition(Chart.LEFT);
        chart.setLegendLabels(new String[] { "月消费报表" });
        chart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));
        chart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
        chart.setChartBackground(Color.white);
        chart.setBackground(ColorUtil.backgroundColor);
        Image im = chart.getImage(width, height);

        return im;
    }
}

