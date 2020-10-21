package com.company.startup;

import com.company.gui.frame.MainFrame;
import com.company.gui.panel.MainPanel;
import com.company.gui.panel.SpendPanel;

import javax.swing.*;

public class Bootstrap {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            }
        });

    }
}
