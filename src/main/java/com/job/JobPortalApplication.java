package com.job;
import com.job.service.EmailService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableScheduling  // Add this to your main class
@SpringBootApplication
public class JobPortalApplication implements CommandLineRunner {

    @Autowired
    private EmailService emailService;

    public static void main(String[] args) {
        SpringApplication.run(JobPortalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        emailService.sendEmail("santhosh.yadavbluphix@gmail.com", "Hello!", "Welcome to our Job Portal 🚀");
    }
}