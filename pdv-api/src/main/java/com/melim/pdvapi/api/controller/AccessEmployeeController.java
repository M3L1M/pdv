package com.melim.pdvapi.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.melim.pdvapi.api.dto.AccessEmployeeDTO;
import com.melim.pdvapi.api.dto.EmployeeDTO;
import com.melim.pdvapi.exception.BusinessRuleException;
import com.melim.pdvapi.model.entity.AccessEmployee;
import com.melim.pdvapi.model.entity.Employee;
import com.melim.pdvapi.model.entity.enums.Role;
import com.melim.pdvapi.model.entity.enums.Status;
import com.melim.pdvapi.service.AccessEmployeeService;
import com.melim.pdvapi.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/access-employee")
public class AccessEmployeeController {
	private final AccessEmployeeService service;
	private final EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody AccessEmployeeDTO dto){
		
		try {
			AccessEmployee accessEmployee=convert(dto);
			Employee employee=convert(dto.getEmployee());
			
			employee=employeeService.save(employee);
			accessEmployee.setIdEmployee(employee);
			accessEmployee=service.save(accessEmployee);
			return new ResponseEntity<AccessEmployee>(accessEmployee,HttpStatus.CREATED);
		}catch (BusinessRuleException e) {
			return ResponseEntity.badRequest().body(e.getMessage());					
		}
	}
	
	public ResponseEntity<?> authenticate(@RequestBody AccessEmployeeDTO dto){
		String password=dto.getPassword();
		String username=dto.getUsername();
		
		try {
			AccessEmployee accessEmployee=service.authenticate(username, password);
			return new ResponseEntity<AccessEmployee>(accessEmployee,HttpStatus.OK);
		}catch (BusinessRuleException e) {
			return ResponseEntity.badRequest().body(e.getMessage());					
		}
		
		
		
	}
	
	
	
	private AccessEmployee convert(AccessEmployeeDTO dto) {
		return AccessEmployee.builder()
				.username(dto.getUsername())
				.password(dto.getPassword())
				.status(Status.valueOf(dto.getStatus())).build();
	}
	
	private Employee convert(EmployeeDTO dto) {
		return Employee.builder().name(dto.getName())
				.role(Role.valueOf(dto.getRole()))
				.salary(dto.getSalary())
				.percentCommission(dto.getPercentCommission()).build();
				
	}
	
}
