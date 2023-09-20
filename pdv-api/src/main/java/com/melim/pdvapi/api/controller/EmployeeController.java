package com.melim.pdvapi.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.melim.pdvapi.api.dto.EmployeeDTO;
import com.melim.pdvapi.exception.BusinessRuleException;
import com.melim.pdvapi.model.entity.AccessEmployee;
import com.melim.pdvapi.model.entity.Employee;
import com.melim.pdvapi.model.entity.enums.Role;
import com.melim.pdvapi.service.AccessEmployeeService;
import com.melim.pdvapi.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	private final EmployeeService service;
	private final AccessEmployeeService accessEmployeeService;
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody EmployeeDTO dto){
		Employee employee= convert(dto);
		
		return accessEmployeeService.getById(id).map(entity-> {
			try {
				employee.setId(entity.getIdEmployee().getId());
				employee.setDateCadaster(entity.getIdEmployee().getDateCadaster());
				service.update(employee);
				return new ResponseEntity<AccessEmployee>(HttpStatus.NO_CONTENT);
			}catch (BusinessRuleException e) {
				return ResponseEntity.badRequest().body(e.getMessage());					
			}
		}).orElseGet( () ->new ResponseEntity<String>("Usuario não encontrado na base de Dados.", HttpStatus.BAD_REQUEST) );
		
		
		/*try {
			
			return null;
		}catch (BusinessRuleException e) {
			return ResponseEntity.badRequest().body(e.getMessage());					
		}*/
		
	}
	
	
	
	
	private Employee convert(EmployeeDTO dto) {
		return Employee.builder().name(dto.getName())
				.role(Role.valueOf(dto.getRole()))
				.salary(dto.getSalary())
				.percentCommission(dto.getPercentCommission()).build();
				
	}
}
