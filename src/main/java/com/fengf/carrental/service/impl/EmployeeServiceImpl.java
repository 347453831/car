package com.fengf.carrental.service.impl;

import cn.hutool.Hutool;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.fengf.carrental.entity.Employee;
import com.fengf.carrental.dao.EmployeeDao;
import com.fengf.carrental.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Employee)表服务实现类
 *
 * @author zyf
 * @since 2020-10-12 11:40:33
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    @Override
    public Employee queryById(Integer employeeId) {
        return this.employeeDao.queryById(employeeId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Employee> queryAllByLimit(int offset, int limit) {
        return this.employeeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Employee employee) {
        int count = employeeDao.insert(employee);
        if (count > 0) {
            return count;
        }
        return 0;
    }

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Employee employee) {
        int count = employeeDao.update(employee);
        if (count > 0) {
            return count;
        }
        return 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer employeeId) {
        return this.employeeDao.deleteById(employeeId) > 0;
    }

    @Override
    public Employee login(String username, String password) {
        Employee employee = employeeDao.findEmployeeByNameAbdPass(username, password);
        if (ObjectUtil.isNull(employee)) {
            return null;
        }
        return employee;
    }

    @Override
    public List<Employee> queryAllEmp() {
        List<Employee> allEmployee = employeeDao.findAllEmployee();
        if (CollectionUtil.isNotEmpty(allEmployee)) {
            return allEmployee;
        }

        return null;
    }

    @Override
    public List<Employee> queryLikeAllEmp(String information) {

        List<Employee> employeeList = employeeDao.queryLikeAllEmp(information);
        if (CollectionUtil.isNotEmpty(employeeList)) {
            return employeeList;
        }
        return null;
    }

    @Override
    public PageInfo<Employee> pagingQuery(int pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<Employee> allEmployee = employeeDao.findAllEmployee();
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(allEmployee);

        return pageInfo;
    }


}