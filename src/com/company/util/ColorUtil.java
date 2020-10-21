package com.company.util;

import java.awt.*;

/*
* 管理颜色的工具类
* */
public class ColorUtil {
    public static Color blueColor = Color.decode("#3399FF");
    public static Color grayColor = Color.decode("#999999");
    public static Color backgroundColor = Color.decode("#eeeeee");
    public static Color warningColor = Color.decode("#FF3333");

    /*
    * 根据进度值来获得颜色，进度值越高越红反之越绿
    * @param percentage 进度之（百分制）
    * @return 应该显示的颜色
    * */
    public static Color getByPercentage(int percentage) {
        if (percentage > 100) {
            percentage = 100;
        }

        int r = 51;
        int g = 255;
        int b = 51;

        float rate = percentage / 100f;
        r = (int) ((255 - 51) * rate + 51);
        g = 255 - r + 51;

        Color color = new Color(r, g, b);
        return color;
    }

}
