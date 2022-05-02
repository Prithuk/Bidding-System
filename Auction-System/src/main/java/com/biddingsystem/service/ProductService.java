package com.biddingsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biddingsystem.model.Product;

@Service
public interface ProductService {

	public List<Product> getAllProduct() throws Exception;

	public Product registerProduct(Product product) throws Exception;

}
