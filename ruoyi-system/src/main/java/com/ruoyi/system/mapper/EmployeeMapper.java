package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;
import com.ruoyi.system.domain.EmployeeDTO;

/**
 * 员工信息Mapper接口
 * 
 * @author ruoyi
 * @date 2025-12-28
 */
public interface EmployeeMapper 
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
     * 删除员工信息
     * 
     * @param empId 员工信息主键
     * @return 结果
     */
    public int deleteEmployeeByEmpId(String empId);

    /**
     * 批量删除员工信息
     *
     * @param empIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEmployeeByEmpIds(String[] empIds);

    /**
     * 获取员工统计数据
     *
     * @return 统计数据Map
     */
    public Map<String, Object> selectEmployeeStatistics();
}
