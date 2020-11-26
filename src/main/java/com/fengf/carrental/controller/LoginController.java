package com.fengf.carrental.controller;

import cn.hutool.core.util.ObjectUtil;
import com.fengf.carrental.common.Const;
import com.fengf.carrental.entity.Employee;
import com.fengf.carrental.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author zyf
 * @date 2020/10/12 16:52
 */
@Controller
public class LoginController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 跳转到登录页面
     */
    @GetMapping("/")
    public String homePage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session) {
        Employee employee = employeeService.login(username, password);
        if (ObjectUtil.isNull(employee)) {
            session.setAttribute("msg", "用户名或密码错误");
            return "login";
        } else {
            session.setAttribute(Const.CURRENT_USER, employee.getEmployeeName());
            return "index";
        }
    }
}
