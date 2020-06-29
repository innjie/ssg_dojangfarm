package com.ssg.dojangfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.AddressDAO;
import com.ssg.dojangfarm.domain.Address;

@Service("AddressServiceImpl")
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDAO addressDAO;

	public Address getAddress(int addrNo) {
		return addressDAO.getAddress(addrNo);
	}

	public void createAddress(Address address) {
		addressDAO.createAddress(address);
	}

	public void modifyAddress(Address address) {
		addressDAO.modifyAddress(address);
	}

	public void deletAddress(int addrNo) {
		addressDAO.deletAddress(addrNo);
	}

	public List<Address> getAddressList(int userNo) {
		return addressDAO.getAddressList(userNo);
	}
}
