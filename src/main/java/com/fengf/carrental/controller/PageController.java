package com.fengf.carrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zyf
 * @date 2020/10/15 17:23
 */
@Controller
@RequestMapping("/page/")
public class PageController {
    /**
     * main页面
     */
    @GetMapping("mainPage")
    public String mainPage() {
        return "main";
    }


    /**
     * 已完成订单
     */
    @GetMapping("order_successPage")
    public String order_successPage() {

        return "order_success";
    }



    /**
     * 添加车辆
     */
    @GetMapping("add_carPage")
    public String add_car() {

        return "add_car";
    }


    /**
     * 添加门店页面
     */
    @GetMapping("addStoresPage")
    public String addStoresPage() {

        return "add_store";
    }

    /**
     * 查询门店页面
     */
    @GetMapping("find_storePage")
    public String find_storePage() {

        return "find_store";
    }

    /**
     * 添加员工页面
     */
    @GetMapping("addEmpPage")
    public String addEmpPage() {

        return "add_emp";
    }


    /**
     * 个人资料页面
     */
    @GetMapping("myself_messPage")
    public String myself_messPage() {
        return "myself_mess";
    }

    /**
     * 修改密码页面
     */
    @GetMapping("update_pwdPage")
    public String update_pwd() {
        return "update_pwd";
    }


}
