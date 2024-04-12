package com.employee.management.system.repository;

import com.employee.management.system.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final EntityManager mEntityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        mEntityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = mEntityManager.createQuery("FROM Employee", Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee finEmployee(int employeeId) {
        return mEntityManager.find(Employee.class, employeeId);
    }

    @Override
    public Employee save(Employee employee) {
        return mEntityManager.merge(employee);
    }

    @Override
    public void deleteEmployeeById(int employeeId) {
        Employee employee = mEntityManager.find(Employee.class, employeeId);

        mEntityManager.remove(employee);
    }
}
