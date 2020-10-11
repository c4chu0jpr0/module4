package com.codegym.service;

public interface IService<T> {
    Iterable<T> findAll();

    T findById(Integer id);

    T update(T model);

    T save(T model);

    void remove(Integer id);
}
