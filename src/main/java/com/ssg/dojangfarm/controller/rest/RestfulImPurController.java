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

import com.ssg.dojangfarm.domain.ImPur;
import com.ssg.dojangfarm.service.AuctionService;

@Controller
public class RestfulImPurController {
	private AuctionService auctionService;

	@Autowired
	public void setFarmSvc(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
	
	@RequestMapping(value = "/imPurBy/{imPurNo}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody         
	public ImPur getSBid(@PathVariable("imPurNo") int imPurNo, HttpServletResponse response) throws IOException {
		System.out.println("/rest/imPurBy/{imPurNo} request accepted: {imPurNo} = " + imPurNo);
		ImPur imPur = auctionService.getMyImPur(imPurNo);
		if (imPur == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return imPur;   // convert order to JSON text in response body
	}
	
	@RequestMapping(value = "/imPurListBy/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody         
	public List<ImPur> getSBidListByUser(@PathVariable("id") String id, HttpServletResponse response) throws IOException {
		System.out.println("/rest/imPurListBy/{id} request accepted: {id} = " + id);
		List<ImPur> imPurList = auctionService.getMyImPurList(id);
		if (imPurList == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return imPurList;  // convert list of orders to JSON text in response body
	}
	
	
}
