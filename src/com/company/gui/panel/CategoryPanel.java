package com.company.gui.panel;

import com.company.entity.Category;
import com.company.gui.listener.CategoryListener;
import com.company.gui.model.CategoryTableModel;
import com.company.service.CategoryService;
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

        addListener();
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

    public Category getSelectedCategory() {
        int index = this.table.getSelectedRow();
        Category category = categoryTableModel.categories.get(index);

        return category;
    }

    public void updateData() {
        categoryTableModel.categories = new CategoryService().list();
        table.updateUI();
        table.getSelectionModel().setSelectionInterval(0, 0);

        if (0 == categoryTableModel.categories.size()) {
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
        } else {
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
        }
    }

    public void addListener() {
        CategoryListener categoryListener = new CategoryListener();
        bAdd.addActionListener(categoryListener);
        bEdit.addActionListener(categoryListener);
        bDelete.addActionListener(categoryListener);
    }
}
