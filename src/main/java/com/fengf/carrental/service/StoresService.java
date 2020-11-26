package com.fengf.carrental.service;

import com.fengf.carrental.entity.Stores;
import java.util.List;

/**
 * (Stores)表服务接口
 *
 * @author zyf
 * @since 2020-10-12 11:40:35
 */
public interface StoresService {

    /**
     * 通过ID查询单条数据
     *
     * @param storesId 主键
     * @return 实例对象
     */
    Stores queryById(Integer storesId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Stores> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param stores 实例对象
     * @return 实例对象
     */
    Stores insert(Stores stores);

    /**
     * 修改数据
     *
     * @param stores 实例对象
     * @return 实例对象
     */
    Stores update(Stores stores);

    /**
     * 通过主键删除数据
     *
     * @param storesId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer storesId);

}