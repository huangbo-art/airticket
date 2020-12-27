package edu.ncc.airticket.dao;

import edu.ncc.airticket.model.BaseModel;

import java.util.List;

public interface BaseDao <T extends BaseModel>{

    void insert(T t);

    void update(T t);

    void delete(T t);

    void delete(Integer id);

    //查询单条数据
    T find(T condition);

    //根据Id查询
    T findById(Integer id);

    //查询多条记录
    List<T> findList(T condition);

    //查询所有
    List<T> findAll();

    void pass(Integer id);

    void maintain(T t);

    void maintain(Integer id);

}
