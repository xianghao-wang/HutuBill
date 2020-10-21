package com.company.gui.panel;

import com.company.util.ChartUtil;

import javax.swing.*;
import java.awt.*;

public class ReportPanel extends JPanel {
    public static ReportPanel instance = new ReportPanel();

    public JLabel chart = new JLabel();

    public ReportPanel() {
        this.setLayout(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon(ChartUtil.getImage(400, 300));
        chart.setIcon(imageIcon);

        this.add(chart, BorderLayout.CENTER);
    }
}
