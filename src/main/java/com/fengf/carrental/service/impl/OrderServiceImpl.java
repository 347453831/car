package com.fengf.carrental.service.impl;

import cn.hutool.Hutool;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.fengf.carrental.entity.Order;
import com.fengf.carrental.dao.OrderDao;
import com.fengf.carrental.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Order)表服务实现类
 *
 * @author zyf
 * @since 2020-10-12 11:40:35
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(Integer orderId) {
        return this.orderDao.queryById(orderId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Order> queryAllByLimit(int offset, int limit) {
        return this.orderDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Order> queryAllOrder() {
        List list = orderDao.queryAll();
        return list;
    }

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order insert(Order order) {
        this.orderDao.insert(order);
        return order;
    }

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderDao.update(order);
        return this.queryById(order.getOrderId());
    }

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer orderId) {
        return this.orderDao.deleteById(orderId) > 0;
    }

    @Override
    public Order selOrderByNo(String orderNo) {
        return orderDao.findOneByOrderNo(orderNo);

    }

    @Override
    public List<Order> selAllOrderByReturn() {

        return orderDao.selAllOrderByReturn();
    }

@Override
    public List<Order> selOrderByManyconditions(String username, String startTime, String endTime, String phone) {
    DateTime startTime1 = DateUtil.parse(startTime);
    DateTime endTime1 = DateUtil.parse(endTime);
    List list = orderDao.selOrderByManyconditions(username, startTime1, endTime1, phone);
    return list;
    }
}