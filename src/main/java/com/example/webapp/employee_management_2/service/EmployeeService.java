package com.example.webapp.employee_management_2.service;

import java.util.List;

import com.example.webapp.employee_management_2.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	void saveEmployee(Employee employee);
	
	Employee getEmployeeById(long id);
	
	void deleteEmployee(long id);
}
