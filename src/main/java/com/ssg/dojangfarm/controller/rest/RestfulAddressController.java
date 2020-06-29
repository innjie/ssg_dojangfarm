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

import com.ssg.dojangfarm.domain.Address;
import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.service.AddressService;
import com.ssg.dojangfarm.service.AuctionService;

@Controller
public class RestfulAddressController {
	private AddressService addressService;

	@Autowired
	public void setFarmSvc(AddressService addressService) {
		this.addressService = addressService;
	}
	
	
	@RequestMapping(value = "/addressListBy/{userNo}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody         
	public List<Address> findAuctionByProduct(@PathVariable("userNo") int userNo, HttpServletResponse response) throws IOException {
		System.out.println("/rest/addressListBy/{userNo} request accepted: {userNo} = " + userNo);
		List<Address> addressList = addressService.getAddressList(userNo);
		if (addressList == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return addressList;  // convert list of orders to JSON text in response body
	}
	
}
