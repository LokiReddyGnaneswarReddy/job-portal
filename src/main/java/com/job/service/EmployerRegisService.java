package com.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.job.entity.EmployerRegistration;
import com.job.repository.EmployerRegRepository;

@Service
public class EmployerRegisService {
	
	
	@Autowired
	private EmployerRegRepository empRegRepo;
	
	
	public EmployerRegistration empRegis(EmployerRegistration employeeReg) {
		return empRegRepo.save(employeeReg);
	}
}