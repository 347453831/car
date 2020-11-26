package com.fengf.carrental.entity;

import java.io.Serializable;

/**
 * (Stores)实体类
 *
 * @author zyf
 * @since 2020-10-12 11:40:35
 */
public class Stores implements Serializable {
    private static final long serialVersionUID = 733488840901974452L;
    
    private Integer storesId;
    /**
    * 店名
    */
    private String storesName;
    /**
    * 地址
    */
    private String storesAddress;
    /**
    * 电话
    */
    private String storesPhone;
    /**
    * 店长
    */
    private String storesManager;


    public Integer getStoresId() {
        return storesId;
    }

    public void setStoresId(Integer storesId) {
        this.storesId = storesId;
    }

    public String getStoresName() {
        return storesName;
    }

    public void setStoresName(String storesName) {
        this.storesName = storesName;
    }

    public String getStoresAddress() {
        return storesAddress;
    }

    public void setStoresAddress(String storesAddress) {
        this.storesAddress = storesAddress;
    }

    public String getStoresPhone() {
        return storesPhone;
    }

    public void setStoresPhone(String storesPhone) {
        this.storesPhone = storesPhone;
    }

    public String getStoresManager() {
        return storesManager;
    }

    public void setStoresManager(String storesManager) {
        this.storesManager = storesManager;
    }

}