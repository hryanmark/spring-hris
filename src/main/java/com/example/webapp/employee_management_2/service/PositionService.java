package com.example.webapp.employee_management_2.service;

import java.util.List;

import com.example.webapp.employee_management_2.model.Position;

public interface PositionService {
	
	List<Position> getAllPositions();
	
	void savePosition(Position position);
	
	Position getPositionById(long id);
	
	void deletePosition(long id);
}
