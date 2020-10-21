package com.company.dao;

import java.util.List;

public interface DAO<T> {
    public void add(T obj);
    public void delete(T obj);
    public void update(T obj);
    public T get(int id);
    public List<T> list();
    public List<T> list(int start, int count);
    public int count();
}
