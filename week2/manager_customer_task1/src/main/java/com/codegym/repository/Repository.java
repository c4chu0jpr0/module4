package com.codegym.repository;

import java.util.List;

public interface Repository <T> {
    List<T> findALl();
    T findById(Long id);
    void save(T model);
    void remove(Long id);
}
