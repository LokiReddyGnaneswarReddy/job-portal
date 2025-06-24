package com.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.entity.JobSeekerRegistration;

public interface JobSeekerRegRepository extends JpaRepository<JobSeekerRegistration, Integer> {

}