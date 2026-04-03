package com.Ng.employee_mangement.controller;

import com.Ng.employee_mangement.entity.Employee;
import com.Ng.employee_mangement.repository.EmployeeRepository;
import com.Ng.employee_mangement.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeExcelController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportExcel() {

        List<Employee> employees = repository.findAll();

        byte[] excelData = ExcelUtil.generateExcel(employees);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=employees.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(excelData);
    }
}