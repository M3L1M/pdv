package com.melim.pdvapi.modelrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.melim.pdvapi.model.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

}
