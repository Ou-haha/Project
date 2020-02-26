package com.ou.mapper;

public interface BaseMapper<T> {

    int insert(T entity);

    T getById(Integer id);

}
