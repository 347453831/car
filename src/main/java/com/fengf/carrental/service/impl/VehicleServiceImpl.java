package com.fengf.carrental.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import com.fengf.carrental.entity.Vehicle;
import com.fengf.carrental.dao.VehicleDao;
import com.fengf.carrental.service.VehicleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Vehicle)表服务实现类
 *
 * @author zyf
 * @since 2020-10-12 11:40:35
 */
@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {
    @Resource
    private VehicleDao vehicleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param vehicleId 主键
     * @return 实例对象
     */
    @Override
    public Vehicle queryById(Integer vehicleId) {
        return this.vehicleDao.queryById(vehicleId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Vehicle> queryAllByLimit(int offset, int limit) {
        return this.vehicleDao.queryAllByLimit(offset, limit);
    }


    /* *
     * 查看所有车辆
     */
    @Override
    public List<Vehicle> queryAllVehicle() {
        List<Vehicle> vehicles = vehicleDao.queryAllVehicle();
        if (CollectionUtil.isNotEmpty(vehicles)) {
            return vehicles;
        }
        return null;
    }

    /**
     * 新增数据
     *
     * @param vehicle 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Vehicle vehicle) {
        return vehicleDao.insert(vehicle);

    }

    /**
     * 修改数据
     *
     * @param vehicle 实例对象
     * @return 实例对象
     */
    @Override
    public Vehicle update(Vehicle vehicle) {
        this.vehicleDao.update(vehicle);
        return this.queryById(vehicle.getVehicleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param vehicleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer vehicleId) {
        return this.vehicleDao.deleteById(vehicleId) > 0;
    }

    @Override
    public Vehicle findVueByNum(String vehicleNum) {
        Vehicle oneByVehicleNum = vehicleDao.findOneByVehicleNum(vehicleNum);
        // TODO: 2020/10/22
       // Assert.notNull(oneByVehicleNum);
        if (ObjectUtil.isNotNull(oneByVehicleNum)) {
            return oneByVehicleNum;
        }
        return null;
    }

    @Override
    public int updVueByNum(Vehicle updated,String vehicleNum) {
        int count = vehicleDao.updateByVehicleNum(updated, vehicleNum);
        if (count>0){
            return count;
        }
        return 0;
    }

    @Override
    public List<Vehicle> findAllByVehicleSituation() {
        return vehicleDao.findAllByVehicleSituation();
    }
}