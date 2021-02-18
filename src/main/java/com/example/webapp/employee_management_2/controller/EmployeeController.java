package com.example.webapp.employee_management_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.webapp.employee_management_2.model.Employee;
import com.example.webapp.employee_management_2.service.EmployeeService;

@Controller
public class EmployeeController {

	/*Employee List 
	 * ADD
	 * View
	 * EDit
	 * Delete*/
	@Autowired
	private EmployeeService employeeService;
	
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
