package com.ssg.dojangfarm.controller.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@Autowired
	private FarmFacade farm;
	public void setFarm(FarmFacade farm) {
		this.farm = farm;
	}
	
	//refund sale
	@Transactional
	@RequestMapping("/order/cancel.do")
	public ModelAndView cancelOrder(@PathVariable int orderNo, BindingResult result) {
		//cancel action
		Order order = this.farm.getOrder(orderNo);
		int orderRes = this.farm.cancelOrder(orderNo);
		
		Refund refund = new Refund();
		refund.setOrder(order);
		
		int refundRes = this.farm.refundSale(refund);
		
		if(orderRes == 0 || refundRes == 0)  {//failed
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
