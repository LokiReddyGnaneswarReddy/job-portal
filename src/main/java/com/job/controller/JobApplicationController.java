package com.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.job.service.JobApplicationService;

@RestController
public class JobApplicationController {

    @Autowired
    private JobApplicationService applicationService;

    @PostMapping("/{jobId}/apply")
    public ResponseEntity<String> applyToJob(
        @PathVariable int jobId,
        @RequestParam int seekerId
    ) {
        applicationService.applyAndNotify(jobId, seekerId);
        return ResponseEntity.ok("Application submitted! Confirmation email sent.");
    }
}