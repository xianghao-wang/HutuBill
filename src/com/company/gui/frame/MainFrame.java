package com.company.gui.frame;

import com.company.gui.panel.MainPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static MainFrame instance = new MainFrame();

    public MainFrame() throws HeadlessException {
        this.setTitle("一本糊涂账");
        this.setSize(500, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(MainPanel.instance);
    }
}
