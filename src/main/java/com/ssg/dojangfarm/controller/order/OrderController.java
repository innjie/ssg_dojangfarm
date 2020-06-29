package com.ssg.dojangfarm.controller.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.Delivery;
import com.ssg.dojangfarm.domain.Normal;
import com.ssg.dojangfarm.domain.Order;
import com.ssg.dojangfarm.domain.Refund;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;
import com.ssg.dojangfarm.service.OrderService;
import com.ssg.dojangfarm.service.RefundService;

@SessionAttributes("orderList")
@Controller
public class OrderController {
	private static final String orderView = "order/OrderView";
	private static final String orderListView = "order/OrderListView";
	private static final String orderListUserView = "order/OrderUserView";
	private static final String refundForm = "refund/RefundFormView";
	private static final String refundListView = "refund/RefundListView";
	private static final String refundView = "refund/RefundView";
	@Autowired
	private FarmFacade farm;
	public void setFarm(FarmFacade farm) {
		this.farm = farm;
	}
	//refund sale form
	@RequestMapping(value = "/order/cancel.do", method = RequestMethod.GET)
	public String cancelOrder(HttpServletRequest request, 
			@ModelAttribute("refundCommand") RefundCommand refundCommand,
			ModelMap model, @RequestParam("orderNo") int orderNo) throws Exception {
		Order order = this.farm.getOrder(orderNo);
		refundCommand.setOrder(order);
		model.addAttribute("refundCommand", refundCommand);
		
		return refundForm;
	}
	//refund sale
	@Transactional
	@RequestMapping(value = "/order/cancel.do", method = RequestMethod.POST)
	public ModelAndView cancelOrder(
			@Valid@ModelAttribute("refundCommand") RefundCommand refundCommand,
			HttpServletRequest request, BindingResult result, ModelMap model) {
		
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("user");
		
		//insert refund
		Refund refund = new Refund();
		
		Order order = new Order();
		order.setOrderNo(refundCommand.getOrder().getOrderNo());
		refund.setAccount(refundCommand.getAccount().toString());
		refund.setBank(refundCommand.getBank());
		refund.setName(refundCommand.getName());
		refund.setRefundType(refundCommand.getRefundType());
		refund.setOrder(order);
		refund.setUser(user);
		
		int refundRes = this.farm.refundSale(refund);
		int orderRes = this.farm.cancelOrder(refundCommand.getOrder().getOrderNo());
		
		order = this.farm.getOrder(refundCommand.getOrder().getOrderNo());
		//insert point
		Normal normal = this.farm.getNormalSale(order.getSaleNo());
		int point = normal.getPrice();
		user.setPoint(point);
		
		this.farm.addPoint(user);
				
		if( orderRes == 0 || refundRes == 0)  {//failed
			return new ModelAndView("Error", "message", "cancel failed");
		} else { //success 
			return new ModelAndView(orderListView);
		}
		
	}

	//view Order
	@RequestMapping("/order/view.do")
	public String orderView(@RequestParam("orderNo") int orderNo, Model model,
			HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession();
		User loginUser = (User) httpSession.getAttribute("user");
		
		Order order = this.farm.getOrder(orderNo);
		System.out.println(order.getOrderNo());
		model.addAttribute("order", order);
		model.addAttribute("loginUser", loginUser);
		
		return orderView;
		
	}
	//ViewOrderList
	@RequestMapping("/order/list.do")
	public String orderListByUserNo(HttpServletRequest request, ModelMap model) {
		//get list
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		
		PagedListHolder<Order> orderList = new PagedListHolder<Order>(this.farm.getOrderList(user.getUserNo()));
		model.put("orderList", orderList);
		return orderListView;
	}
	@RequestMapping("/order/list2.do")
	public String orderListByUserNo(@RequestParam("page") String page,
			@ModelAttribute("orderList") PagedListHolder<Order> orderList, ModelMap model) {
		if ("next".equals(page)) {
			orderList.nextPage();
		}
		else if ("previous".equals(page)) {
			orderList.previousPage();
		}
		model.put("orderList", orderList);
		return orderListView;
	}
	//viewOrderUserList
	@RequestMapping("/order/userView.do")
	public String orderListBysaleNo(@RequestParam("saleNo") int saleNo, ModelMap model) {
		//get list
		PagedListHolder<Order> orderList = new PagedListHolder<Order>( this.farm.getOrderUserList(saleNo));
		
		model.put("orderList", orderList);
		return orderListUserView;
	}
	@RequestMapping("/order/userView2.do")
	public String orderListBysaleNo(@RequestParam("page") String page, 
			@ModelAttribute("dList") PagedListHolder<Order> orderList,
			ModelMap model) {
		//get list
		if ("next".equals(page)) { 
			orderList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			orderList.previousPage(); 
		}
		return orderListUserView;
	}
	//view refund list
	@RequestMapping("/refund/list.do")
	public String getRefundList(HttpServletRequest request, Model model) {
		//get list
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		
		PagedListHolder<Refund> refundList = new PagedListHolder<Refund>(this.farm.getRefundList(user.getUserNo()));
		model.addAttribute("refundList", refundList);
		return refundListView;
	}
	@RequestMapping("/refund/list2.do")
	public String getRefundList(@RequestParam("page") String page,
			@ModelAttribute("refundList") PagedListHolder<Refund> refundList,
			BindingResult result, 
			 ModelMap model) {
		//get list
		if ("next".equals(page)) {
			refundList.nextPage();
		}
		else if ("previous".equals(page)) {
			refundList.previousPage();
		}
		model.addAttribute("refundList", refundList);
		return refundListView;
	}
	
	//view refund
	@RequestMapping("/refund/view.do")
	public String getRefund(@RequestParam("refundNo") int refundNo, Model model) {
		Refund refund = this.farm.getRefund(refundNo);
		Order order = this.farm.getOrder(refund.getOrder().getOrderNo());
		
		if(order.getSaleType().equals("Normal")) {
			Normal normal = this.farm.getNormalSale(order.getSaleNo());
			order.setTitle(normal.getTitle());
			order.setPrice(normal.getPrice() * order.getQuantity());
		} else if(order.getSaleType().equals("Common")) {
			Common common = this.farm.getCommonSale(order.getSaleNo());
			order.setTitle(common.getTitle());
			order.setPrice(common.getPrice() * order.getQuantity());
		}
		
		refund.setOrder(order);
		
		model.addAttribute("refund", refund);
		return refundView;
	}
}
