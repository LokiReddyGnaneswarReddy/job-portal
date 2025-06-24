package com.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.job.entity.JobSeekerRegistration;
import com.job.repository.JobSeekerRegRepository;
import com.job.repository.JobSeekerRepository;

@Service
public class JobSeekerRegService {

    @Autowired
    private JobSeekerRegRepository repo;

    @Autowired
    private EmailService emailService;

    public void registerAndSendEmail(JobSeekerRegistration user) {
        // Save user to DB
        JobSeekerRegistration saved = repo.save(user);

        // Send welcome email
        String body = "Hi " + saved.getName() + ",\n\nThanks for registering! Welcome to JobPortal.";
        emailService.sendEmail(saved.getEmail(), "Welcome to JobPortal", body);
    }
}
