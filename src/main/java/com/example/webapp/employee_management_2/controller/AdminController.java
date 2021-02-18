package com.example.webapp.employee_management_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	
	@GetMapping("/admin")
	public String getAllAdmins() {
		return "admin";
	}
}
