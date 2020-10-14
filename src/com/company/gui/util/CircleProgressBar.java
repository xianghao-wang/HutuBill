package com.company.gui.util;

import javax.swing.*;
import java.awt.*;

/*
* 环形进度条
* */
public class CircleProgressBar extends JPanel {
    private static int MARGIN = 25;

    private int minimumProgress;
    private int maximumProgress;
    private int progress = 0;
    private Color foregroundColor;
    private Color backgroundColor;

    public CircleProgressBar() {
        minimumProgress = 0;
        maximumProgress = 100;

        foregroundColor = ColorUtil.getByPercentage(progress);
        backgroundColor = ColorUtil.blueColor;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 开启抗锯齿

        int x, y;
        int width, height;
        int fontSize = 0;

        if (this.getWidth() >= this.getHeight()) {
            width = this.getHeight() - 2 * MARGIN;
            height = this.getHeight() - 2 * MARGIN;

            x = (this.getWidth() - width) / 2;
            y = MARGIN;

            fontSize = getWidth() / 8;
        } else {
            width = this.getWidth() - 2 * MARGIN;
            height = this.getWidth() - 2 * MARGIN;

            x = MARGIN;
            y = (this.getHeight() - height) / 2;

            fontSize = getHeight() / 8;
        }


        // 画背景部分圆弧
        graphics2D.setStroke(new BasicStroke(20.0f));
        graphics2D.setColor(backgroundColor);
        graphics2D.drawArc(x, y, width, height, 0, 360);

        // 画前景部分圆弧
        int end = (int) (360 * ((float) progress / maximumProgress));
        graphics2D.setColor(foregroundColor);
        graphics2D.drawArc(x, y, width, height, 90, -(int) (360f * progress / (maximumProgress - minimumProgress)));

        // 显示文字
        graphics2D.setFont(new Font("黑体", Font.BOLD, fontSize));
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        int digitalWidth = fontMetrics.stringWidth(getProgressText());
        int digitalAscent = fontMetrics.getAscent();
        graphics2D.setColor(foregroundColor);

        // 文字位置
        int xFont = (this.getWidth() - digitalWidth) / 2;
        int yFont = (this.getHeight() - digitalAscent) / 2 + digitalAscent;

        graphics2D.drawString(getProgressText(), xFont, yFont);
    }

    /*
    * 设置进度并更新UI
    * @param progress 进度
    * */
    public void setProgress(int progress) {

        if (progress >= minimumProgress && progress <= maximumProgress) {
            this.progress = progress;
        }

        this.repaint();
    }

    /*
     * 获得进度
     * @return 进度
     * */
    public int getProgress() {
        return progress;
    }

    /*
    * 设置前景色并更新UI
    * @param color 前景色
    * */
    public void setForegroundColor(Color color) {
        this.foregroundColor = color;

        this.repaint();
    }

    /*
    * 设置背景色并更新UI
    * @param color 背景色
    * */
    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;

        this.repaint();
    }

    /*
    *  获得应该显示的文字
    * @return 应该显示的文字
    * */
    public String getProgressText() {
        return progress + "%";
    }

}