package com.ssg.dojangfarm.dao.mybatis.mapper;

import java.util.List;

import com.ssg.dojangfarm.domain.Delivery;

public interface DeliveryMapper {
	public Delivery getDelivery(int dNo);
	public void changeDeliveryStatus(int dNo);
	public void addDelivery(Delivery delivery);
	public List<Delivery> getDeliveryListByUserNo(int userNo);
	public int getLastDNo();
}
