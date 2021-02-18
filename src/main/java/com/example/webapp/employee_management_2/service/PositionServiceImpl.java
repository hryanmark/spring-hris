package com.example.webapp.employee_management_2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webapp.employee_management_2.model.Employee;
import com.example.webapp.employee_management_2.model.Position;
import com.example.webapp.employee_management_2.repository.PositionRepository;

@Service
public class PositionServiceImpl implements PositionService{

	@Autowired
	PositionRepository positionRepository;
	
	@Override
	public List<Position> getAllPositions() {
		return positionRepository.findAll();
	}

	@Override
	public void savePosition(Position position) {
		this.positionRepository.save(position);
	}

	@Override
	public Position getPositionById(long id) {
		Optional<Position> optional = positionRepository.findById(id);
		Position position = null;
		
		if(optional.isPresent()) {
			position = optional.get();
			return position;
		}

		throw new RuntimeException("Employee not found by id :: " + id);
	}

	@Override
	public void deletePosition(long id) {
		this.positionRepository.deleteById(id);
	}

}
