package com.company.service;

import com.company.dao.CategoryDAO;
import com.company.dao.RecordDAO;
import com.company.entity.Category;

import java.util.Collections;
import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO = new CategoryDAO();
    private RecordDAO recordDAO = new RecordDAO();

    public List<Category> list() {
        List<Category> categories = categoryDAO.list();

        // 获得recordNumber
        for (Category category : categories) {
            int recordNumber = recordDAO.list(category.getId()).size();
            category.setRecordNumber(recordNumber);
        }

        // 根据recordNumber排序
        Collections.sort(categories, (c1, c2) -> c2.getRecordNumber() - c1.getRecordNumber());

        return categories;
    }

    public void add(String name) {
        Category category = new Category();
        category.setName(name);
        categoryDAO.add(category);
    }

    public void update(int id, String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);

        categoryDAO.update(category);
    }

    public void delete(int id) {
        categoryDAO.delete(id);
    }
}
