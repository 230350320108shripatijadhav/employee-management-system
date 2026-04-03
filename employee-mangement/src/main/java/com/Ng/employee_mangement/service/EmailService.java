package com.Ng.employee_mangement.service;

import com.Ng.employee_mangement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmployeeReport(List<Employee> employees) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("shripatijadhav86@gmail.com");
        message.setSubject("Employee Report (Every 30 sec)");

        StringBuilder body = new StringBuilder();
        body.append("Employee List:\n\n");

        for (Employee e : employees) {
            body.append("ID: ").append(e.getId()).append("\n");
            body.append("Name: ").append(e.getName()).append("\n");
            body.append("Dept: ").append(e.getDepartment()).append("\n");
            body.append("----------------------\n");
        }

        message.setText(body.toString());

        mailSender.send(message);
    }
}