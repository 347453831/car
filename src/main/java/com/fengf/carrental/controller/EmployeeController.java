package com.fengf.carrental.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.fengf.carrental.entity.Employee;
import com.fengf.carrental.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * (Employee)表控制层
 *
 * @author zyf
 * @since 2020-10-12 11:40:33
 */
@Controller
@RequestMapping("/employee/")
public class EmployeeController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeService employeeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Employee selectOne(Integer id) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("");
        return this.employeeService.queryById(id);
    }


    @PostMapping("addEmployee")
    public String addEmployee(Employee employee, Model model) {
        if (ObjectUtil.isNotNull(employee)) {
            int count = employeeService.insert(employee);
            if (count > 0) {
                model.addAttribute("employee_msg", "添加成功");
                return "find_emp";
            }
            model.addAttribute("employee_msg", "添加失败");
            return "add_emp";
        } else {
            model.addAttribute("employee_msg", "添加请输入正确的信息");
            return "add_emp";
        }

    }

    /**
     * 查询所有员工
     */
  /*  @GetMapping("findAllEmp")
    public String findEmpPage(Model model) {
        List<Employee> employees = employeeService.queryAllEmp();
        if (CollectionUtil.isNotEmpty(employees)) {
            model.addAttribute("employees", employees);
            return "find_emp";
        } else {
            model.addAttribute("msg", "查找数据为空");
            return "find_emp";
        }

    }*/

    /**
     * 模糊查询所有员工
     */
    @PostMapping("findEmpByLike")
    public String findEmpByLike(String information, Model model) {
        List<Employee> employees = employeeService.queryLikeAllEmp(information);
        if (CollectionUtil.isNotEmpty(employees)) {
            model.addAttribute("employees", employees);
            return "find_emp";
        } else {
            model.addAttribute("msg", "查找数据为空");
            return "find_emp";
        }

    }

    /**
     * 查询单个员工页面后进行修改操作
     */
    @GetMapping("selOneById")
    public String selectOneEmpPage(Integer empId, Model model) {
        Employee employee = employeeService.queryById(empId);
        if (ObjectUtil.isNotNull(employee)) {
            model.addAttribute("employee", employee);
            return "myself_mess";
        } else {
            model.addAttribute("msg", "查找数据为空");
            return "find_emp";
        }
    }

    /**
     * 删除单个员工页面
     */
    @GetMapping("delOneEmpPage")
    public String delEmpById(Integer empId) {
        if (employeeService.deleteById(empId)) {
            return "redirect:/employee/findAllEmp";
        } else {
            return "redirect:/employee/findAllEmp";
        }

    }

    /**
     * 修改单个员工页面
     */
    @PostMapping("UpdEmpPage")
    public String dpdEmpById(Employee employee, Model model) {
        int count = employeeService.update(employee);
        if (count > 0) {
            model.addAttribute("msg", "修改成功");
            //todo
            return "redirect:/employee/pagingSel";
        } else {
            model.addAttribute("msg", "修改失败");
            return "myself_mess";
        }
    }

    /**
     * 分页查询所有员工
     */
    @GetMapping("pagingSel")
    public String pagingSel(@RequestParam(defaultValue = "1") int pageNum,
                            Model model) {
        PageInfo<Employee> pageInfo = employeeService.pagingQuery(pageNum);
        if (pageInfo != null) {
            pageInfo.getNextPage();
            List<Employee> employeeList = pageInfo.getList();
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("employees", employeeList);

            return "find_emp";
        } else {
            model.addAttribute("msg", "查找数据为空");
            return "find_emp";
        }

    }
}