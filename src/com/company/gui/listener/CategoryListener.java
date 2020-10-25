package com.company.gui.listener;

import com.company.entity.Category;
import com.company.gui.panel.CategoryPanel;
import com.company.service.CategoryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        CategoryPanel p = CategoryPanel.instance;
        JButton source = (JButton) e.getSource();

        if (source == p.bAdd) {
            String name = JOptionPane.showInputDialog(null);
            if (name.length() == 0) {
                JOptionPane.showMessageDialog(p, "分类名称不能为空");
                return;
            }
            new CategoryService().add(name);
        }

        if (source == p.bDelete) {
            Category category = p.getSelectedCategory();
            if (category.getRecordNumber() != 0) {
                JOptionPane.showMessageDialog(p, "本分类下有消费记录，不能删除");
                return;
            }
            if (JOptionPane.showConfirmDialog(p, "确认要删除？") != JOptionPane.OK_OPTION) {
                return;
            }

            new CategoryService().delete(category.getId());
        }

        if (source == p.bEdit) {
            Category category = p.getSelectedCategory();
            String name = JOptionPane.showInputDialog("修改分类名称：" + category.getName());
            if (name.length() == 0) {
                JOptionPane.showMessageDialog(p, "分类名称不能为空");
                return;
            }

            new CategoryService().update(category.getId(), name);
        }

        p.updateData();
    }
}
