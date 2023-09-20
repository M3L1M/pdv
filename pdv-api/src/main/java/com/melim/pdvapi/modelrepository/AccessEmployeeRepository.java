package com.melim.pdvapi.modelrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.melim.pdvapi.model.entity.AccessEmployee;

public interface AccessEmployeeRepository extends JpaRepository<AccessEmployee, Integer> {

	boolean existsByUsername(String username);

}
