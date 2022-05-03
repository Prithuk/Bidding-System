package com.biddingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biddingsystem.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
