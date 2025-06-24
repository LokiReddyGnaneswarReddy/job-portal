package com.job.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.job.entity.Job;
import com.job.service.JobService;


@RestController
public class JobController {
	
	
	@Autowired
	private JobService jobService;
	
	
	
	@GetMapping("/GetId/{id}")
	public Optional<Job> getId(@PathVariable("id") Integer id) {
	    return jobService.getJobId(id);
	}

	
	
	@GetMapping("/GetJobs")
	public List<Job> getAllJobs() {
		return jobService.getAllJobs();
	}
	
	
	@PostMapping("/postJob")
	public Job postJobs(@RequestBody Job post) {
	    return jobService.postJob(post); 
	}
	
	
	@PutMapping("/jobUpdates/{id}")
	public ResponseEntity<Job> jobUpdates(@PathVariable int id, @RequestBody Job jobs) {
		Job updated=jobService.updateJob(id, jobs);
		return ResponseEntity.ok(updated);
	}
	 
	@GetMapping("/getJobsByName")
	public List<Job> getJobNames(@RequestParam String title ) {
		return jobService.getTitle(title);
	} 
	
	@GetMapping("/GetAllJobs")
	public List<Job> getAllJobs(Job jobs) {
		return jobService.getAllJobs();
	}
	
	
	@GetMapping("/locationBasedJob")
	public List<Job> getLocation(@RequestParam String location) {
		return jobService.getLocation(location);
	}
	
	
	@GetMapping("/GetTitle&And&Location")
	public List<Job> findTitleAndLocation(@RequestParam String title, @RequestParam String location) {
		return jobService.getTitleAndLocation(title, location);
	}
	}