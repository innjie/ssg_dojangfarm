package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.Address;

public interface AddressService {
	public Address getAddress(int addrNo);
	public void createAddress(Address address);
	public void modifyAddress(Address address);
	public void deletAddress(int addrNo);
	public List<Address> getAddressList(int userNo);
}
