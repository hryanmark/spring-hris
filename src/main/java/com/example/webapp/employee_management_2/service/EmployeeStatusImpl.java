package com.example.webapp.employee_management_2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webapp.employee_management_2.model.EmployeeStatus;
import com.example.webapp.employee_management_2.repository.EmployeeStatusRepository;

@Service
public class EmployeeStatusImpl implements EmployeeStatusService {

	@Autowired
	EmployeeStatusRepository employeeStatusRepository;
	
	@Override
	public List<EmployeeStatus> getAllEmployeeStatus() {
		return employeeStatusRepository.findAll();
	}

	@Override
	public void saveEmployeeStatus(EmployeeStatus employeeStatus) {
		this.employeeStatusRepository.save(employeeStatus);
	}

	@Override
	public EmployeeStatus getEmployeeStatusById(long id) {
		Optional<EmployeeStatus> optional = employeeStatusRepository.findById(id);
		EmployeeStatus employeeStatus = null;
		
		if(optional.isPresent()) {
			employeeStatus = optional.get();
			return employeeStatus;
		}

		throw new RuntimeException("Employee Status not found by id :: " + id);
	}

	@Override
	public void deleteEmployeeStatus(long id) {
		this.employeeStatusRepository.deleteById(id);
	}

	
}
