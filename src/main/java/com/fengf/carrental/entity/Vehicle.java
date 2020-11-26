package com.fengf.carrental.entity;

import java.io.Serializable;

/**
 * (Vehicle)实体类
 *
 * @author zyf
 * @since 2020-10-12 11:40:35
 */
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 728785539937199755L;
    /**
     * 车辆id
     */
    private Integer vehicleId;
    /**
     * 车牌号
     */
    private String vehicleNum;
    /**
     * 车型号
     */
    private String vehicleType;
    /**
     * 乘车人数
     */
    private Integer vehiclePeoplenum;
    /**
     * 租用价格,元/天
     */
    private Double vehiclePrice;
    /**
     * 入库日期
     */
    private Object vehicleDate;
    /**
     * 所属门店
     */
    private String vehicleStore;
    /**
     * 租赁状态，0表示入库，1表示租出
     */
    private Integer vehicleStatu;
    /**
     * 车况,0正常，1破损
     */
    private Integer vehicleSituation;
    /**
     * 车损
     */
    private String vehicleChesun;
    /**
     * 车损说明
     */
    private String vehicleIntroduce;

    public String getVehicleChesun() {
        return vehicleChesun;
    }

    public void setVehicleChesun(String vehicleChesun) {
        this.vehicleChesun = vehicleChesun;
    }

    public String getVehicleIntroduce() {
        return vehicleIntroduce;
    }

    public void setVehicleIntroduce(String vehicleIntroduce) {
        this.vehicleIntroduce = vehicleIntroduce;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getVehiclePeoplenum() {
        return vehiclePeoplenum;
    }

    public void setVehiclePeoplenum(Integer vehiclePeoplenum) {
        this.vehiclePeoplenum = vehiclePeoplenum;
    }

    public Double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(Double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public Object getVehicleDate() {
        return vehicleDate;
    }

    public void setVehicleDate(Object vehicleDate) {
        this.vehicleDate = vehicleDate;
    }

    public String getVehicleStore() {
        return vehicleStore;
    }

    public void setVehicleStore(String vehicleStore) {
        this.vehicleStore = vehicleStore;
    }

    public Integer getVehicleStatu() {
        return vehicleStatu;
    }

    public void setVehicleStatu(Integer vehicleStatu) {
        this.vehicleStatu = vehicleStatu;
    }

    public Integer getVehicleSituation() {
        return vehicleSituation;
    }

    public void setVehicleSituation(Integer vehicleSituation) {
        this.vehicleSituation = vehicleSituation;
    }
}