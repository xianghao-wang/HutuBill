package com.company.gui.listener;

import com.company.gui.panel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolbarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel p = MainPanel.instance;
        JButton source = (JButton) e.getSource();
        JPanel panelToShow = null;

        if (source == p.bSpend) panelToShow = SpendPanel.instance;
        if (source == p.bRecord) panelToShow = RecordPanel.instance;
        if (source == p.bCategory) panelToShow = CategoryPanel.instance;
        if (source == p.bReport) panelToShow = ReportPanel.instance;
        if (source == p.bConfig) panelToShow = ConfigPanel.instance;
        if (source == p.bBackup) panelToShow = BackupPanel.instance;
        if (source == p.bRecover) panelToShow = RecoverPanel.instance;

        // 显示指定的panel
        p.workingPanel.show(panelToShow);
    }
}
