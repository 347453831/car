package com.fengf.carrental.service;

import com.fengf.carrental.entity.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (Employee)表服务接口
 *
 * @author zyf
 * @since 2020-10-12 11:40:32
 */
public interface EmployeeService {

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    Employee queryById(Integer employeeId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Employee> queryAllByLimit(int offset, int limit);


    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    int insert(Employee employee);

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    int update(Employee employee);

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer employeeId);

    Employee login(String username, String password);

    /**
     * 查询所有员工
     */
    List<Employee> queryAllEmp();

    /**
     * 模糊查询所有员工
     */
    List<Employee> queryLikeAllEmp(String information);

    /**
     * 分页查询所有员工
     */
    PageInfo<Employee> pagingQuery(int pageNum);
}