package com.melim.pdvapi.modelrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.melim.pdvapi.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
