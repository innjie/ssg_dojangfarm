package com.ssg.dojangfarm.controller.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Order;
import com.ssg.dojangfarm.domain.Refund;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;
import com.ssg.dojangfarm.service.OrderService;
import com.ssg.dojangfarm.service.RefundService;

@Controller
public class OrderController {
	private static final String orderView = "order/OrderView";
	private static final String orderListView = "order/OrderListView";
	private static final String orderListUserView = "order/OrderUserView";
	private static final String refundForm = "refund/RefundFormView";
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
	public ModelAndView cancelOrder(@Valid@ModelAttribute("refundCommand") RefundCommand refundCommand,
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
		//cancel action
		//int orderRes = this.farm.cancelOrder(refundCommand.getOrder().getOrderNo());
				
		if( refundRes == 0)  {//failed
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
	public String orderListByUserNo(HttpServletRequest request, Model model) {
		//get list
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		
		List<Order> orderList = this.farm.getOrderList(user.getUserNo());
		model.addAttribute("orderList", orderList);
		return orderListView;
	}
	
	//viewOrderUserList
	@RequestMapping("/order/userView.do")
	public String orderListBysaleNo(@RequestParam("saleNo") int saleNo, Model model) {
		//get list
		List<Order> orderUserList = this.farm.getOrderUserList(saleNo);
		
		model.addAttribute("orderUserList", orderUserList);
		return orderListUserView;
	}
	//view refund list
	@RequestMapping("/refund/list.do")
	public String getRefundList(HttpServletRequest request, Model model) {
		//get list
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		
		List<Refund> refundList = this.farm.getRefundList(user.getUserNo());
		model.addAttribute("refundList", refundList);
		return "refund/RefundListView";
	}
	//view refund
	@RequestMapping("/refund/view.do")
	public String getRefund(@RequestParam("refundNo") int refundNo, Model model) {
		Refund refund = this.farm.getRefund(refundNo);
		if(refund == null) {
			return "refund/RefundNotFound";
		}
		model.addAttribute("refund", refund);
		return "refund/RefundView";
	}
}
