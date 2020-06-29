package com.ssg.dojangfarm.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssg.dojangfarm.domain.Address;

@Component
@WebService(serviceName="AddressService")
public class AddressServiceEndpoint {
	@Autowired
	AddressService addressService; // inject addressSeviceImpl

	@WebMethod
	public Address getAddress(int addrNo) {
		return addressService.getAddress(addrNo);
	}
	@WebMethod
	public void createAddress(Address address) {
		addressService.createAddress(address);
	}

	@WebMethod
	public void modifyAddress(Address address) {
		addressService.modifyAddress(address);
	}

	@WebMethod
	public void deletAddress(int addrNo) {
		addressService.deletAddress(addrNo);
	}
	
	@WebMethod
	public List<Address> getAddressList(int userNo) {
		return addressService.getAddressList(userNo);
	}

}
