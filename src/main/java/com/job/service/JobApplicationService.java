package com.job.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.entity.Job;
import com.job.entity.JobApplication;
import com.job.entity.JobSeeker;
import com.job.repository.JobApplicationRepository;
import com.job.repository.JobRepository;
import com.job.repository.JobSeekerRepository;

@Service
public class JobApplicationService {

    @Autowired
    private JobRepository jobRepo;

    @Autowired
    private JobSeekerRepository seekerRepo;

    @Autowired
    private JobApplicationRepository applicationRepo;

    @Autowired
    private EmailService emailService;

    public void applyAndNotify(int jobId, int seekerId) {
        Job job = jobRepo.findById(jobId)
            .orElseThrow(() -> new RuntimeException("Job not found"));
        JobSeeker seeker = seekerRepo.findById(seekerId)
            .orElseThrow(() -> new RuntimeException("Job seeker not found"));

        JobApplication app = new JobApplication(seeker, job, LocalDateTime.now());
        applicationRepo.save(app);

        // Compose email
        String subject = "✅ Your application for " + job.getTitle();
        String body = "Hi " + seeker.getName() + ",\n\n" +
                      "Thank you for applying to **" + job.getTitle() +
                      "** at **" + job.getCompanyName() + "**.\n" +
                      "We’ve received your application and our hiring team will review it shortly.\n\n" +
                      "What happens next?\n" +
                      " – ✅ If shortlisted, you’ll get an email from our HR team.\n" +
                      " – 📅 Timeline: Expect feedback within 7 days.\n\n" +
                      "Best of luck!\n" +
                      "– The JobPortal Team";

        emailService.sendEmail(seeker.getEmail(), subject, body);
    }
}