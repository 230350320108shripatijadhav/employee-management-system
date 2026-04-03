package com.Ng.employee_mangement.repository;

import com.Ng.employee_mangement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee ,Long> {

}
