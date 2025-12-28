package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工信息对象 employee
 * 抽象基类，体现继承和多态
 *
 * @author ruoyi
 * @date 2025-12-28
 */
public abstract class Employee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工编号 */
    private String empId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String empName;

    /** 性别:0男 1女 */
    @Excel(name = "性别:0男 1女")
    private String gender;

    /** 部门ID */
    @Excel(name = "部门ID")
    private Long deptId;

    /** 级别 */
    @Excel(name = "级别")
    private String level;

    /** 员工类型: MANAGER-经理, TECHNICIAN-技术人员, SALES-销售人员, SALES_MANAGER-销售经理 */
    @Excel(name = "员工类型: MANAGER-经理, TECHNICIAN-技术人员, SALES-销售人员, SALES_MANAGER-销售经理")
    private String employeeType;

    /** 基本工资 */
    @Excel(name = "基本工资")
    private BigDecimal baseSalary;

    /** 奖金(经理专用) */
    @Excel(name = "奖金(经理专用)")
    private BigDecimal bonus;

    /** 工作小时数(技术人员专用) */
    @Excel(name = "工作小时数(技术人员专用)")
    private BigDecimal workHours;

    /** 时薪(技术人员专用) */
    @Excel(name = "时薪(技术人员专用)")
    private BigDecimal hourlyRate;

    /** 销售额(销售人员专用) */
    @Excel(name = "销售额(销售人员专用)")
    private BigDecimal salesAmount;

    /** 提成比例(销售人员专用) */
    @Excel(name = "提成比例(销售人员专用)")
    private BigDecimal commissionRate;

    /**
     * 抽象方法：计算员工工资
     * 子类必须实现此方法，体现多态
     * @return 计算后的工资
     */
    public abstract BigDecimal calculateSalary();

    public void setEmpId(String empId) 
    {
        this.empId = empId;
    }

    public String getEmpId() 
    {
        return empId;
    }

    public void setEmpName(String empName) 
    {
        this.empName = empName;
    }

    public String getEmpName() 
    {
        return empName;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    public void setLevel(String level) 
    {
        this.level = level;
    }

    public String getLevel() 
    {
        return level;
    }

    public void setEmployeeType(String employeeType) 
    {
        this.employeeType = employeeType;
    }

    public String getEmployeeType() 
    {
        return employeeType;
    }

    public void setBaseSalary(BigDecimal baseSalary) 
    {
        this.baseSalary = baseSalary;
    }

    public BigDecimal getBaseSalary() 
    {
        return baseSalary;
    }

    public void setBonus(BigDecimal bonus) 
    {
        this.bonus = bonus;
    }

    public BigDecimal getBonus() 
    {
        return bonus;
    }

    public void setWorkHours(BigDecimal workHours) 
    {
        this.workHours = workHours;
    }

    public BigDecimal getWorkHours() 
    {
        return workHours;
    }

    public void setHourlyRate(BigDecimal hourlyRate) 
    {
        this.hourlyRate = hourlyRate;
    }

    public BigDecimal getHourlyRate() 
    {
        return hourlyRate;
    }

    public void setSalesAmount(BigDecimal salesAmount) 
    {
        this.salesAmount = salesAmount;
    }

    public BigDecimal getSalesAmount() 
    {
        return salesAmount;
    }

    public void setCommissionRate(BigDecimal commissionRate) 
    {
        this.commissionRate = commissionRate;
    }

    public BigDecimal getCommissionRate() 
    {
        return commissionRate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("empId", getEmpId())
            .append("empName", getEmpName())
            .append("gender", getGender())
            .append("deptId", getDeptId())
            .append("level", getLevel())
            .append("employeeType", getEmployeeType())
            .append("baseSalary", getBaseSalary())
            .append("bonus", getBonus())
            .append("workHours", getWorkHours())
            .append("hourlyRate", getHourlyRate())
            .append("salesAmount", getSalesAmount())
            .append("commissionRate", getCommissionRate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
