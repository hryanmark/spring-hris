package com.example.webapp.employee_management_2.service;

import java.util.List;

import com.example.webapp.employee_management_2.model.Department;

public interface DepartmentService {

	List<Department> getAllDepartments();
	
	void saveDepartment(Department department);
	
	Department getDepartmentById(long id);
	
	void deleteDepartment(long id);
}
