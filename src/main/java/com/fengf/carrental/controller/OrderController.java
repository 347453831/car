package com.fengf.carrental.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.fengf.carrental.entity.Order;
import com.fengf.carrental.entity.Vehicle;
import com.fengf.carrental.service.OrderService;
import com.fengf.carrental.service.VehicleService;
import com.fengf.carrental.util.OrderUtil;
import com.fengf.carrental.util.TimeUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Order)表控制层
 *
 * @author zyf
 * @since 2020-10-12 11:40:35
 */
@Controller
@RequestMapping("/order/")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    @Resource
    private VehicleService vehicleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Order selectOne(Integer id) {
        return this.orderService.queryById(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 多条数据
     */
    @GetMapping("selectAllOrder")
    public String selectAllOrder(Model model) {
        List<Order> orders = orderService.queryAllOrder();
        if (CollectionUtil.isNotEmpty(orders)) {
            model.addAttribute("orders", orders);
            return "order_pay";
        } else {
            model.addAttribute("msg", "目前没有订单");
            return "order_pay";
        }
    }

    @PostMapping("addOrder")
    public String addOrder(Order order, Model model) throws ParseException {
        if (ObjectUtil.isNotNull(order)) {
            Vehicle vehicle = vehicleService.findVueByNum(order.getOrderCar());
            order.setOrderPrice(vehicle.getVehiclePrice());
            long startTime = order.getOrderStarttime().getTime();
            long endTime = order.getOrderEndtime().getTime();
            int day = (int) ((endTime - startTime) / (1000 * 60 * 60 * 24));
            order.setOrderSumprice(vehicle.getVehiclePrice() * day);
            order.setOrderNo(OrderUtil.getOrderIdByUUId());
            Order orderCount = orderService.insert(order);
            if (ObjectUtil.isNotNull(orderCount)) {

                return "redirect:/order/selectAllOrder";
            } else {
                return "redirect:/vehicle/borrow_carPage";
            }
        }
        return "redirect:/vehicle/borrow_carPage";
    }


    /**
     * 根据车辆订单号查询车辆信息
     */
    @GetMapping("selectOrderByNo")
    public String selectOrderByNo(String orderNo, Model model) {
        Order order = orderService.selOrderByNo(orderNo);
        if (ObjectUtil.isNotNull(order)) {
            model.addAttribute("orderDetails", order);
            return "return_car";
        } else {
            model.addAttribute("msg", "该订单不存在");
            return "return_car";
        }
    }

    /**
     * 还车操作
     */
    @PostMapping("returnCar")
    public String returnCar(Model model, Order order, String carStatus) {
        Order order1 = orderService.selOrderByNo(order.getOrderNo());
        Vehicle vehicle = vehicleService.findVueByNum(order.getOrderCar());
        Integer intStatus = Integer.valueOf(carStatus);
        vehicle.setVehicleStatu(intStatus);
        Vehicle vehicle1 = vehicleService.update(vehicle);
        if (ObjectUtil.isNotNull(vehicle1)) {
            model.addAttribute("msg", "设置车辆状态失败");
            return "redirect:/order/selectAllOrder";
        }
        order1.setOrderReturn(order.getOrderReturn());
        Order count = orderService.update(order1);
        if (ObjectUtil.isNotNull(count)) {
            model.addAttribute("order", order);

            return "order_success";
        } else {
            return "redirect:/order/selectAllOrder";
        }


    }

    /**
     * 查看所有已归还车辆的订单
     */
    @GetMapping("selAllSucOrder")
    public String selAllSucOrder(Model model) {
        List<Order> orderList = orderService.selAllOrderByReturn();
        if (CollectionUtil.isNotEmpty(orderList)) {
            model.addAttribute("orderList", orderList);
            return "order_success";
        } else {
            model.addAttribute("msg", "目前暂无完成的订单");
            return "order_success";
        }
    }

    /**
     * 多条件查询订单
     */
    @PostMapping("selOrderByManyconditions")
    public String selOrderByManyconditions(Model model, String username, String startTime, String endTime, String phone) {
        List<Order> orderList = orderService.selOrderByManyconditions(username, startTime, endTime, phone);
        if (CollectionUtil.isNotEmpty(orderList)) {

            model.addAttribute("orders", orderList);
            return "order_pay";
        } else {
            model.addAttribute("msg", "查找数据为空");
            return "order_pay";
        }
    }
}