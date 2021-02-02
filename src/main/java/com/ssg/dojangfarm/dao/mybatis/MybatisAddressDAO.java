package com.ssg.dojangfarm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.dojangfarm.dao.AddressDAO;
import com.ssg.dojangfarm.dao.mybatis.mapper.AddressMapper;
import com.ssg.dojangfarm.domain.Address;

@Repository
public class MybatisAddressDAO implements AddressDAO{
	@Autowired
	private AddressMapper addressMapper;
	
	public Address getAddress(int addrNo) {
		return addressMapper.getAddress(addrNo);
	}
	public void createAddress(Address address) {
		addressMapper.createAddress(address);
	}
	public void modifyAddress(Address address) {
		addressMapper.modifyAddress(address);
	}
	public void deletAddress(int addrNo) {
		addressMapper.deletAddress(addrNo);
	}
	public List<Address> getAddressList(int userNo) {
		return addressMapper.getAddressList(userNo);
	}
	public Address getAddrNo(Address address) {
		return addressMapper.getAddrNo(address);
	}
}
