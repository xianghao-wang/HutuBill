package com.company.dao;

import com.company.entity.Category;
import com.company.entity.Record;
import com.company.util.DBUtil;
import com.company.util.DateUtil;

import java.sql.*;
import java.util.*;
import java.util.Date;

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

    public List<Record> list(Date start, Date end) {
        List<Record> items = new ArrayList<>();

        String sql = "SELECT * FROM record WHERE date>=? AND date<=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setDate(1, DateUtil.util2sql(start));
            ps.setDate(2, DateUtil.util2sql(end));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int spend = rs.getInt("spend");
                int category_id = rs.getInt("category_id");
                String comment = rs.getString("comment");
                java.sql.Date date = rs.getDate("date");

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

    public List<Record> list(Date day) {
        // 找到一天开始和结束的日期
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date start = calendar.getTime();

        calendar.add(Calendar.DATE, 1);
        calendar.add(Calendar.MILLISECOND, -1);
        Date end = calendar.getTime();

        return list(start, end);
    }

    public List<Record> listToday() {
        return list(new Date());
    }

    public List<Record> listThisMonth() {
        // 月初和月末
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date start = calendar.getTime();

        return null;

    }
}
