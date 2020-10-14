package com.company.gui.panel;

import com.company.gui.util.ColorUtil;
import com.company.gui.util.GUIUtil;

import javax.swing.*;

public class RecoverPanel extends JPanel {
    public static RecoverPanel instance = new RecoverPanel();

    JButton bRecover = new JButton("恢复");

    public RecoverPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bRecover);
        this.add(bRecover);
    }
}
