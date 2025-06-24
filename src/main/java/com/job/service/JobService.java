package com.job.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.job.entity.CustomException;
import com.job.entity.Employer;
import com.job.entity.Job;
import com.job.repository.EmployerRepository;
import com.job.repository.JobRepository;

@Service
public class JobService {

	@Autowired
	private JobRepository jobRepo;
	
	
	@Autowired
	private EmployerRepository employerRepo;

	
	
	
	public Optional<Job> getJobId(int id) {
		return jobRepo.findById(id);
	}
	
	
	
	public List<Job> getAllJobs() {
		return jobRepo.findAll();
	}
	
	
	public Job updateJob(int id, Job jobUpdate) {
		Job existingJob=jobRepo.findById(id)
		.orElseThrow(() -> new CustomException("Job not found with given id " +id));
		
		existingJob.setCompanyName(jobUpdate.getCompanyName());
		existingJob.setDescription(jobUpdate.getCompanyName());
		existingJob.setSalary(jobUpdate.getCompanyName());
		
		return jobRepo.save(existingJob);
	}
	
	
	public Job postJob(Job job) {
	    int employerId = job.getPostedByEmployer().getId();

	    Employer employer = employerRepo.findById(employerId)
	            .orElseThrow(() -> new RuntimeException("Employer not found"));

	    job.setPostedByEmployer(employer); // set full employer details
	    return jobRepo.save(job);
	}

	public List<Job> getTitle(String title) {
		List<Job> t=jobRepo.findByTitle(title);
		if(t.isEmpty()) {
			throw new CustomException("No jobs found with title : " + title);
		}
		return t;
	}
	
	
	public List<Job> getLocation(String location) {
		List<Job> ljob=jobRepo.findByLocation(location);
		if(ljob.isEmpty()) {
			throw new CustomException("No job found with location: " + location);
		}
		return ljob;
	}
	
	public List<Job> getTitleAndLocation(String title, String location) {
		List<Job>tljob= jobRepo.findByTitleAndLocation(title, location);
		if(tljob.isEmpty()) {
			throw new CustomException("No Title and Location found : " + title + " " +location);
		}
		return tljob;
	}
}