package com.example.webapp.employee_management_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.webapp.employee_management_2.model.Department;
import com.example.webapp.employee_management_2.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/department")
	public String viewDepartment(Model model) {
		model.addAttribute("listDepartments", departmentService.getAllDepartments());
		return "department";
	}
	
	@GetMapping("/new_department")
	public String showNewDepartmentForm(Model model) {
		Department department = new Department();
		model.addAttribute("department", department);
		return "new_department";
	}
	
	@PostMapping("/save_department")
	public String saveDepartment(@ModelAttribute("department") Department department) {
		departmentService.saveDepartment(department);
		return "redirect:/department";
	}
	
	@GetMapping("/update_department/{id}")
	public String showUpdateDepartmentForm(@PathVariable (value = "id") long id, Model model) {
		Department department = departmentService.getDepartmentById(id);
		model.addAttribute("department", department);
		return "update_department";
	}
	
	@GetMapping("/delete_department/{id}")
	public String deleteDepartment(@PathVariable (value = "id") long id) {
		departmentService.deleteDepartment(id);
		return "redirect:/department";
	}
}
