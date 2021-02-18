package com.example.webapp.employee_management_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.webapp.employee_management_2.model.Employee;
import com.example.webapp.employee_management_2.model.Position;
import com.example.webapp.employee_management_2.service.PositionService;

@Controller
public class PositionController {

	@Autowired
	PositionService positionService;
	
	@GetMapping("/position")
	public String viewPosition(Model model) {
		model.addAttribute("listPositions", positionService.getAllPositions());
		return "position";
	}
	
	@GetMapping("/new_position")
	public String showNewPositionForm(Model model) {
		Position position = new Position();
		model.addAttribute("position", position);
		return "new_position";
	}
	
	@PostMapping("/save_position")
	public String savePosition(@ModelAttribute("position") Position position) {
		positionService.savePosition(position);
		return "redirect:/position";
	}
	
	@GetMapping("/update_position/{id}")
	public String showUpdatePositionForm(@PathVariable (value = "id") long id, Model model) {
		Position position= positionService.getPositionById(id);
		model.addAttribute("position", position);
		return "update_position";
	}
	
	@GetMapping("/delete_position/{id}")
	public String deletePosition(@PathVariable (value = "id") long id) {
		positionService.deletePosition(id);
		return "redirect:/position";
	}
}
