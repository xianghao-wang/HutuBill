package com.company.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    // 数据库配置信息
    public static String URL = "127.0.0.1";
    public static int PORT = 3306;
    public static String DATABASE = "hutubill";
    public static String ENCODING = "utf-8";
    public static String USER = "root";
    public static String PASSWORD = "18244682566";

    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", URL, PORT, DATABASE, ENCODING);

        return DriverManager.getConnection(url, USER, PASSWORD);
    }
}
