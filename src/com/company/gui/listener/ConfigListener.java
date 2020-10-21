package com.company.gui.listener;

import com.company.gui.panel.ConfigPanel;
import com.company.service.ConfigService;
import com.company.util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ConfigListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ConfigPanel p = ConfigPanel.instance;

        if (!GUIUtil.checkNumber(p.tBudget, "本月预算")) {
            return;
        }

        if (!GUIUtil.checkEmpty(p.tMysql, "MySQL路径不能为空")) {
            return;
        }

        String mysqlPath = p.tMysql.getText();
        File commandFile = new File(mysqlPath, "bin/mysql.exe");
        if (!commandFile.exists()) {
            JOptionPane.showMessageDialog(null, "MySQL路径不正确");
            p.tMysql.grabFocus();

            return;
        }

        // 访问Config服务设置Config
        ConfigService service = new ConfigService();
        service.update(ConfigService.budget, p.tBudget.getText());
        service.update(ConfigService.mysqlPath, p.tMysql.getText());
        JOptionPane.showMessageDialog(null , "设置修改成功");
    }
}
