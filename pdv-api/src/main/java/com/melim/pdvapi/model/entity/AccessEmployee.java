package com.melim.pdvapi.model.entity;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.melim.pdvapi.model.entity.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="access_employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccessEmployee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	
	@OneToOne
	@JoinColumn(name = "id_employee")
	private Employee idEmployee;

	@Enumerated(EnumType.STRING)
	private Status status;
}
