package com.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.job.entity.EmployerRegistration;
import com.job.service.EmployerRegisService;

@RestController
public class EmployerRegController {
	
	
	@Autowired
	private EmployerRegisService empRegServe;;
	
	@PostMapping("/EmpRegister")
	public EmployerRegistration empRegister(@RequestBody EmployerRegistration employerRegister) {
		return empRegServe.empRegis(employerRegister);
	}
}