package com.melim.pdvapi.modelrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.melim.pdvapi.model.entity.SaleProduct;

public interface SaleProductRepository extends JpaRepository<SaleProduct, Integer> {

}
