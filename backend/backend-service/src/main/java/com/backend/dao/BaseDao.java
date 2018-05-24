package com.backend.dao;

import java.util.List;

/**
 * Created by kunjie.zhang on 2018/5/23.
 */
public interface BaseDao<T extends java.io.Serializable, PK extends java.io.Serializable> {
    public List<T> findAll(T t);
}
