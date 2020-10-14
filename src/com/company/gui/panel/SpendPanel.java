package com.company.gui.panel;

import com.company.gui.util.CircleProgressBar;
import com.company.gui.util.ColorUtil;
import com.company.gui.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class SpendPanel extends JPanel {

    // 单例模式：方便监听器监听各个组件
    public static SpendPanel instance = new SpendPanel();

    // 描述控件
    JLabel lMonthSpend = new JLabel("本月消费");
    JLabel lTodaySpend = new JLabel("今日消费");
    JLabel lAverageSpend = new JLabel("日均消费");
    JLabel lMonthRest = new JLabel("本月剩余");
    JLabel lAverageAvailable = new JLabel("日均可用");
    JLabel lDaysToEnd = new JLabel("距离月末");

    // 数值控件
    public JLabel vMonthSpend = new JLabel("Test-Num");
    public JLabel vTodaySpend = new JLabel("Test-Num");
    public JLabel vAverageSpend = new JLabel("Test-Num");
    public JLabel vMonthRest = new JLabel("Test-Num");
    public JLabel vAverageAvailable = new JLabel("Test-Num");
    public JLabel vDaysToEnd = new JLabel("Test-Num");

    // 圆形进度条
    public CircleProgressBar circleProgressBar = new CircleProgressBar();

    private SpendPanel() {
        this.setLayout(new BorderLayout());
        circleProgressBar.setProgress(0);

        // 设置颜色
        GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAverageSpend, lMonthRest, lAverageAvailable, lDaysToEnd);
        GUIUtil.setColor(ColorUtil.grayColor, vMonthSpend, vTodaySpend, vAverageSpend, vMonthRest, vAverageAvailable, vDaysToEnd);

        // 设置字体
        vMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        vTodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));

        // 中间布局
        this.add(center(), BorderLayout.CENTER);
        // 南面布局
        this.add(south(), BorderLayout.SOUTH);

    }

    private JPanel center() {
        JPanel panel = new JPanel(new BorderLayout());

        // 西面布局
        panel.add(west(), BorderLayout.WEST);
        // 中间布局
        panel.add(center2(), BorderLayout.CENTER);

        return panel;
    }

    private JPanel south() {
        JPanel panel = new JPanel(new GridLayout(2, 4));

        panel.add(lAverageSpend);
        panel.add(lMonthRest);
        panel.add(lAverageAvailable);
        panel.add(lDaysToEnd);

        panel.add(vAverageSpend);
        panel.add(vMonthRest);
        panel.add(vAverageAvailable);
        panel.add(vDaysToEnd);

        return panel;
    }

    private Component center2() {
        return circleProgressBar;
    }

    private Component west() {
        JPanel panel = new JPanel(new GridLayout(4, 1));

        panel.add(lMonthSpend);
        panel.add(vMonthSpend);
        panel.add(lTodaySpend);
        panel.add(vTodaySpend);

        return panel;
    }

}
