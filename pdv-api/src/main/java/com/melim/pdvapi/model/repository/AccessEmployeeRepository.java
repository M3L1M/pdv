package com.melim.pdvapi.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.melim.pdvapi.model.entity.AccessEmployee;

public interface AccessEmployeeRepository extends JpaRepository<AccessEmployee, Integer> {

	Optional<AccessEmployee> findByUsername(String username);

	boolean existsByUsername(String username);

	

}
