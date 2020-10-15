package com.company;

import com.company.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GUIUtil.useLNF();

        JFrame frame = new JFrame("一本糊涂账");
        frame.setSize(500, 450);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // 工具栏
        JToolBar toolBar = new JToolBar();
        JButton bOverview = new JButton("消费概览");
        JButton bRecord = new JButton("记一笔");
        JButton bCategory = new JButton("消费分类");
        JButton bMonth = new JButton("月消费报表");
        JButton bSetting = new JButton("设置");
        JButton bBackUp = new JButton("备份");
        JButton bRecover = new JButton("恢复");

        bOverview.setToolTipText("abc");

        toolBar.add(bOverview);
        toolBar.add(bRecord);
        toolBar.add(bCategory);
        toolBar.add(bMonth);
        toolBar.add(bSetting);
        toolBar.add(bBackUp);
        toolBar.add(bRecord);

        frame.add(toolBar, BorderLayout.NORTH);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
