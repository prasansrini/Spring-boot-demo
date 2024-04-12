package com.employee.management.system.repository;

import com.employee.management.system.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee finEmployee(int employeeId);

    Employee save(Employee employee);

    void deleteEmployeeById(int employeeId);
}
