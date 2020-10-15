package com.company.dao;

import com.company.entity.Category;
import com.company.entity.Record;
import com.company.util.DBUtil;
import com.company.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordDAO implements DAO<Record> {

    @Override
    public void add(Record obj) {
        String sql = "INSERT INTO record VALUE (NULL, ?, ?, ?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            int spend = obj.getSpend();
            int category_id = obj.getCategory_id();
            java.sql.Date date = DateUtil.util2sql(obj.getDate());

            ps.setInt(1, spend);
            ps.setInt(2, category_id);
            ps.setDate(3, date);

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                obj.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Record obj) {
        String sql = "INSERT INTO record VALUE (NULL, ?, ?, ?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            int spend = obj.getSpend();
            int category_id = obj.getCategory_id();
            java.sql.Date date = DateUtil.util2sql(obj.getDate());

            ps.setInt(1, spend);
            ps.setInt(2, category_id);
            ps.setDate(3, date);

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                obj.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Record obj) {
        String sql = "UPDATE record SET spend=?, category_id=?, comment=?, date=? WHERE id=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            int id = obj.getId();
            int spend = obj.getSpend();
            int category_id = obj.getCategory_id();
            String comment = obj.getComment();
            java.sql.Date date = DateUtil.util2sql(obj.getDate());

            ps.setInt(1, spend);
            ps.setInt(2, category_id);
            ps.setString(3, comment);
            ps.setDate(3, date);
            ps.setInt(4, id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Record get(int id) {
        Record record = null;

        String sql = "SELECT * FROM record WHERE id=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int spend = rs.getInt("spend");
                int category_id = rs.getInt("category_id");
                String comment = rs.getString("comment");
                Date date = rs.getDate("date");

                record = new Record();

                record.setId(id);
                record.setSpend(spend);
                record.setCategory_id(category_id);
                record.setComment(comment);
                record.setDate(date);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return record;
    }

    @Override
    public List<Record> list() {
        return list(0, Integer.MAX_VALUE);
    }

    @Override
    public List<Record> list(int start, int count) {
        List<Record> items = new ArrayList<>();

        String sql = "SELECT * FROM record ORDER BY id DESC LIMIT ?, ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int spend = rs.getInt("spend");
                int category_id = rs.getInt("category_id");
                String comment = rs.getString("comment");
                Date date = rs.getDate("date");

                Record record = new Record();

                record.setId(id);
                record.setSpend(spend);
                record.setCategory_id(category_id);
                record.setComment(comment);
                record.setDate(date);

                items.add(record);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    @Override
    public int count() {
        int total = 0;

        String sql = "SELECT COUNT(*) FROM record";
        try (Connection c = DBUtil.getConnection();
             Statement s = c.createStatement()) {

            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                total = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }
}
