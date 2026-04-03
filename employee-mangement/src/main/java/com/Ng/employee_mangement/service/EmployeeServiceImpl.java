package com.Ng.employee_mangement.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Ng.employee_mangement.entity.Employee;
import com.Ng.employee_mangement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    // ✅ Constructor Injection (Best Practice)
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = getEmployeeById(id);

        // ✅ No need for null check
        existing.setName(employee.getName());
        existing.setAddress(employee.getAddress());
        existing.setMobileNumber(employee.getMobileNumber());
        existing.setSalary(employee.getSalary());
        existing.setDepartment(employee.getDepartment());

        return repository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee existing=getEmployeeById(id);
        repository.delete(existing);
    }
}