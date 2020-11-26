package com.fengf.carrental.service.impl;

import com.fengf.carrental.entity.Members;
import com.fengf.carrental.dao.MembersDao;
import com.fengf.carrental.service.MembersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Members)表服务实现类
 *
 * @author zyf
 * @since 2020-10-12 11:40:34
 */
@Service("membersService")
public class MembersServiceImpl implements MembersService {
    @Resource
    private MembersDao membersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param membersId 主键
     * @return 实例对象
     */
    @Override
    public Members queryById(Integer membersId) {
        return this.membersDao.queryById(membersId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Members> queryAllByLimit(int offset, int limit) {
        return this.membersDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param members 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Members members) {
        int count = membersDao.insert(members);
        if (count > 0) {
            return count;
        }
        return 0;

    }

    /**
     * 修改数据
     *
     * @param members 实例对象
     * @return 实例对象
     */
    @Override
    public Members update(Members members) {
        this.membersDao.update(members);
        return this.queryById(members.getMembersId());
    }

    /**
     * 通过主键删除数据
     *
     * @param membersId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer membersId) {
        return this.membersDao.deleteById(membersId) > 0;
    }
}