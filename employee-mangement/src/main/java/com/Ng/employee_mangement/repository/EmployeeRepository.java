package com.Ng.employee_mangement.repository;

import com.Ng.employee_mangement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee ,Long> {


}
