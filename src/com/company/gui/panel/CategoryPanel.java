package com.company.gui.panel;

import com.company.gui.model.CategoryTableModel;
import com.company.util.ColorUtil;
import com.company.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class CategoryPanel extends JPanel {

    public static CategoryPanel instance = new CategoryPanel();

    public CategoryTableModel categoryTableModel = new CategoryTableModel();

    // 控件
    public JTable table = new JTable(categoryTableModel);
    public JButton bAdd = new JButton("新增");
    public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");

    public CategoryPanel() {
        this.setLayout(new BorderLayout());

        // 设置颜色
        GUIUtil.setColor(ColorUtil.blueColor, bAdd, bEdit, bDelete);

        this.add(center(), BorderLayout.CENTER);
        this.add(south(), BorderLayout.SOUTH);
    }

    public Component center() {
        return new JScrollPane(table);
    }

    public Component south() {
        JPanel panel = new JPanel();

        panel.add(bAdd);
        panel.add(bEdit);
        panel.add(bDelete);

        return panel;
    }
}
