package com.ssg.dojangfarm.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssg.dojangfarm.domain.Address;

public interface AddressMapper {
	public Address getAddress(int addrNo);
	public void createAddress(Address address);
	public void modifyAddress(Address address);
	public void deletAddress(int addrNo);
	public List<Address> getAddressList(int userNo);

}
