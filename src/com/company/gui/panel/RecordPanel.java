package com.company.gui.panel;

import com.company.gui.model.CategoryComboBoxModel;
import com.company.gui.util.ColorUtil;
import com.company.gui.util.GUIUtil;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class RecordPanel extends JPanel {
    public static RecordPanel instance = new RecordPanel();

    public ComboBoxModel<String> comboBoxModel = new CategoryComboBoxModel(); // 选择框的数据模型

    // 控件
    // 标签
    JLabel lSpend = new JLabel("花费(¥)");
    JLabel lCategory = new JLabel("分类");
    JLabel lComment = new JLabel("备注");
    JLabel lDate = new JLabel("日期");

    // 输入
    public JTextField tSpend = new JTextField();
    public JComboBox<String> comboCategory = new JComboBox<>(comboBoxModel);
    public JTextField tComment = new JTextField();
    public JXDatePicker datePicker = new JXDatePicker(new Date());

    // 提交按钮
    JButton bAdd = new JButton("记一笔");

    public RecordPanel() {
        this.setLayout(new BorderLayout());

        // 标签颜色
        GUIUtil.setColor(ColorUtil.grayColor, lSpend, lCategory, lComment, lDate);
        GUIUtil.setColor(ColorUtil.blueColor, bAdd);

        this.add(north(), BorderLayout.NORTH);
        this.add(center(), BorderLayout.SOUTH);
    }

    public Component center() {
        JPanel panel = new JPanel();
        panel.add(bAdd);
        return panel;
    }

    public Component north() {
        int gap = 40;

        JPanel panel = new JPanel(new GridLayout(4, 2, gap, gap));

        panel.add(lSpend);
        panel.add(tSpend);
        panel.add(lCategory);
        panel.add(comboCategory);
        panel.add(lComment);
        panel.add(tComment);
        panel.add(lDate);
        panel.add(datePicker);

        return panel;
    }

}
