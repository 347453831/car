package com.fengf.carrental.service.impl;

import com.fengf.carrental.entity.Stores;
import com.fengf.carrental.dao.StoresDao;
import com.fengf.carrental.service.StoresService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Stores)表服务实现类
 *
 * @author zyf
 * @since 2020-10-12 11:40:35
 */
@Service("storesService")
public class StoresServiceImpl implements StoresService {
    @Resource
    private StoresDao storesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param storesId 主键
     * @return 实例对象
     */
    @Override
    public Stores queryById(Integer storesId) {
        return this.storesDao.queryById(storesId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Stores> queryAllByLimit(int offset, int limit) {
        return this.storesDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param stores 实例对象
     * @return 实例对象
     */
    @Override
    public Stores insert(Stores stores) {
        this.storesDao.insert(stores);
        return stores;
    }

    /**
     * 修改数据
     *
     * @param stores 实例对象
     * @return 实例对象
     */
    @Override
    public Stores update(Stores stores) {
        this.storesDao.update(stores);
        return this.queryById(stores.getStoresId());
    }

    /**
     * 通过主键删除数据
     *
     * @param storesId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer storesId) {
        return this.storesDao.deleteById(storesId) > 0;
    }
}