package org.nvtai.production_scheduling_system.controller;

import org.nvtai.production_scheduling_system.entity.Department;
import org.nvtai.production_scheduling_system.entity.Employee;
import org.nvtai.production_scheduling_system.service.DepartmentService;
import org.nvtai.production_scheduling_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;


    // READ - Hiển thị danh sách nhân viên
    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "html/employees/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.findAll()); // Lấy danh sách phòng ban
        return "html/employees/add";
    }


    // CREATE - Xử lý form thêm mới nhân viên
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeService.findById(id);
        List<Department> departments = departmentService.findAll(); // Lấy danh sách phòng ban
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departments); // Truyền danh sách phòng ban vào model
        return "html/employees/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable("id") Long id,
                                 @ModelAttribute("employee") Employee employee,
                                 @RequestParam("departmentId") Long departmentId) {
        Department department = departmentService.findById(departmentId); // Tìm phòng ban theo ID
        employee.setDepartment(department); // Set phòng ban cho nhân viên
        employeeService.update(id, employee);
        return "redirect:/employees";
    }

    // DELETE - Xóa nhân viên
    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            employeeService.delete(id); // Gọi service để xóa nhân viên
            redirectAttributes.addFlashAttribute("success", "Nhân viên đã được xóa thành công!");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "Không thể xóa nhân viên này vì có ràng buộc dữ liệu.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra: " + e.getMessage());
        }
        return "redirect:/employees";
    }

}