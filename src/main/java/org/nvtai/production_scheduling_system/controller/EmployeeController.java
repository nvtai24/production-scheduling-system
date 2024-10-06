package org.nvtai.production_scheduling_system.controller;

import org.nvtai.production_scheduling_system.entity.Employee;
import org.nvtai.production_scheduling_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // READ - Hiển thị danh sách nhân viên
    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "html/employees/list";
    }

    // CREATE - Hiển thị form thêm mới nhân viên
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "html/employees/add";
    }

    // CREATE - Xử lý form thêm mới nhân viên
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees";
    }

    // UPDATE - Hiển thị form cập nhật thông tin nhân viên
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        model.addAttribute("employee", employee);
        return "html/employees/edit";
    }

    // UPDATE - Xử lý form cập nhật thông tin nhân viên
    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @ModelAttribute("employee") Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees";
    }

    // DELETE - Xóa nhân viên
    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        employeeRepository.delete(employee);
        return "redirect:/employees";
    }
}