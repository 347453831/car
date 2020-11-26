package com.fengf.carrental.service;

import com.fengf.carrental.entity.Vehicle;

import java.util.List;

/**
 * (Vehicle)表服务接口
 *
 * @author zyf
 * @since 2020-10-12 11:40:35
 */
public interface VehicleService {

    /**
     * 通过ID查询单条数据
     *
     * @param vehicleId 主键
     * @return 实例对象
     */
    Vehicle queryById(Integer vehicleId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Vehicle> queryAllByLimit(int offset, int limit);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<Vehicle> queryAllVehicle();

    /**
     * 新增数据
     *
     * @param vehicle 实例对象
     * @return 1或0
     */
    int insert(Vehicle vehicle);

    /**
     * 修改数据
     *
     * @param vehicle 实例对象
     * @return 实例对象
     */
    Vehicle update(Vehicle vehicle);

    /**
     * 通过主键删除数据
     *
     * @param vehicleId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer vehicleId);

    /**
     * 根据车牌号查找车辆
     */
    Vehicle findVueByNum(String vehicleNum);

    /**
     * 根据车牌号更新车辆
     */
    int updVueByNum(Vehicle updated,String vehicleNum);

    /**
     *查询所有需要维修的车辆
     */
    List<Vehicle> findAllByVehicleSituation();


}