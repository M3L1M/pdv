package com.melim.pdvapi.service;

import com.melim.pdvapi.model.entity.Employee;

public interface EmployeeService {
	public Employee save(Employee employee);
	public void update(Employee employee);
	public void delete(Integer id);
	public void validate(Employee employee);
}
