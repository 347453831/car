package com.fengf.carrental.dao;

import com.fengf.carrental.entity.Stores;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Stores)表数据库访问层
 *
 * @author zyf
 * @since 2020-10-12 11:40:35
 */
@Mapper
@Repository
public interface StoresDao {

    /**
     * 通过ID查询单条数据
     *
     * @param storesId 主键
     * @return 实例对象
     */
    Stores queryById(Integer storesId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Stores> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param stores 实例对象
     * @return 对象列表
     */
    List<Stores> queryAll(Stores stores);

    /**
     * 新增数据
     *
     * @param stores 实例对象
     * @return 影响行数
     */
    int insert(Stores stores);

    /**
     * 修改数据
     *
     * @param stores 实例对象
     * @return 影响行数
     */
    int update(Stores stores);

    /**
     * 通过主键删除数据
     *
     * @param storesId 主键
     * @return 影响行数
     */
    int deleteById(Integer storesId);

}