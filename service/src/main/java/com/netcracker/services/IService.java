package com.netcracker.services;

/**
 * Created by Yuksi on 07.12.2016.
 */
public interface IService<T> {
    void save(T item);
    void update(T item);
    void delete(T item);
}
