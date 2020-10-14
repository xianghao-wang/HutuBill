package com.company.tests;

import com.company.gui.util.CircleProgressBar;
import com.company.gui.util.ColorUtil;
import com.company.gui.util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestCircleProgressBar {
    public static void main(String[] args) {
        JPanel panel = new JPanel(new BorderLayout());
        CircleProgressBar circleProgressBar = new CircleProgressBar();
        JButton startButton = new JButton("开始");
        panel.add(circleProgressBar, BorderLayout.CENTER);
        panel.add(startButton, BorderLayout.SOUTH);

        circleProgressBar.setProgress(0);

        startButton.setEnabled(true);

        GUIUtil.showPanel(panel, 1);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Object, Object> swingWorker = new SwingWorker<Object, Object>() {
                    @Override
                    protected Object doInBackground() throws Exception {
                        startButton.setEnabled(false);
                        circleProgressBar.setProgress(0);

                        for (int i = 0; i < 100; i ++) {
                            circleProgressBar.setProgress(circleProgressBar.getProgress() + 1);
                            circleProgressBar.setForegroundColor(ColorUtil.getByPercentage(circleProgressBar.getProgress()));
                            Thread.sleep(50);
                        }

                        startButton.setEnabled(true);

                        return null;
                    }
                };
                swingWorker.execute();
            }
        });
    }
}
