package com.ssg.dojangfarm.controller.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.service.AuctionService;

@Controller
public class RestfulAuctionController {
	private AuctionService auctionService;

	@Autowired
	public void setFarmSvc(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
	
	
	@RequestMapping(value = "/auctionBy/{aNo}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody         
	public Auction getAuction(@PathVariable("aNo") int aNo, HttpServletResponse response) throws IOException {
		System.out.println("/rest/auctionBy/{aNo} request accepted: {aNo} = " + aNo);
		Auction auction = auctionService.getAuction(aNo);
		if (auction == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return auction;   // convert order to JSON text in response body
	}
	
	@RequestMapping(value = "/auctionListBy/{userNo}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody         
	public List<Auction> getAuctionListByUser(@PathVariable("userNo") int userNo, HttpServletResponse response) throws IOException {
		System.out.println("/rest/auctionListBy/{userNo} request accepted: {userNo} = " + userNo);
		List<Auction> auctionList = auctionService.getMyAuctionList(userNo);
		if (auctionList == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return auctionList;  // convert list of orders to JSON text in response body
	}
}
