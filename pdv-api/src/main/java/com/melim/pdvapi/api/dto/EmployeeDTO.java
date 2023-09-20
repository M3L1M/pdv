package com.melim.pdvapi.api.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {
	private Integer id;
	private String name;
	private String role;
	private BigDecimal salary;
	private Double percentCommission;
}
