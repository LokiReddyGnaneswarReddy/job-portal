package com.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.job.entity.EmployerRegistration;

public interface EmployerRegRepository extends JpaRepository<EmployerRegistration, Integer> {

}