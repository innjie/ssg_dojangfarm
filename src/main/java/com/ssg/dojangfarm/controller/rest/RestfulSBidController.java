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

import com.ssg.dojangfarm.domain.SBid;
import com.ssg.dojangfarm.service.AuctionService;


@Controller
public class RestfulSBidController {
	private AuctionService auctionService;

	@Autowired
	public void setFarmSvc(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
	
	@RequestMapping(value = "/sBidBy/{sBidNo}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody         
	public SBid getSBid(@PathVariable("sBidNo") int sBidNo, HttpServletResponse response) throws IOException {
		System.out.println("/rest/sBidBy/{sBidNo} request accepted: {sBidNo} = " + sBidNo);
		SBid sBid = auctionService.getMySBid(sBidNo);
		if (sBid == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return sBid;   // convert order to JSON text in response body
	}
	
	@RequestMapping(value = "/sBidListBy/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody         
	public List<SBid> getSBidListByUser(@PathVariable("id") String id, HttpServletResponse response) throws IOException {
		System.out.println("/rest/sBidListBy/{id} request accepted: {id} = " + id);
		List<SBid> sBidList = auctionService.getMySBidList(id);
		if (sBidList == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return sBidList;  // convert list of orders to JSON text in response body
	}
}
