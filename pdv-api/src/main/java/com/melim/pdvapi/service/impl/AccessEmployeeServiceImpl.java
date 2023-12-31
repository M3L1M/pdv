package com.melim.pdvapi.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.melim.pdvapi.exception.AuthenticationException;
import com.melim.pdvapi.exception.ErrorValidate;
import com.melim.pdvapi.model.entity.AccessEmployee;
import com.melim.pdvapi.model.entity.enums.Status;
import com.melim.pdvapi.modelrepository.AccessEmployeeRepository;
import com.melim.pdvapi.service.AccessEmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AccessEmployeeServiceImpl implements AccessEmployeeService {
	
	private final AccessEmployeeRepository repository;
	
	
	@Override
	@Transactional
	public AccessEmployee authenticate(String username,String password) {
		
		Optional<AccessEmployee> accessEmployee=repository.findByUsername(username);
		
		if(!accessEmployee.isPresent()) {
			throw new AuthenticationException("Usuario não encontrado na base de dados");
		}
		
		if(!accessEmployee.get().getPassword().equals(password)) {
			throw new AuthenticationException("Senha invalida");
		}
		
		if(accessEmployee.get().getStatus().equals(Status.INACTIVE)) {
			throw new AuthenticationException("Este usuario esta inativado, entre em contato com o suporte");
		}
		
		
		return accessEmployee.get();
	}

	@Override
	@Transactional
	public AccessEmployee save(AccessEmployee accessEmployee) {
		validate(accessEmployee);
		return repository.save(accessEmployee);
	}

	@Override
	public void update(Integer id, AccessEmployee accessEmployee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(AccessEmployee accessEmployee) {
		
		if(accessEmployee.getPassword().length()<4) {
			throw new ErrorValidate("A senha precisa ter mais de 4 caracteres");
		}
		
		boolean existsUsername=repository.existsByUsername(accessEmployee.getUsername());
		
		if(existsUsername) {
			throw new ErrorValidate("Usuario ja cadastrado com esse nome");
		}
		
		
	}

	@Override
	public Optional<AccessEmployee> getById(Integer id) {
		return repository.findById(id);
	}

}
