package com.example.webapp.employee_management_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenerateReportController {

	
	@GetMapping("/generate_report")
	public String getAllGenerateReports() {
		return "generate_report";
	}
}
