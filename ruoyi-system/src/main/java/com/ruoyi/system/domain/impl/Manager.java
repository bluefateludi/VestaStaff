package com.ruoyi.system.domain.impl;

import java.math.BigDecimal;
import com.ruoyi.system.domain.Employee;

/**
 * 经理类
 * 工资计算公式：基本工资 + 奖金
 *
 * @author ruoyi
 * @date 2025-12-28
 */
public class Manager extends Employee {

    /**
     * 计算经理工资
     * 工资 = 基本工资 + 奖金
     *
     * @return 计算后的工资
     */
    @Override
    public BigDecimal calculateSalary() {
        BigDecimal base = getBaseSalary() != null ? getBaseSalary() : BigDecimal.ZERO;
        BigDecimal bonus = getBonus() != null ? getBonus() : BigDecimal.ZERO;

        return base.add(bonus);
    }
}
