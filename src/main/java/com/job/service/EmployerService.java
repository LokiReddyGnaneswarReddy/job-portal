package com.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import com.job.entity.*;
import org.springframework.stereotype.Service;

import com.job.repository.EmployerRepository;
import com.job.repository.JobRepository;

@Service
public class EmployerService {

	
	@Autowired
	private EmployerRepository empRepo;
	
	@Autowired
	private JobRepository jobRepository;
	
	
	public Employer addDetails(Employer empl) {
		return empRepo.save(empl);
	}
	
	public List<Job> getTitle(String title) {
		List<Job> jobs=jobRepository.findByTitle(title);
		if(jobs.isEmpty()) {
			throw new CustomException("No jobs found with title: " +title);
		}
		return jobs;
	}
	
	public List<Job> getLocation(String location) {
		List<Job> ljob=jobRepository.findByLocation(location);
		if(ljob.isEmpty()) {
			throw new CustomException("No location found with location: " + location);
		}
		return ljob;
	}
	
	public List<Job> getTitleAndLocation(String title, String location) {
		List<Job>tljob= jobRepository.findByTitleAndLocation(title, location);
		if(tljob.isEmpty()) {
			throw new CustomException("No Title and Location found : " + title + " " +location);
		}
		return tljob;
	}
}