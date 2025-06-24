package com.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.entity.Job;

public interface JobRepository extends JpaRepository<Job, Integer>{
	
	List<Job> findByTitle(String title);
	
	List<Job> findByLocation(String location);
	
	List<Job> findByTitleAndLocation(String title, String location);

}