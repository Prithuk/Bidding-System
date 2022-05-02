package com.biddingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biddingsystem.model.Product;
import com.biddingsystem.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> getAllProduct() throws Exception {
		List<Product> productList = productService.getAllProduct();
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) throws Exception {
		return new ResponseEntity<>(productService.registerProduct(product), HttpStatus.OK);
	}

}
