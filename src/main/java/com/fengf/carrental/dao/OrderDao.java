package com.fengf.carrental.dao;

import com.fengf.carrental.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * (Order)表数据库访问层
 *
 * @author zyf
 * @since 2020-10-12 11:40:35
 */
@Mapper
@Repository
public interface OrderDao<findOrderByOrderNo, deleteByOrderName, findOneByOrderNo, findOneByOrderPrice> {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    Order queryById(Integer orderId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Order> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<Order> queryAll();

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 影响行数
     */
    int insert(Order order);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 影响行数
     */
    int update(Order order);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 影响行数
     */
    int deleteById(Integer orderId);

    Order findOneByOrderNo(String orderNo);

    /**
     * 查看所有已经归还车辆的订单
     */
    List<Order> selAllOrderByReturn();

    List<Order> selOrderByManyconditions(@Param("username") String username, @Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("phone") String phone);

}