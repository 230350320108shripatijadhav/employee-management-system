package com.Ng.employee_mangement.component;

import com.Ng.employee_mangement.entity.Employee;
import com.Ng.employee_mangement.repository.EmployeeRepository;
import com.Ng.employee_mangement.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EmployeeScheduler {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmailService emailService;

    private boolean isRunning = false; // control flag

    @Scheduled(fixedRate = 30000)
   // @Scheduled(cron = "0 0 22 * * *")
    public void sendEmployeeData() {

        if (!isRunning) {
            System.out.println("Corn Scheduler stopped...");
            return; // ❌ skip execution
        }

        System.out.println("Corn Scheduler running...");

        List<Employee> employees = repository.findAll();

        emailService.sendEmployeeReport(employees);
    }

    public void start() {
        isRunning = true;
    }

    public void stop() {
        isRunning = false;
    }

    public boolean status() {
        return isRunning;
    }
}