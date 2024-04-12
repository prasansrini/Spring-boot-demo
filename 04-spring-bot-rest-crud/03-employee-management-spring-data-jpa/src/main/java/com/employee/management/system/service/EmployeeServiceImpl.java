package com.employee.management.system.service;

import com.employee.management.system.entity.Employee;
import com.employee.management.system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository mEmployeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        mEmployeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return mEmployeeRepo.findAll();
    }

    @Override
    public Employee finEmployee(int employeeId) {
        Optional<Employee> result = mEmployeeRepo.findById(employeeId);

        Employee employee;

        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Employee not found!");
        }

        return employee;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return mEmployeeRepo.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int employeeId) {
        mEmployeeRepo.deleteById(employeeId);
    }
}
