package com.fengf.carrental.dao;

import com.fengf.carrental.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Employee)表数据库访问层
 *
 * @author zyf
 * @since 2020-10-12 11:40:32
 */
@Mapper
@Repository
public interface EmployeeDao<deleteByEmployeeName, findEmployeeName, updateByEmployeeIdAfterAndEmployeeBirthday, findOneByEmployeeName, findOneByEmployeeNameAfterAndEmployeePassword, findOneByEmployeePhone, findOneByEmployeePhoneAfterAndEmployeeName, findAllByEmployee, findAllByEmployeeId, findOneByEmployeeNumber> {

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    Employee queryById(Integer employeeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Employee> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param employee 实例对象
     * @return 对象列表
     */
    List<Employee> queryAll(Employee employee);

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 影响行数
     */
    int insert(Employee employee);

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 影响行数
     */
    int update(Employee employee);

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 影响行数
     */
    int deleteById(Integer employeeId);


    Employee findOneByEmployeeName(@Param("employeeName") String employeeName);

    Employee findEmployeeByNameAbdPass(@Param("username") String username, @Param("password") String password);

    Employee findOneByEmployeePhone(@Param("employeePhone") String employeePhone);


    /**
     * 查询所有员工
     */
    List<Employee> findAllEmployee();
    /**
     * 模糊查询所有员工
     */
    List<Employee> queryLikeAllEmp(String information);

    Employee findOneByEmployeeNumber(@Param("employeeNumber")String employeeNumber);




}