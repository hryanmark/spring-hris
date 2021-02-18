package com.example.webapp.employee_management_2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webapp.employee_management_2.model.Department;
import com.example.webapp.employee_management_2.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public void saveDepartment(Department department) {
		this.departmentRepository.save(department);
	}

	@Override
	public Department getDepartmentById(long id) {
		Optional<Department> optional = departmentRepository.findById(id);
		Department department = null;
		
		if(optional.isPresent()) {
			department = optional.get();
			return department;
		}

		throw new RuntimeException("Department not found by id :: " + id);
	}

	@Override
	public void deleteDepartment(long id) {
		this.departmentRepository.deleteById(id);
	}
}
