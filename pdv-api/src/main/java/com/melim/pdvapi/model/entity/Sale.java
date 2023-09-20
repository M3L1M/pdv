package com.melim.pdvapi.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.melim.pdvapi.api.dto.AccessEmployeeDTO;
import com.melim.pdvapi.model.entity.enums.PaymentFormat;
import com.melim.pdvapi.model.entity.enums.TypePayment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="sale")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "id_employee")
	private Employee idEmployee;
	
	private BigDecimal totalPrice;
	
	@Enumerated(EnumType.STRING)
	private TypePayment typePayment;
	@Enumerated(EnumType.STRING)
	private PaymentFormat paymentFormat;
	
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dateSale;
	
	
	
	
}
