package com.montini.teamsports.dao;

import java.util.List;

public interface CrudRepository<T, ID> {
    Integer add(T t);

    void delete(ID id);

    T update(T t);

    T findOne(Integer id);

    List<T> findAll();
}