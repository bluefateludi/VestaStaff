package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 员工信息DTO对象
 * 用于接收前端参数和数据库映射，解决 Employee 抽象类无法实例化的问题
 *
 * @author ruoyi
 * @date 2025-12-28
 */
@Data
public class EmployeeDTO
{
    /** 员工编号 */
    private String empId;

    /** 姓名 */
    private String empName;

    /** 性别:0男 1女 */
    private String gender;

    /** 部门ID */
    private Long deptId;

    /** 级别 */
    private String level;

    /** 员工类型: MANAGER-经理, TECHNICIAN-技术人员, SALES-销售人员, SALES_MANAGER-销售经理 */
    private String employeeType;

    /** 基本工资 */
    private BigDecimal baseSalary;

    /** 奖金(经理专用) */
    private BigDecimal bonus;

    /** 工作小时数(技术人员专用) */
    private BigDecimal workHours;

    /** 时薪(技术人员专用) */
    private BigDecimal hourlyRate;

    /** 销售额(销售人员专用) */
    private BigDecimal salesAmount;

    /** 提成比例(销售人员专用) */
    private BigDecimal commissionRate;

    /** 搜索条件：起始日期 */
    private String params;

    /** 创建者 */
    private String createBy;

    /** 创建时间 */
    private Date createTime;

    /** 更新者 */
    private String updateBy;

    /** 更新时间 */
    private Date updateTime;

    /** 备注 */
    private String remark;
}
