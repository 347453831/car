package com.fengf.carrental.dao;

import com.fengf.carrental.entity.Members;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Members)表数据库访问层
 *
 * @author zyf
 * @since 2020-10-12 11:40:34
 */
@Mapper
@Repository
public interface MembersDao<findAllByMembersName, findMembersPhone> {

    /**
     * 通过ID查询单条数据
     *
     * @param membersId 主键
     * @return 实例对象
     */
    Members queryById(Integer membersId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Members> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param members 实例对象
     * @return 对象列表
     */
    List<Members> queryAll(Members members);

    /**
     * 新增数据
     *
     * @param members 实例对象
     * @return 影响行数
     */
    int insert(Members members);

    /**
     * 修改数据
     *
     * @param members 实例对象
     * @return 影响行数
     */
    int update(Members members);

    /**
     * 通过主键删除数据
     *
     * @param membersId 主键
     * @return 影响行数
     */
    int deleteById(Integer membersId);

    List<Members> findAllByMembersName(@Param("membersName") String membersName);


}