package com.example.webapp.employee_management_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.webapp.employee_management_2.model.EmployeeStatus;
import com.example.webapp.employee_management_2.service.EmployeeStatusService;

@Controller
public class EmployeeStatusController {

	@Autowired
	EmployeeStatusService employeeStatusService;
	
	@GetMapping("/employee_status")
	public String viewEmployeeStatus(Model model) {
		model.addAttribute("listEmployeeStatus", employeeStatusService.getAllEmployeeStatus());
		return "employee_status";
	}
	
	@GetMapping("/new_employee_status")
	public String showNewEmployeeStatusForm(Model model) {
		EmployeeStatus employeeStatus = new EmployeeStatus();
		model.addAttribute("employeeStatus", employeeStatus);
		return "new_employee_status";
	}
	
	@PostMapping("/save_employee_status")
	public String saveEmployeeStatus(@ModelAttribute("employeeStatus") EmployeeStatus employeeStatus) {
		employeeStatusService.saveEmployeeStatus(employeeStatus);
		return "redirect:/employee_status";
	}
	
	@GetMapping("/update_employee_status/{id}")
	public String showUpdateEmployeeStatusForm(@PathVariable (value = "id") long id, Model model) {
		EmployeeStatus employeeStatus = employeeStatusService.getEmployeeStatusById(id);
		model.addAttribute("employeeStatus", employeeStatus);
		return "update_employee_status";
	}
	
	@GetMapping("/delete_employee_status/{id}")
	public String deleteEmployeeStatus(@PathVariable (value = "id") long id) {
		employeeStatusService.deleteEmployeeStatus(id);
		return "redirect:/employee_status";
	}
	
}
