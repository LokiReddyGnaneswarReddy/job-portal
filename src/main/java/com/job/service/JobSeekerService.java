package com.job.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import com.job.entity.CustomException;
import com.job.entity.Job;
import com.job.entity.JobSeeker;
import com.job.repository.JobRepository;
import com.job.repository.JobSeekerRepository;

@Service
public class JobSeekerService {
	
	@Autowired
	private JobSeekerRepository jobSeekRepo;
	
	@Autowired
	private JobRepository jobRepository;
	
	
	//Data injection
	public JobSeeker jobSeeker(JobSeeker seek) {
		return jobSeekRepo.save(seek);
	}	
	
	//Get all jobs
	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}
	
	
	public JobSeeker updateDetails(int id, JobSeeker updateSeeker) {
		JobSeeker existingSeeker = jobSeekRepo.findById(id)
		.orElseThrow(() -> new CustomException("JobSeeker not found with id : "+id));
			
		existingSeeker.setName(updateSeeker.getName());
		existingSeeker.setEmail(updateSeeker.getEmail());
		existingSeeker.setResume(updateSeeker.getResume());
		
		return jobSeekRepo.save(existingSeeker);
	}
	
	
	//Get job title
	public List<Job> getTitle(String title) {
		List<Job> t=jobRepository.findByTitle(title);
		if(t.isEmpty()) {
			throw new CustomException("No jobs found with title : " + title);
		}
		return t;
	}
	
	//Get job location
	public List<Job> getLocation(String location) {
		List<Job> ljob=jobRepository.findByLocation(location);
		if(ljob.isEmpty()) {
			throw new CustomException("No location found with location: " + location);
		}
		return ljob;
	}
	
	
	//Get title and location
	public List<Job> getTitleAndLocation(String title, String location) {
		List<Job>tljob= jobRepository.findByTitleAndLocation(title, location);
		if(tljob.isEmpty()) {
			throw new CustomException("No Title and Location found : " + title + " " +location);
		}
		return tljob;
	}	
}