package com.fengf.carrental.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (Order)实体类
 *
 * @author zyf
 * @since 2020-10-12 11:40:35
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 871756283735588747L;
    /**
    * 订单id
    */
    private Integer orderId;
    /**
    * 订单号
    */
    private String orderNo;
    /**
    * 该订单的下单者
    */
    private String orderName;
    /**
    * 该订单下单者的电话
    */
    private String orderPhone;
    /**
    * 下单者租用的车辆
    */
    private String orderCar;
    /**
    * 取车时间
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderStarttime;
    /**
    * 还车时间
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderEndtime;
    /**
    * 取车门店
    */
    private String orderStores;
    /**
     * 还车门店
     */
    private String orderReturn;
    /**
    * 单价
    */
    private Double orderPrice;
    /**
    * 总价
    */
    private Double orderSumprice;

    public String getOrderReturn() {
        return orderReturn;
    }

    public void setOrderReturn(String orderReturn) {
        this.orderReturn = orderReturn;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public String getOrderCar() {
        return orderCar;
    }

    public void setOrderCar(String orderCar) {
        this.orderCar = orderCar;
    }

    public Date getOrderStarttime() {
        return orderStarttime;
    }

    public void setOrderStarttime(Date orderStarttime) {
        this.orderStarttime = orderStarttime;
    }

    public Date getOrderEndtime() {
        return orderEndtime;
    }

    public void setOrderEndtime(Date orderEndtime) {
        this.orderEndtime = orderEndtime;
    }

    public String getOrderStores() {
        return orderStores;
    }

    public void setOrderStores(String orderStores) {
        this.orderStores = orderStores;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Double getOrderSumprice() {
        return orderSumprice;
    }

    public void setOrderSumprice(Double orderSumprice) {
        this.orderSumprice = orderSumprice;
    }

}