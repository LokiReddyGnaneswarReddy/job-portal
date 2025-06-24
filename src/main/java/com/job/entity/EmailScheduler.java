package com.job.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.job.service.EmailService;

@Component
public class EmailScheduler {

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 9 * * ?") // Every day at 9 AM
    public void sendDailyReminder() {
        emailService.sendEmail("gnaneswarreddy579@gmail.com",
            "Daily Jobs Update",
            "Hey Gnanesh! Here are today's job updates...");
    }
}