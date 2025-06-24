package com.job.controller;


import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.job.entity.Job;
import com.job.entity.JobSeeker;
import com.job.service.JobSeekerService;
import com.job.service.JobService;

@RestController
public class JobSeekerController {
	
	
	@Autowired 
	private JobSeekerService jobseekServe;
	
	@Autowired
	private JobService jobService;
	

	@PostMapping("/insertData")
	public JobSeeker jobSeek(@RequestBody JobSeeker jobseeker) {
		return jobseekServe.jobSeeker(jobseeker);
	}	
	
	
	@PutMapping("/updateDetails/{id}")
	public ResponseEntity<JobSeeker>updateJobSeeker(@PathVariable int id, @RequestBody JobSeeker seeker) {
		JobSeeker updated=jobseekServe.updateDetails(id, seeker);
		return ResponseEntity.ok(updated);
	}
	 
	@GetMapping("/getJobName")
	public List<Job> getJobNames(@RequestParam String title ) {
		return jobService.getTitle(title);
	} 
	
	@GetMapping("/getAllJobs")
	public List<Job> getAllJobs(Job jobs) {
		return jobService.getAllJobs();
	}
	
	
	@GetMapping("/Joblocation")
	public List<Job> getLocation(@RequestParam String location) {
		return jobService.getLocation(location);
	}
	
	
	@GetMapping("/GetJobName&Location")
	public List<Job> findTitleAndLocation(@RequestParam String title, @RequestParam String location) {
		return jobService.getTitleAndLocation(title, location);
	}
}