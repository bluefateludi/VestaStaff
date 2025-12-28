package com.ruoyi.web.controller.system;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.EmployeeDTO;
import com.ruoyi.system.service.IEmployeeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 员工信息Controller
 * 
 * @author ruoyi
 * @date 2025-12-28
 */
@RestController
@RequestMapping("/system/employee")
public class EmployeeController extends BaseController
{
    @Autowired
    private IEmployeeService employeeService;

    /**
     * 查询员工信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:employee:list')")
    @GetMapping("/list")
    public TableDataInfo list(EmployeeDTO employeeDTO)
    {
        startPage();
        List<EmployeeDTO> list = employeeService.selectEmployeeList(employeeDTO);
        return getDataTable(list);
    }

    /**
     * 导出员工信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:employee:export')")
    @Log(title = "员工信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EmployeeDTO employeeDTO)
    {
        List<EmployeeDTO> list = employeeService.selectEmployeeList(employeeDTO);
        ExcelUtil<EmployeeDTO> util = new ExcelUtil<EmployeeDTO>(EmployeeDTO.class);
        util.exportExcel(response, list, "员工信息数据");
    }

    /**
     * 获取员工信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:employee:query')")
    @GetMapping(value = "/{empId}")
    public AjaxResult getInfo(@PathVariable("empId") String empId)
    {
        return success(employeeService.selectEmployeeByEmpId(empId));
    }

    /**
     * 新增员工信息
     */
    @PreAuthorize("@ss.hasPermi('system:employee:add')")
    @Log(title = "员工信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EmployeeDTO employeeDTO)
    {
        return toAjax(employeeService.insertEmployee(employeeDTO));
    }

    /**
     * 修改员工信息
     */
    @PreAuthorize("@ss.hasPermi('system:employee:edit')")
    @Log(title = "员工信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EmployeeDTO employeeDTO)
    {
        return toAjax(employeeService.updateEmployee(employeeDTO));
    }

    /**
     * 删除员工信息
     */
    @PreAuthorize("@ss.hasPermi('system:employee:remove')")
    @Log(title = "员工信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{empIds}")
    public AjaxResult remove(@PathVariable String[] empIds)
    {
        return toAjax(employeeService.deleteEmployeeByEmpIds(empIds));
    }

    /**
     * 计算员工工资 - 多态方法调用
     */
    @PreAuthorize("@ss.hasPermi('system:employee:query')")
    @GetMapping("/salary/{empId}")
    public AjaxResult calculateSalary(@PathVariable("empId") String empId)
    {
        BigDecimal salary = employeeService.calculateEmployeeSalary(empId);
        return success(salary);
    }

    /**
     * 批量计算所有员工工资
     */
    @PreAuthorize("@ss.hasPermi('system:employee:query')")
    @GetMapping("/salaries")
    public AjaxResult calculateAllSalaries()
    {
        Map<String, BigDecimal> salaries = employeeService.calculateAllSalaries();
        return success(salaries);
    }
}
