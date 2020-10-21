package com.company.dao;

import com.company.entity.Config;
import com.company.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigDAO implements DAO<Config> {
    @Override
    public void add(Config obj) {
        String sql = "INSERT INTO config VALUE (NULL, ?, ?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, obj.getKey());
            ps.setString(2, obj.getValue());
            ps.execute();

            // 设置id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                obj.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Config obj) {
        String sql = "DELETE FROM config WHERE id=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, obj.getId());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Config obj) {
        String sql = "UPDATE config SET key_=?, value=? WHERE id=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, obj.getKey());
            ps.setString(2, obj.getValue());
            ps.setInt(3, obj.getId());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Config get(int id) {
        String sql = "SELECT * FROM config WHERE id=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String key = rs.getString("key_");
                String value = rs.getString("value");

                Config config = new Config();
                config.setId(id);
                config.setKey(key);
                config.setValue(value);

                return config;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Config> list() {
        return list(0, Integer.MAX_VALUE);
    }

    @Override
    public List<Config> list(int start, int count) {
        List<Config> items = new ArrayList<>();

        String sql = "SELECT * FROM config ORDER BY id DESC limit ?, ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String key = rs.getString("key_");
                String value = rs.getString("value");

                Config config = new Config();
                config.setId(id);
                config.setKey(key);
                config.setValue(value);

                items.add(config);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    @Override
    public int count() {
        try (Connection c = DBUtil.getConnection();
             Statement s = c.createStatement()) {

            String sql = "SELECT COUNT(*) FROM config";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public Config getByKey(String key) {
        String sql = "SELECT * FROM config WHERE key_=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, key);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String value = rs.getString("value");

                Config config = new Config();
                config.setId(id);
                config.setKey(key);
                config.setValue(value);

                return config;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
