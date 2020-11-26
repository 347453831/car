package com.fengf.carrental;

import cn.hutool.core.collection.CollectionUtil;
import com.fengf.carrental.dao.EmployeeDao;
import com.fengf.carrental.dao.VehicleDao;
import com.fengf.carrental.entity.Employee;
import com.fengf.carrental.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class CarrentalApplicationTests {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    EmployeeService employeeService;
    @Resource
    VehicleDao vehicleDao;

    @Test
    void login() {
        Employee employee = employeeDao.findEmployeeByNameAbdPass("小明", "123");
        System.out.println(employee);
    }

    @Test
    void pagingQuery() {
        PageInfo<Employee> pageInfo = employeeService.pagingQuery(1);
        System.out.println(pageInfo);
    }

    @Test
    void testTimeVehicle() {
        List allByVehicleSituation = vehicleDao.findAllByVehicleSituation();
        System.out.println(allByVehicleSituation+"ioioioioi");
    }
}
