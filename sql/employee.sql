-- ----------------------------
-- 员工管理系统表结构
-- 基于 RuoYi-Vue 框架
-- ----------------------------

-- ----------------------------
-- 员工基本信息表
-- ----------------------------

CREATE DATABASE IF NOT EXISTS `VestaStaff` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
    `emp_id` VARCHAR(20) NOT NULL COMMENT '员工编号',
    `emp_name` VARCHAR(50) NOT NULL COMMENT '姓名',
    `gender` CHAR(1) DEFAULT '0' COMMENT '性别:0男 1女',
    `dept_id` BIGINT DEFAULT NULL COMMENT '部门ID',
    `level` VARCHAR(20) DEFAULT NULL COMMENT '级别',
    `employee_type` VARCHAR(30) NOT NULL COMMENT '员工类型: MANAGER-经理, TECHNICIAN-技术人员, SALES-销售人员, SALES_MANAGER-销售经理',
    `base_salary` DECIMAL(10,2) DEFAULT 0.00 COMMENT '基本工资',

-- 经理特有字段
`bonus` DECIMAL(10, 2) DEFAULT NULL COMMENT '奖金(经理专用)',

-- 技术人员特有字段
`work_hours` DECIMAL(8, 2) DEFAULT NULL COMMENT '工作小时数(技术人员专用)',
`hourly_rate` DECIMAL(8, 2) DEFAULT NULL COMMENT '时薪(技术人员专用)',

-- 销售人员特有字段
`sales_amount` DECIMAL(12, 2) DEFAULT NULL COMMENT '销售额(销售人员专用)',
`commission_rate` DECIMAL(5, 4) DEFAULT NULL COMMENT '提成比例(销售人员专用)',

-- 审计字段

`create_by` VARCHAR(64) DEFAULT '' COMMENT '创建者',
    `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
    `update_by` VARCHAR(64) DEFAULT '' COMMENT '更新者',
    `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
    `remark` VARCHAR(500) DEFAULT NULL COMMENT '备注',

    PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='员工信息表';

-- ----------------------------
-- 初始化测试数据
-- ----------------------------
INSERT INTO
    `employee`
VALUES (
        'EMP001',
        '张三',
        '0',
        103,
        'P1',
        'MANAGER',
        15000.00,
        5000.00,
        NULL,
        NULL,
        NULL,
        NULL,
        'admin',
        NOW(),
        '',
        NULL,
        '总经理'
    ),
    (
        'EMP002',
        '李四',
        '1',
        103,
        'P2',
        'MANAGER',
        12000.00,
        3000.00,
        NULL,
        NULL,
        NULL,
        NULL,
        'admin',
        NOW(),
        '',
        NULL,
        '部门经理'
    ),
    (
        'EMP003',
        '王五',
        '0',
        103,
        'T1',
        'TECHNICIAN',
        8000.00,
        NULL,
        160.00,
        100.00,
        NULL,
        NULL,
        'admin',
        NOW(),
        '',
        NULL,
        '高级工程师'
    ),
    (
        'EMP004',
        '赵六',
        '0',
        103,
        'T2',
        'TECHNICIAN',
        6000.00,
        NULL,
        150.00,
        80.00,
        NULL,
        NULL,
        'admin',
        NOW(),
        '',
        NULL,
        '中级工程师'
    ),
    (
        'EMP005',
        '钱七',
        '1',
        103,
        'T3',
        'TECHNICIAN',
        5000.00,
        NULL,
        140.00,
        60.00,
        NULL,
        NULL,
        'admin',
        NOW(),
        '',
        NULL,
        '初级工程师'
    ),
    (
        'EMP006',
        '孙八',
        '1',
        103,
        'S1',
        'SALES',
        4000.00,
        NULL,
        NULL,
        NULL,
        150000.00,
        0.0500,
        'admin',
        NOW(),
        '',
        NULL,
        '销售专员'
    ),
    (
        'EMP007',
        '周九',
        '0',
        103,
        'S1',
        'SALES',
        4000.00,
        NULL,
        NULL,
        NULL,
        200000.00,
        0.0500,
        'admin',
        NOW(),
        '',
        NULL,
        '销售专员'
    ),
    (
        'EMP008',
        '吴十',
        '1',
        103,
        'S1',
        'SALES',
        4000.00,
        NULL,
        NULL,
        NULL,
        180000.00,
        0.0500,
        'admin',
        NOW(),
        '',
        NULL,
        '销售专员'
    ),
    (
        'EMP009',
        '郑十一',
        '0',
        103,
        'SM1',
        'SALES_MANAGER',
        10000.00,
        4000.00,
        NULL,
        NULL,
        500000.00,
        0.0200,
        'admin',
        NOW(),
        '',
        NULL,
        '销售经理'
    ),
    (
        'EMP010',
        '王小明',
        '0',
        103,
        'T2',
        'TECHNICIAN',
        6500.00,
        NULL,
        155.00,
        85.00,
        NULL,
        NULL,
        'admin',
        NOW(),
        '',
        NULL,
        '软件工程师'
    );

-- ----------------------------
-- 查询验证
-- ----------------------------
-- SELECT * FROM employee;
-- SELECT employee_type, COUNT(*) as count FROM employee GROUP BY employee_type;
-- SELECT gender, COUNT(*) as count FROM employee GROUP BY gender;