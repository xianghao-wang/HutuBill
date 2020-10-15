package com.company.gui.panel;

import com.company.util.ColorUtil;
import com.company.util.GUIUtil;

import javax.swing.*;

public class BackupPanel extends JPanel {
    public static BackupPanel instance = new BackupPanel();

    JButton bBackup = new JButton("备份");

    public BackupPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bBackup);
        this.add(bBackup);
    }
}
