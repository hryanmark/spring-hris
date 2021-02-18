package com.example.webapp.employee_management_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webapp.employee_management_2.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
