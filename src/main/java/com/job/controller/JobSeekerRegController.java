package com.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.job.entity.JobSeeker;
import com.job.entity.JobSeekerRegistration;
import com.job.service.JobSeekerRegService;

@RestController
public class JobSeekerRegController {

    @Autowired
    private JobSeekerRegService seekerRegServe;

    @PostMapping("/Appregister")
    public ResponseEntity<String> registerUser(@RequestBody JobSeekerRegistration user) {
        seekerRegServe.registerAndSendEmail(user);
        return ResponseEntity.ok("Registered Successfully. Welcome email sent!");
    }
}