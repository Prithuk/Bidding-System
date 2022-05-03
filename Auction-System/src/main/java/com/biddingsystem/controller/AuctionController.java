package com.biddingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biddingsystem.model.Auction;
import com.biddingsystem.service.AuctionService;

@RestController
@RequestMapping("/api/v1/auction")
public class AuctionController {

	@Autowired
	AuctionService auctionService;

	@GetMapping("/findAll")
	public ResponseEntity<List<Auction>> getAllUser() throws Exception {
		List<Auction> auctionList = auctionService.getAllAuctionList();
		return new ResponseEntity<>(auctionList, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Auction> createAuction(@RequestBody Auction auction) throws Exception {
		return new ResponseEntity<>(auctionService.addNewAuction(auction), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Auction> updateAuction(@PathVariable("id") Long id, @RequestBody Auction auction)
			throws Exception {
		auctionService.updateAuction(id, auction);
		return new ResponseEntity<>(auctionService.getByid(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Auction> deleteAuction(@PathVariable("id") Long id) throws Exception {
		auctionService.deleteAuction(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
