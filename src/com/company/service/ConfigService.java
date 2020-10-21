package com.company.service;

import com.company.dao.ConfigDAO;
import com.company.entity.Config;

public class ConfigService {
    private static ConfigDAO dao = new ConfigDAO();
    public static String budget = "budget";
    public static String mysqlPath = "mysqlPath";
    private static String defaultBudget = "500";

    public static void init() {
        init(budget, defaultBudget);
        init(mysqlPath, "");
    }

    private static void init(String key, String value) {
        Config config = dao.getByKey(key);

        // 若不存在则创建一个
        if (config == null) {
            Config newConfig = new Config();
            newConfig.setKey(key);
            newConfig.setValue(value);
            dao.add(newConfig);
        }
    }

    public String get(String key) {
        Config config = dao.getByKey(key);

        return config.getValue();
    }

    public void update(String key, String value) {
        Config config = dao.getByKey(key);

        if (config == null) {
            init(key, value);
            return;
        }

        config.setValue(value);
        dao.update(config);
    }

    public int getIntBudget() {
        return Integer.parseInt(get(budget));
    }



}
