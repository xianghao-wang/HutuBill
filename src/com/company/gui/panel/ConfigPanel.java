package com.company.gui.panel;

import com.company.gui.listener.ConfigListener;
import com.company.util.ColorUtil;
import com.company.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    public static ConfigPanel instance = new ConfigPanel();

    // 控件
    JLabel lBudget = new JLabel("本月预算(¥)");
    JLabel lMysql = new JLabel("Mysql安装目录");
    public JTextField tBudget = new JTextField();
    public JTextField tMysql = new JTextField();
    public JButton bSubmit = new JButton("更新");

    public ConfigPanel() {
        this.setLayout(new BorderLayout());

        // 设置颜色
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
        GUIUtil.setColor(ColorUtil.grayColor, lBudget, lMysql);

        this.add(north(), BorderLayout.NORTH);
        this.add(south(), BorderLayout.SOUTH);

        addListener();
    }

    public Component north() {
        int gap = 40;
        JPanel panel = new JPanel(new GridLayout(4, 1, gap, gap));

        panel.add(lBudget);
        panel.add(tBudget);
        panel.add(lMysql);
        panel.add(tMysql);

        return panel;
    }

    public Component south() {
        JPanel panel = new JPanel(new FlowLayout());

        panel.add(bSubmit);

        return panel;
    }

    public void addListener() {
        ConfigListener configListener = new ConfigListener();
        bSubmit.addActionListener(configListener);
    }
}
