package com.melim.pdvapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.melim.pdvapi.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
