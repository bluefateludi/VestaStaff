package com.ruoyi.system.domain.impl;

import java.math.BigDecimal;
import com.ruoyi.system.domain.Employee;

/**
 * 销售人员类
 * 工资计算公式：基本工资 + 销售额 × 提成比例
 *
 * @author ruoyi
 * @date 2025-12-28
 */
public class Sales extends Employee {

    /**
     * 计算销售人员工资
     * 工资 = 基本工资 + 销售额 × 提成比例
     *
     * @return 计算后的工资
     */
    @Override
    public BigDecimal calculateSalary() {
        BigDecimal base = getBaseSalary() != null ? getBaseSalary() : BigDecimal.ZERO;
        BigDecimal salesAmount = getSalesAmount() != null ? getSalesAmount() : BigDecimal.ZERO;
        BigDecimal commissionRate = getCommissionRate() != null ? getCommissionRate() : BigDecimal.ZERO;

        // 销售额 × 提成比例
        BigDecimal commission = salesAmount.multiply(commissionRate);

        return base.add(commission);
    }
}
