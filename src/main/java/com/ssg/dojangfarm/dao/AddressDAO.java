package com.ssg.dojangfarm.dao;

import java.util.List;

import com.ssg.dojangfarm.domain.Address;

public interface AddressDAO {
	public Address getAddress(int addrNo);
	public void createAddress(Address address);
	public void modifyAddress(int addrNo, String addr, int zip, String detail);
	public void deletAddress(int addrNo);
	public List<Address> getAddressList(int userNo);

}
