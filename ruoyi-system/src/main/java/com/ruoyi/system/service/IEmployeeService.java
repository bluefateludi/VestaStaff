package com.ruoyi.system.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.ruoyi.system.domain.EmployeeDTO;

/**
 * 员工信息Service接口
 * 
 * @author ruoyi
 * @date 2025-12-28
 */
public interface IEmployeeService 
{
    /**
     * 查询员工信息
     *
     * @param empId 员工信息主键
     * @return 员工信息
     */
    public EmployeeDTO selectEmployeeByEmpId(String empId);

    /**
     * 查询员工信息列表
     *
     * @param employee 员工信息
     * @return 员工信息集合
     */
    public List<EmployeeDTO> selectEmployeeList(EmployeeDTO employee);

    /**
     * 新增员工信息
     *
     * @param employee 员工信息
     * @return 结果
     */
    public int insertEmployee(EmployeeDTO employee);

    /**
     * 修改员工信息
     *
     * @param employee 员工信息
     * @return 结果
     */
    public int updateEmployee(EmployeeDTO employee);

    /**
     * 批量删除员工信息
     * 
     * @param empIds 需要删除的员工信息主键集合
     * @return 结果
     */
    public int deleteEmployeeByEmpIds(String[] empIds);

    /**
     * 删除员工信息信息
     *
     * @param empId 员工信息主键
     * @return 结果
     */
    public int deleteEmployeeByEmpId(String empId);

    /**
     * 计算员工工资 - 调用多态方法
     *
     * @param empId 员工编号
     * @return 计算后的工资
     */
    public BigDecimal calculateEmployeeSalary(String empId);

    /**
     * 批量计算所有员工工资
     *
     * @return 员工编号与工资的映射 Map
     */
    public Map<String, BigDecimal> calculateAllSalaries();

    /**
     * 获取员工统计数据
     *
     * @return 统计数据Map
     */
    public Map<String, Object> getEmployeeStatistics();
}
