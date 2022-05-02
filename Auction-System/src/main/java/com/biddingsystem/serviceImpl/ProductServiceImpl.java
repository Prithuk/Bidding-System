package com.biddingsystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biddingsystem.model.Product;
import com.biddingsystem.repository.ProductRepository;
import com.biddingsystem.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProduct() throws Exception {
		return productRepository.findAll();
	}

	@Override
	public Product registerProduct(Product product) throws Exception {
		return productRepository.save(product);
	}

}
