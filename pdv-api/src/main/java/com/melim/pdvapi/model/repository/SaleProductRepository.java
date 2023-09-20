package com.melim.pdvapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.melim.pdvapi.model.entity.SaleProduct;

public interface SaleProductRepository extends JpaRepository<SaleProduct, Integer> {

}
