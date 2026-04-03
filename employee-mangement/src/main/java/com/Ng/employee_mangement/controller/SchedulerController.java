package com.Ng.employee_mangement.controller;

import com.Ng.employee_mangement.component.EmployeeScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController {

    @Autowired
    private EmployeeScheduler scheduler;

    @GetMapping("/start")
    public String start() {
        scheduler.start();
        return "Scheduler Started";
    }

    @GetMapping("/stop")
    public String stop() {
        scheduler.stop();
        return "Scheduler Stopped";
    }

    @GetMapping("/status")
    public String status() {
        return scheduler.status() ? "Running" : "Stopped";
    }
}