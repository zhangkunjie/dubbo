package com.backend.dao;

import com.common.model.PageModel;

import java.util.List;

/**
 * Created by kunjie.zhang on 2018/5/23.
 */
public interface BaseDao<T extends java.io.Serializable, PK extends java.io.Serializable> {
    /**
     * 保存实体
     *
     * @param entity
     */
    void insert(T entity);

    /*
    * 批量插入
    * @param entities
    * */
    void insertBatch(List<T> entities);

    /**
     * 删除实体
     *
     * @param entity
     */
    void delete(T entity);

    /**
     * 更新实体
     *
     * @param entity
     */
    void update(T entity);

    /**
     * 按id查询
     *
     * @param id
     * @return
     */
    T getById(T t);

    /**
     * 按id查询
     *
     * @param ids
     * @return
     */
    List<T> getByIds(PK[] ids);

    /**
     * 查询所有
     *
     * @return
     */
    List<T> findAll(T entity);

    /*
    *查询分页
    * @return
    */
    List<T> findPage(T entity);
}
