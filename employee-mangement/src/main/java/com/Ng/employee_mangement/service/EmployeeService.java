package com.Ng.employee_mangement.service;

import com.Ng.employee_mangement.entity.Employee;
import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();   // ✅ fixed

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

    public Employee updateSalary(Long id, Double salary);
}