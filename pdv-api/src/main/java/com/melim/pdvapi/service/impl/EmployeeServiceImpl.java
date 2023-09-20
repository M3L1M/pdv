package com.melim.pdvapi.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melim.pdvapi.exception.ErrorValidate;
import com.melim.pdvapi.model.entity.Employee;
import com.melim.pdvapi.modelrepository.EmployeeRepository;
import com.melim.pdvapi.service.EmployeeService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private final EmployeeRepository repository;
	
	
	@Override
	@Transactional
	public Employee save(Employee employee) {
		validate(employee);
		employee.setDateCadaster(LocalDate.now());
		return repository.save(employee);
	}

	@Override
	public void update(Integer id, Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void validate(Employee employee) {
		if(employee.getName().isEmpty()) {
			throw new ErrorValidate("Nome em branco");
		}
		
		
		
		
		
	}
	
	
}
