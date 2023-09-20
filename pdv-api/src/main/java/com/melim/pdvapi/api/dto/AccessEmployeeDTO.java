package com.melim.pdvapi.api.dto;

import com.melim.pdvapi.model.entity.AccessEmployee;
import com.melim.pdvapi.model.entity.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccessEmployeeDTO {
	private Integer id;
	private EmployeeDTO employee;
	private String username;
	private String password;
	private String status;
}
