package com.employee.management.system.service;

import com.employee.management.system.entity.Employee;
import com.employee.management.system.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO mEmployeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        mEmployeeRepo = employeeDAO;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return mEmployeeRepo.findAll();
    }

    @Override
    public Employee finEmployee(int employeeId) {
        return mEmployeeRepo.finEmployee(employeeId);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return mEmployeeRepo.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int employeeId) {
        mEmployeeRepo.deleteEmployeeById(employeeId);
    }
}
