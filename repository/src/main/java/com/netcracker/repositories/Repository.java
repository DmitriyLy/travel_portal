package com.netcracker.repositories;

import com.netcracker.specifications.Specification;

import java.util.List;

/**
 * Created by Yuksi on 25.11.2016.
 */
public interface Repository<T> {
    void add(T item);
    void update(T item);
    void remove(T item);
    List<T> query(Specification specification);
}
