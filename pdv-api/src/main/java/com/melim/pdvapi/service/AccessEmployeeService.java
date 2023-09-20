package com.melim.pdvapi.service;

import java.util.Optional;

import com.melim.pdvapi.model.entity.AccessEmployee;

public interface AccessEmployeeService {
	public AccessEmployee authenticate(String username,String password);
	public AccessEmployee save(AccessEmployee accessEmployee);
	public void update(Integer id,AccessEmployee accessEmployee);
	public void delete(Integer id);
	public void validate(AccessEmployee accessEmployee);
	public Optional<AccessEmployee> getById(Integer id);
	
}
