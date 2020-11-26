package com.fengf.carrental.service;

import com.fengf.carrental.entity.Members;
import java.util.List;

/**
 * (Members)表服务接口
 *
 * @author zyf
 * @since 2020-10-12 11:40:34
 */
public interface MembersService {

    /**
     * 通过ID查询单条数据
     *
     * @param membersId 主键
     * @return 实例对象
     */
    Members queryById(Integer membersId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Members> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param members 实例对象
     * @return 实例对象
     */
    int insert(Members members);

    /**
     * 修改数据
     *
     * @param members 实例对象
     * @return 实例对象
     */
    Members update(Members members);

    /**
     * 通过主键删除数据
     *
     * @param membersId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer membersId);

}