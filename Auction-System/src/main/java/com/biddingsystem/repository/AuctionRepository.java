package com.biddingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biddingsystem.model.Auction;
import com.biddingsystem.model.Product;

public interface AuctionRepository extends JpaRepository<Auction, Long> {

	Auction findByProduct(Product product);

}
