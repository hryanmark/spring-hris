package com.example.webapp.employee_management_2.service;

import java.util.List;

import com.example.webapp.employee_management_2.model.EmployeeStatus;

public interface EmployeeStatusService {

	List<EmployeeStatus> getAllEmployeeStatus();
	
	void saveEmployeeStatus(EmployeeStatus employeeStatus);
	
	EmployeeStatus getEmployeeStatusById(long id);
	
	void deleteEmployeeStatus(long id);
	
}
