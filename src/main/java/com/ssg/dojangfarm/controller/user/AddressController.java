package com.ssg.dojangfarm.controller.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssg.dojangfarm.service.FarmFacade;

public class AddressController {
	private static final String LISTADDRESS= "address/AddressListView";
	private static final String VIEWADDRESS = "address/AddressView";
	private static final String ADDADDRESSFORM = "address/CreateAddressFormView";
	private static final String UPDATEADDRESSORM = "address/ModifyAddressFormView";
	
	private FarmFacade farm;
	
	@Autowired
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
	
	//view addressList
	//@RequestMapping("/address/getAddressList.do")

	//view address
	//@RequestMapping("/address/getAddress.do")

	//create address ... form
	//@RequestMapping(method="/address/createAddress.do", method=Request.GET)

	//create address ... insert
	//@RequestMapping(method="/address/createAddress.do", method=Request.POST)

	//update address ... form
	//@RequestMapping(method="/address/modifyAddress.do", method=Request.GET)

	//update address ... update
	//@RequestMapping(method="/address/modifyAddress.do", method=Request.POST)

	//delete address
	//@RequestMapping("/address/deleteAddress.do")

}
