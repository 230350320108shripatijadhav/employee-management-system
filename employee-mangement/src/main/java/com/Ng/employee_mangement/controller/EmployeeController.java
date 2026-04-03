package com.Ng.employee_mangement.controller;

import com.Ng.employee_mangement.entity.Employee;
import com.Ng.employee_mangement.service.EmployeeService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*") // allow React frontend
public class EmployeeController {

    private final EmployeeService service;


    public EmployeeController(EmployeeService service) {
        this.service = service;
    }


    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {

        return service.saveEmployee(employee);
    }


    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }


    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }


    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }


    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }

    @PutMapping("/{id}/salary")
    public Employee updateSalary(@PathVariable Long id,
                                 @RequestParam Double salary) {
        return service.updateSalary(id, salary);
    }
}