package com.company.util;

import javax.swing.*;
import java.awt.*;

/*
*   可以将内部组件居中显示
* */
public class CenterPanel extends JPanel {
    private final double rate; // 拉伸比例
    private final boolean stretch; // 是否拉伸
    private JComponent child; // 内部组件

    public CenterPanel(double rate, boolean stretch) {
        this.rate = rate;
        this.stretch = stretch;

        this.setLayout(null); // 绝对定位控制组件具体位置和大小
    }

    public CenterPanel(double rate) {
        this(rate, true);
    }

    @Override
    public void repaint() {
        if (child != null) {
            Dimension containerSize = this.getSize();
            Dimension childSize = child.getPreferredSize();

            // 设置大小
            if (stretch) {
                int width = (int) (containerSize.getWidth() * rate);
                int height = (int) (containerSize.getHeight() * rate);
                child.setSize(width, height);
            } else {
                childSize.setSize(childSize);
            }

            // 设置位置
            int x = (int) ((containerSize.getWidth() - child.getWidth()) / 2);
            int y = (int) ((containerSize.getHeight() - child.getHeight()) / 2);
            child.setLocation(x, y);
        }

        super.repaint();
    }

    /*
    * 居中显示组件
    * @param component 要显示的组件
    * */
    public void show(JComponent child) {
        this.child = child;

        // 清除Panel内部所有的组件
        Component[] components = this.getComponents();
        for (Component c : components) {
            this.remove(c);
        }

        // 添加新的Component
        this.add(child);

        // 更新UI，自动调用repaint方法
        this.updateUI();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);

        CenterPanel cp  = new CenterPanel(0.5, true);
        cp.setSize(300, 300);
        frame.setContentPane(cp);
        cp.show(new JButton("button"));


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
