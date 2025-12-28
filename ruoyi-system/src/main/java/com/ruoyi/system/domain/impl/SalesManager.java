package com.ruoyi.system.domain.impl;

import java.math.BigDecimal;
import com.ruoyi.system.domain.Employee;

/**
 * 销售经理类
 * 工资计算公式：基本工资 + 奖金 + 团队销售额 × 提成比例
 *
 * @author ruoyi
 * @date 2025-12-28
 */
public class SalesManager extends Employee {

    /**
     * 计算销售经理工资
     * 工资 = 基本工资 + 奖金 + 团队销售额 × 提成比例
     *
     * @return 计算后的工资
     */
    @Override
    public BigDecimal calculateSalary() {
        BigDecimal base = getBaseSalary() != null ? getBaseSalary() : BigDecimal.ZERO;
        BigDecimal bonus = getBonus() != null ? getBonus() : BigDecimal.ZERO;
        BigDecimal salesAmount = getSalesAmount() != null ? getSalesAmount() : BigDecimal.ZERO;
        BigDecimal commissionRate = getCommissionRate() != null ? getCommissionRate() : BigDecimal.ZERO;

        // 团队销售额 × 提成比例
        BigDecimal commission = salesAmount.multiply(commissionRate);

        // 基本工资 + 奖金 + 提成
        return base.add(bonus).add(commission);
    }
}
