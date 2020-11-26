package com.fengf.carrental.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (Employee)实体类
 *
 * @author zyf
 * @since 2020-10-12 11:40:30
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = -43024298337613894L;

    private Integer employeeId;

    private String employeeName;

    private Integer employeeSex;
    /**
     * 出生日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeBirthday;
    /**
     * 入职日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeInductionTime;
    /**
     * 身份证号
     */
    private String employeeNumber;

    private String employeePhone;
    /**
     * 所属门店
     */
    private String employeeStore;

    /**
     * 职位，0表示店员，1表示店长
     */
    private Integer employeePosition;
    /**
     * 员工登录密码
     */
    private String employeePassword;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(Integer employeeSex) {
        this.employeeSex = employeeSex;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }



    public Date getEmployeeInductionTime() {
        return employeeInductionTime;
    }



    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeStore() {
        return employeeStore;
    }

    public void setEmployeeStore(String employeeStore) {
        this.employeeStore = employeeStore;
    }

    public Integer getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(Integer employeePosition) {
        this.employeePosition = employeePosition;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public void setEmployeeInductionTime(Date employeeInductionTime) {
        this.employeeInductionTime = employeeInductionTime;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSex=" + employeeSex +
                ", employeeBirthday=" + employeeBirthday +
                ", employeeInductionTime=" + employeeInductionTime +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", employeePhone='" + employeePhone + '\'' +
                ", employeeStore='" + employeeStore + '\'' +
                ", employeePosition=" + employeePosition +
                ", employeePassword='" + employeePassword + '\'' +
                '}';
    }
}