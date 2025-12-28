package com.ruoyi.system.domain;

import com.ruoyi.system.domain.impl.Manager;
import com.ruoyi.system.domain.impl.Sales;
import com.ruoyi.system.domain.impl.SalesManager;
import com.ruoyi.system.domain.impl.Technician;

/**
 * 员工工厂类
 * 根据员工类型创建对应的子类实例
 * 应用工厂模式，体现面向对象设计原则
 *
 * @author ruoyi
 * @date 2025-12-28
 */
public class EmployeeFactory {

    /**
     * 根据员工类型创建对应的子类实例
     *
     * @param type 员工类型: MANAGER, TECHNICIAN, SALES, SALES_MANAGER
     * @return 对应的员工子类实例
     * @throws IllegalArgumentException 如果员工类型未知
     */
    public static Employee createEmployee(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("员工类型不能为空");
        }

        switch (type.trim()) {
            case "MANAGER":
                return new Manager();
            case "TECHNICIAN":
                return new Technician();
            case "SALES":
                return new Sales();
            case "SALES_MANAGER":
                return new SalesManager();
            default:
                throw new IllegalArgumentException("未知的员工类型: " + type);
        }
    }
}
