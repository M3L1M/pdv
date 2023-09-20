package com.melim.pdvapi.model.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.melim.pdvapi.api.dto.AccessEmployeeDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="sale_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_sale")
	private Sale idSale;
	
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product idProduct;
	
	private Double quantity;
	private BigDecimal price;
	
	
}
