package com.biddingsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biddingsystem.model.Auction;
import com.biddingsystem.model.Product;

@Service
public interface AuctionService {

	List<Auction> getAllAuctionList() throws Exception; 
	
	Auction getByid(Long id) throws Exception;

	Auction addNewAuction(Auction auction) throws Exception;

	public void updateAuction(Long id, Auction auction) throws Exception;

	public void deleteAuction(Long id) throws Exception;

	Auction getByProduct(Product product) throws Exception;
}
