package com.job.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.job.entity.Employer;
import com.job.entity.Job;
import com.job.repository.JobRepository;
import com.job.service.EmployerService;
import com.job.service.JobService;

@RestController
public class EmployerController {
	
	
	@Autowired
	private EmployerService empService;
	
	
	@Autowired
	private JobRepository jobRepo;
	
	@PostMapping("/register")
	public Employer details(@RequestBody Employer emp) {
		return empService.addDetails(emp);
	}
	
	@GetMapping("/GetAllEmpJobs")
	public List<Job> getAllJobs(){
		return jobRepo.findAll();
	}
	
	@GetMapping("/GetJobTitle")
	public List<Job> findTitle(@RequestParam String title) {
		return empService.getTitle(title);
	}
	
	@GetMapping("/GetJobLocation")
	public List<Job> findLocation(@RequestParam String location) {
		return empService.getLocation(location);
	}
	
	@GetMapping("/GetTitleAndLocation")
	public List<Job> findTitleLocation(@RequestParam String title, String location) {
		return empService.getTitleAndLocation(title, location);
	}
}