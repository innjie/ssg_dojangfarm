package com.ssg.dojangfarm.controller.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Order;
import com.ssg.dojangfarm.domain.Refund;
import com.ssg.dojangfarm.service.OrderService;
import com.ssg.dojangfarm.service.RefundService;

@Controller
public class OrderController {
	private OrderService orderService;
	private RefundService refundService;
  
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	@Autowired
	public void setRefundService(RefundService refundService) {
		this.refundService = refundService;
	}
	//refund sale
	//cancelOrder 의문있음
	@RequestMapping("/order/cancel.do")
	public ModelAndView cancelOrder(@PathVariable int orderNo, BindingResult result) {
		//cancel action
		int orderRes = orderService.cancelOrder(orderNo);
		
		if(orderRes == 0)  {//failed
			return new ModelAndView("Error", "message", "cancel failed");
		} else { //success 
			// ???
			return new ModelAndView("Success", "message", "cancel success");
		}
	}
	//insertOrder
	@RequestMapping("/order/insert.do")
	public ModelAndView insertOrder(
			@RequestParam HttpServletRequest request,
			@ModelAttribute("Order") Order order,
			BindingResult result) {
		//insert order action
		int userNo = (int)request.getAttribute("userNo");
		int res = orderService.insertOrder(userNo, order);
		
		if(res == 0) {//failed
			return new ModelAndView("Error", "message", "join Failed");
		} else { //success
			return new ModelAndView("Success", "message", "join success");
		}
	}
	//view Order
	@RequestMapping("/order/view.do")
	public String orderView(@PathVariable int orderNo, Model model) {
		Order order = orderService.getOrder(orderNo);
		
		if(order == null) {
			return "/order/orderNotFound";
		}
		model.addAttribute("order", order);
		return "order/OrderView";
	}
	//ViewOrderList
	@RequestMapping("/order/list.do")
	public String orderList(@RequestParam HttpServletRequest request, Model model) {
		//get list
		int userNo =(int) request.getAttribute("userNo");
		List<Order> orderList = orderService.getOrderList(userNo);
		model.addAttribute("orderList", orderList);
		return "order/orderListView";
	}
	//viewOrderUserList
	//command ??
	@RequestMapping("/order/userView.do")
	public String orderList(@PathVariable("orderNo") int orderNo, Model model) {
		//get list
		List<Order> orderUserList = orderService.getOrderUserList(orderNo);
		model.addAttribute("orderUserList", orderUserList);
		return "order/OrderUserView";
	}
	//view refund list
	@RequestMapping("/refund/list.do")
	public String getRefundList(@RequestParam HttpServletRequest request, Model model) {
		//get list
		int userNo = (int)request.getSession().getAttribute("userNo");
		List<Refund> refundList = refundService.getRefundList(userNo);
		model.addAttribute("refundList", refundList);
		return "refund/RefundListView";
	}
	//view refund
	@RequestMapping("/refund/view.do")
	public String getRefund(@PathVariable int refundNo, Model model) {
		Refund refund = refundService.getRefund(refundNo);
		if(refund == null) {
			return "refund/RefundNotFound";
		}
		model.addAttribute("refund", refund);
		return "refund/RefundView";
	}
}
