package com.ssg.dojangfarm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.dojangfarm.dao.DeliveryDAO;
import com.ssg.dojangfarm.dao.mybatis.mapper.DeliveryMapper;
import com.ssg.dojangfarm.domain.Delivery;
@Repository
public class MybatisDeliveryDAO implements DeliveryDAO{
	@Autowired
	private DeliveryMapper deliveryMapper;
	
	@Override
	public Delivery getDelivery(int dNo) {
		return deliveryMapper.getDelivery(dNo);
	}
	@Override
	public void changeDeliveryStatus(int dNo) {
		deliveryMapper.changeDeliveryStatus(dNo);
	}
	@Override
	public void addDelivery(Delivery delivery) {
		deliveryMapper.addDelivery(delivery);
	}
	@Override
	public List<Delivery> getDeliveryListByUserNo(int userNo) {
		return deliveryMapper.getDeliveryListByUserNo(userNo);
	}
	@Override
	public int getLastDNo() {
		return deliveryMapper.getLastDNo();
	}
	
}
