package com.example.webapp.employee_management_2.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.webapp.employee_management_2.model.Department;
import com.example.webapp.employee_management_2.model.Employee;
import com.example.webapp.employee_management_2.service.DepartmentService;
import com.example.webapp.employee_management_2.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	//display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return "index";
	}
	
	@GetMapping("/employees")
	public String viewEmployees(Model model) { 
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "employee";
	}
	
	@GetMapping("/new_employee")
	public String showNewEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		Department department =  departmentService.getDepartmentById(6);
		model.addAttribute("code", department.getCode());
		return "new_employee";
	}
	
	@PostMapping("/save_employee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		//Save to employee database
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/update_employee/{id}")
	public String showUpdateEmployeeForm(@PathVariable (value = "id") long id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/delete_employee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}
}
