package com.ruoyi.system.domain.impl;

import java.math.BigDecimal;
import com.ruoyi.system.domain.Employee;

/**
 * 技术人员类
 * 工资计算公式：基本工资 + 工作小时数 × 时薪
 *
 * @author ruoyi
 * @date 2025-12-28
 */
public class Technician extends Employee {

    /**
     * 计算技术人员工资
     * 工资 = 基本工资 + 工作小时数 × 时薪
     *
     * @return 计算后的工资
     */
    @Override
    public BigDecimal calculateSalary() {
        BigDecimal base = getBaseSalary() != null ? getBaseSalary() : BigDecimal.ZERO;
        BigDecimal hours = getWorkHours() != null ? getWorkHours() : BigDecimal.ZERO;
        BigDecimal rate = getHourlyRate() != null ? getHourlyRate() : BigDecimal.ZERO;

        // 工作小时数 × 时薪
        BigDecimal workSalary = hours.multiply(rate);

        return base.add(workSalary);
    }
}
