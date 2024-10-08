package org.nvtai.production_scheduling_system.service;

import org.nvtai.production_scheduling_system.entity.Employee;
import org.nvtai.production_scheduling_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll(); // Trả về List<Employee> mà không cần ép kiểu
    }

    // Thêm mới nhân viên
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    // Tìm nhân viên theo id
    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
    }

    // Cập nhật thông tin nhân viên
    public void update(Long id, Employee updatedEmployee) {
        Employee existingEmployee = findById(id);
        existingEmployee.setEname(updatedEmployee.getEname());
        existingEmployee.setPhoneNumber(updatedEmployee.getPhoneNumber());
        existingEmployee.setAddress(updatedEmployee.getAddress());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());

        employeeRepository.save(existingEmployee);
    }

    // Xóa nhân viên
    public void delete(Long id) {
        Employee employee = findById(id);
        employeeRepository.delete(employee);
    }
}