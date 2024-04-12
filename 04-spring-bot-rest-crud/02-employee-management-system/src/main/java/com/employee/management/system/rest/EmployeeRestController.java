package com.employee.management.system.rest;

import com.employee.management.system.entity.Employee;
import com.employee.management.system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService mEmployeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        mEmployeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return mEmployeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {

        Employee employee = mEmployeeService.finEmployee(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee with employeeID:" + employeeId + " not found!");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);

        return mEmployeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return mEmployeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        if (mEmployeeService.finEmployee(employeeId) == null) {
            throw new RuntimeException("Employee not found!");
        }

        mEmployeeService.deleteEmployeeById(employeeId);

        return "Deleted employee ID: " + employeeId;
    }
}
