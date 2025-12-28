package com.ruoyi.system.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EmployeeMapper;
import com.ruoyi.system.domain.Employee;
import com.ruoyi.system.domain.EmployeeDTO;
import com.ruoyi.system.domain.EmployeeFactory;
import com.ruoyi.system.service.IEmployeeService;

/**
 * 员工信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-28
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService 
{
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查询员工信息
     *
     * @param empId 员工信息主键
     * @return 员工信息
     */
    @Override
    public EmployeeDTO selectEmployeeByEmpId(String empId)
    {
        return employeeMapper.selectEmployeeByEmpId(empId);
    }

    /**
     * 查询员工信息列表
     *
     * @param employee 员工信息
     * @return 员工信息
     */
    @Override
    public List<EmployeeDTO> selectEmployeeList(EmployeeDTO employee)
    {
        return employeeMapper.selectEmployeeList(employee);
    }

    /**
     * 新增员工信息
     *
     * @param employee 员工信息
     * @return 结果
     */
    @Override
    public int insertEmployee(EmployeeDTO employee)
    {
        employee.setCreateTime(DateUtils.getNowDate());
        return employeeMapper.insertEmployee(employee);
    }

    /**
     * 修改员工信息
     *
     * @param employee 员工信息
     * @return 结果
     */
    @Override
    public int updateEmployee(EmployeeDTO employee)
    {
        employee.setUpdateTime(DateUtils.getNowDate());
        return employeeMapper.updateEmployee(employee);
    }

    /**
     * 批量删除员工信息
     * 
     * @param empIds 需要删除的员工信息主键
     * @return 结果
     */
    @Override
    public int deleteEmployeeByEmpIds(String[] empIds)
    {
        return employeeMapper.deleteEmployeeByEmpIds(empIds);
    }

    /**
     * 删除员工信息信息
     *
     * @param empId 员工信息主键
     * @return 结果
     */
    @Override
    public int deleteEmployeeByEmpId(String empId)
    {
        return employeeMapper.deleteEmployeeByEmpId(empId);
    }

    /**
     * 计算员工工资 - 调用多态方法
     * 核心逻辑：根据员工类型创建对应子类，调用多态的 calculateSalary 方法
     *
     * @param empId 员工编号
     * @return 计算后的工资
     */
    @Override
    public BigDecimal calculateEmployeeSalary(String empId)
    {
        // 1. 从数据库查询员工信息（现在返回的是 EmployeeDTO）
        EmployeeDTO empDto = employeeMapper.selectEmployeeByEmpId(empId);

        if (empDto == null)
        {
            throw new RuntimeException("员工不存在: " + empId);
        }

        // 2. 根据类型创建对应的子类对象（工厂模式）
        Employee concreteEmp = EmployeeFactory.createEmployee(empDto.getEmployeeType());

        // 3. 复制属性到子类对象
        BeanUtils.copyProperties(empDto, concreteEmp);

        // 4. 调用多态方法计算工资（核心！）
        // 同一个方法调用，不同的子类有不同的实现
        return concreteEmp.calculateSalary();
    }

    /**
     * 批量计算所有员工工资
     *
     * @return 员工编号与工资的映射 Map
     */
    @Override
    public Map<String, BigDecimal> calculateAllSalaries()
    {
        List<EmployeeDTO> employeeDtos = employeeMapper.selectEmployeeList(null);
        Map<String, BigDecimal> salaryMap = new HashMap<>();

        for (EmployeeDTO empDto : employeeDtos)
        {
            BigDecimal salary = calculateEmployeeSalary(empDto.getEmpId());
            salaryMap.put(empDto.getEmpId(), salary);
        }

        return salaryMap;
    }
}
