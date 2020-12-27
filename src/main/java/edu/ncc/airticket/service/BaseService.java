package edu.ncc.airticket.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.ncc.airticket.dao.BaseDao;
import edu.ncc.airticket.model.BaseModel;
import edu.ncc.airticket.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseService<T extends BaseModel, D extends BaseDao<T>> {
    /**
     * Spring4的泛型依赖注入，可以让我们只在父类当中进行注入，就可以了
     */
    @Autowired
    protected D dao;

    /**
     * 插入或者更新数据
     *
     * @param t
     */
    public void save(T t) {
        //如果id为空或者空字符串，我们认为是insert
        //如果没有id信息就插入，如果就更新
        if (t.getId() == null || "".equals(t.getId())) {
            dao.insert(t);
        } else {
            dao.update(t);
        }
    }

    //根据对象删除
    public void delete(T t) {
        dao.delete(t);
    }

    //根据id删除
    public void delete(Integer id) {
        dao.delete(id);
    }


    public void pass(Integer id) {
        dao.pass(id);
    }

    public void maintain(T t) {
        dao.maintain(t);
    }

    public void maintain(Integer id) {
        dao.maintain(id);
    }

    //根据对象查找
    public T find(T condition) {
        return dao.find(condition);
    }

    //根据id查找
    public T findById(Integer id) {
        return dao.findById(id);
    }

    //查询多条记录
    public List<T> findList(T condition) {
        return dao.findList(condition);
    }


    //查找所有
    public List<T> findAll() {
        return dao.findAll();
    }


    /**
     * 分页查询数据
     * @param condition 查询条件
     * @param pageNum  查第几页
     * @param pageSize 每一页有多少条
     * @return
     */
    public PageInfo<T> page(T condition,Integer pageNum,Integer pageSize){
        return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()-> dao.findList(condition));
    }


}
