package com.fengf.carrental.dao;

import com.fengf.carrental.entity.Vehicle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Vehicle)表数据库访问层
 *
 * @author zyf
 * @since 2020-10-12 11:40:35
 */
@Mapper
@Repository
public interface VehicleDao<findOneByVehicleNum, updateByVehicleNum, findAllByVehicleSituation> {

    /**
     * 通过ID查询单条数据
     *
     * @param vehicleId 主键
     * @return 实例对象
     */
    Vehicle queryById(Integer vehicleId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Vehicle> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param vehicle 实例对象
     * @return 对象列表
     */
    List<Vehicle> queryAll(Vehicle vehicle);
/**
 *
 */

    List<Vehicle> queryAllVehicle();

    /**
     * 新增数据
     *
     * @param vehicle 实例对象
     * @return 影响行数
     */
    int insert(Vehicle vehicle);

    /**
     * 修改数据
     *
     * @param vehicle 实例对象
     * @return 影响行数
     */
    int update(Vehicle vehicle);

    /**
     * 通过主键删除数据
     *
     * @param vehicleId 主键
     * @return 影响行数
     */
    int deleteById(Integer vehicleId);

    /**
     * 根据车牌号查看车辆
     * @param vehicleNum
     * @return 实例对象
     */
    Vehicle findOneByVehicleNum(String vehicleNum);

    /**
     * 根据车牌号修改车辆
     * @param vehicleNum
     * @return 实例对象
     */
    int updateByVehicleNum(@Param("updated")Vehicle updated,@Param("vehicleNum")String vehicleNum);


    /**
     *查询所有需要维修的车辆
     */
    List<Vehicle> findAllByVehicleSituation();




}