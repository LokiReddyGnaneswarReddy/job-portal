package com.job.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class JobApplication {
	
	
	
	    public JobApplication(JobSeeker seeker, Job job, LocalDateTime localDateTime) {
		
	}
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String jobTitle;
	    private String companyName;
	    private String seekerName;

}
