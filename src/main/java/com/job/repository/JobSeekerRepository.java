package com.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.entity.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer>{
	
}