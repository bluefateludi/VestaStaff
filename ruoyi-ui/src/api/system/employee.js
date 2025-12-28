import request from '@/utils/request'

// 查询员工信息列表
export function listEmployee(query) {
  return request({
    url: '/system/employee/list',
    method: 'get',
    params: query
  })
}

// 查询员工信息详细
export function getEmployee(empId) {
  return request({
    url: '/system/employee/' + empId,
    method: 'get'
  })
}

// 新增员工信息
export function addEmployee(data) {
  return request({
    url: '/system/employee',
    method: 'post',
    data: data
  })
}

// 修改员工信息
export function updateEmployee(data) {
  return request({
    url: '/system/employee',
    method: 'put',
    data: data
  })
}

// 删除员工信息
export function delEmployee(empId) {
  return request({
    url: '/system/employee/' + empId,
    method: 'delete'
  })
}

// 计算单个员工工资
export function calculateSalary(empId) {
  return request({
    url: '/system/employee/salary/' + empId,
    method: 'get'
  })
}

// 批量计算所有员工工资
export function calculateAllSalaries() {
  return request({
    url: '/system/employee/salaries',
    method: 'get'
  })
}

// 获取员工统计数据
export function getStatistics() {
  return request({
    url: '/system/employee/statistics',
    method: 'get'
  })
}
