package com.employee.management.system.service;

import com.employee.management.system.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee finEmployee(int employeeId);

    Employee save(Employee employee);

    void deleteEmployeeById(int employeeId);
}
