package com.biddingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biddingsystem.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
