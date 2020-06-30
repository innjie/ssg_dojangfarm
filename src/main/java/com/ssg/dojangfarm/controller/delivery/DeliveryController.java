package com.ssg.dojangfarm.controller.delivery;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ssg.dojangfarm.domain.Delivery;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;
@SessionAttributes("dList")
@Controller
public class DeliveryController {
	private static final String deliveryListView = "delivery/deliveryList";
	private static final String deliveryView = "delivery/deliveryView";
	@Autowired
	private FarmFacade farm;
	public void setFarm(FarmFacade farm) {
		this.farm = farm;
	}
	
	@RequestMapping("/delivery/turnStatus.do")
	public String changeDeliveryStatus(@RequestParam("dNo")int dNo, 
			@RequestParam("status") String status,
			HttpServletRequest request) {
		System.out.println(status);
		if (status.equals("배송전")) {
			this.farm.changeDeliveryStatus(dNo);
		} else if (status.equals("배송중")) {
			this.farm.changeDeliveryFinish(dNo);
		}
		 
		
		 return "redirect:/delivery/list.do";
		
	}
	@RequestMapping("/delivery/view.do")
	public String getDelivery(@RequestParam("dNo") int dNo, ModelMap model,
			HttpServletRequest request) {
		Delivery delivery = this.farm.getDelivery(dNo);
		
		model.addAttribute("delivery", delivery);
		return deliveryView;
	}
	@RequestMapping("/delivery/list.do")
	public String getDeliveryListByUserNo(HttpServletRequest request,
			ModelMap model) {
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("user");
		int userNo = user.getUserNo();
		System.out.println(userNo);
		List<Delivery> deliveryList =  null;
		deliveryList = this.farm.getDeliveryListByUserNo(userNo);
		System.out.println(deliveryList.size());
		
		PagedListHolder<Delivery> dList = new PagedListHolder<Delivery>(this.farm.getDeliveryListByUserNo(userNo));
		model.put("dList", dList);
		return deliveryListView;
	}
	@RequestMapping("/delivery/list2.do")
	public String getDeliveryListByUserNo2(@RequestParam("page") String page, 
			@ModelAttribute("dList") PagedListHolder<Delivery> dList,
			ModelMap model) {
		if ("next".equals(page)) { 
			dList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			dList.previousPage(); 
		}
		
		return deliveryListView;
	}

}
