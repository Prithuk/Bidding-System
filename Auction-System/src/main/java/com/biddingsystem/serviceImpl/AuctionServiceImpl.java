package com.biddingsystem.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biddingsystem.model.Auction;
import com.biddingsystem.model.Product;
import com.biddingsystem.repository.AuctionRepository;
import com.biddingsystem.service.AuctionService;

@Service
public class AuctionServiceImpl implements AuctionService {

	@Autowired
	AuctionRepository auctionRepository;

	@Override
	public Auction getByid(Long id) throws Exception {
		return auctionRepository.findById(id).get();
	}

	@Override
	public Auction addNewAuction(Auction auction) throws Exception {
		auction.setUser(new HashSet<>());
		return auctionRepository.save(auction);
	}

	@Override
	public void updateAuction(Long id, Auction auction) throws Exception {
		Auction a = auctionRepository.findById(id).get();
		if (a != null) {
			a.setUser(auction.getUser());
			a.setProduct(auction.getProduct());
			auctionRepository.save(a);
		}
	}

	@Override
	public void deleteAuction(Long id) throws Exception {
		auctionRepository.deleteById(id);
	}

	@Override
	public Auction getByProduct(Product product) throws Exception {
		Auction u = auctionRepository.findByProduct(product);
		if (u != null)
			return u;
		throw new RuntimeException("No such auction exists for product ->" + product);
	}

	@Override
	public List<Auction> getAllAuctionList() throws Exception {
		return auctionRepository.findAll();
	}

}
