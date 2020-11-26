package com.fengf.carrental.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (Members)实体类
 *
 * @author zyf
 * @since 2020-10-12 11:40:34
 */
public class Members implements Serializable {
    private static final long serialVersionUID = -84613994367577257L;
    /**
    * 会员的id
    */
    private Integer membersId;
    /**
    * 会员的姓名
    */
    private String membersName;
    /**
    * 会员的性别
    */
    private Integer membersSex;
    /**
    * 会员的出生日期
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date membersBirthday;
    /**
    * 会员的身份证号
    */
    private String membersNumber;
    /**
    * 会员的家庭住址
    */
    private String membersAddress;
    /**
    * 会员的手机号
    */
    private String membersPhone;


    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }

    public String getMembersName() {
        return membersName;
    }

    public void setMembersName(String membersName) {
        this.membersName = membersName;
    }

    public Integer getMembersSex() {
        return membersSex;
    }

    public void setMembersSex(Integer membersSex) {
        this.membersSex = membersSex;
    }

    public Date getMembersBirthday() {
        return membersBirthday;
    }

    public void setMembersBirthday(Date membersBirthday) {
        this.membersBirthday = membersBirthday;
    }

    public String getMembersNumber() {
        return membersNumber;
    }

    public void setMembersNumber(String membersNumber) {
        this.membersNumber = membersNumber;
    }

    public String getMembersAddress() {
        return membersAddress;
    }

    public void setMembersAddress(String membersAddress) {
        this.membersAddress = membersAddress;
    }

    public String getMembersPhone() {
        return membersPhone;
    }

    public void setMembersPhone(String membersPhone) {
        this.membersPhone = membersPhone;
    }




}