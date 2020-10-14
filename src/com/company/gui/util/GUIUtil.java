package com.company.gui.util;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/*
 * GUI的工具类
 */
public class GUIUtil {

    public static String ICONS_DIR = "img";

    /*
    * 检查输入框是否为空，如果为空则弹出提醒
    * @param textField 要检查的输入框
    * @param name 输入框的名称
    * @return 如果为空，false; 否则为true
    * */
    public static boolean checkEmpty(JTextField textField, String name) {
        String text = textField.getText().trim();
        if (text.length() == 0) {
            JOptionPane.showMessageDialog(null, name + "不能为空！");
            textField.grabFocus();

            return false;
        }

        return true;
    }

    /*
    * 检查输入框是否为整数，如果为空或不能解析则弹出提醒
    * @param textField 要检查的输入框
    * @param name 输入框的名称
    * @return 如果为空或者不能解析为整数，false; 否则为true
    * */
    public static boolean checkNumber(JTextField textField, String name) {
        // 是否为空
        if (!checkEmpty(textField, name)) {
            return false;
        }

        // 检查数字
        String text = textField.getText().trim();
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, name + "需要为整数！");
            textField.grabFocus();

            return false;
        }

        return true;
    }

    /*
     * 检查输入框是否为0，如果不能解析或为0则弹出提醒
     * @param textField 要检查的输入框
     * @param name 输入框的名称
     * @return 如果不能解析或为0，false; 否则为true
     * */
    public static boolean checkZero(JTextField textField, String name) {
        // 是否为整数
        if (!checkNumber(textField, name)) {
            return false;
        }

        // 检查是否为0
        String text = textField.getText().trim();
        if (Integer.parseInt(text) == 0) {
            JOptionPane.showMessageDialog(null, name + "不能为0！");

            return false;
        }

        return true;
    }

    /*
    * 给多个组件设置前景色
    * @param color 设置的颜色
    * @param components 要设置的多个组件
    * */
    public static void setColor(Color color, JComponent... components) {
        for (JComponent component : components) {
            component.setForeground(color);
        }
    }

    /*
    * 给按钮设置图标以及提示文字
    * @param button 要设置的按钮
    * @param iconName 图标的文件名
    * @param tip 要显示的提示信息
    * */
    public static void setImageIcon(JButton button, String iconName, String tip) {
        File iconFile = new File(ICONS_DIR, iconName);
        ImageIcon icon = new ImageIcon(iconFile.getAbsolutePath());

        button.setPreferredSize(new Dimension(61, 81));
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setHorizontalTextPosition(JButton.CENTER);

        button.setIcon(icon);
        button.setToolTipText(tip);
        button.setText(tip);
    }

    /*
    * 显示水晶皮肤
    * */
    public static void useLNF() {
        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    *   快速居中显示一个面板
    * */
    public static void showPanel(JPanel panel, double strech) {
//        GUIUtil.useLNF(); // 显示水晶皮肤

        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        CenterPanel cp = new CenterPanel(strech);
        frame.setContentPane(cp);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        cp.show(panel);
    }
}
