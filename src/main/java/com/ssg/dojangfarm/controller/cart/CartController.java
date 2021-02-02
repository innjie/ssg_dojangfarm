package com.ssg.dojangfarm.controller.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssg.dojangfarm.domain.Normal;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
public class CartController {
	@Autowired
	private FarmFacade farm;
	public void setFarm(FarmFacade farm) {
		this.farm = farm;
	}
	
	public String AddItemToCart(@RequestParam("saleNo") int saleNo) {
		 Normal normal = this.farm.getNormalSale( saleNo) ;
		 
		 //addItem(normal);
		 
		 //용도가 뭔가요
//		public int incrementQuantityBySaleNo(int saleNo) {
//			int quantity = 0;
//			return quantity;
//		}
		 return null;
	}
	public String removeItemByNo() {
		return null;
	}
	public String updateCartItem(@RequestParam("saleNo") int saleNo) {
		Normal normal = this.farm.getNormalSale(saleNo);
		//setQuantyBySaleNo(saleNo, quantity);
		return null;
	}
	
	public String viewCartItems() {
		return null;
	}
}
