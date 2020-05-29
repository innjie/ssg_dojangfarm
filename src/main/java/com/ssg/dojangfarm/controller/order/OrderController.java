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
import com.ssg.dojangfarm.service.OrderService;

@Controller
public class OrderController {
	private OrderService orderService;
	
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//cancelOrder
	@RequestMapping("/order/cancel")
	public ModelAndView cancelOrder(@PathVariable int orderNo, BindingResult result) {
		//cancel action
		int res = orderService.CancelOrder(orderNo);
		
		if(res == 0)  {//failed
			return new ModelAndView("Error", "message", "cancel failed");
		} else { //success
			return new ModelAndView("Success", "message", "cancel success");
		}
	}
	//insertOrder
	@RequestMapping("/order/insert")
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
	@RequestMapping("/order/view")
	public String orderView(@PathVariable int orderNo, Model model) {
		Order order = orderService.getOrder(orderNo);
		
		if(order == null) {
			return "/order/orderNotFound";
		}
		model.addAttribute("order", order);
		return "order/OrderView";
	}
	//ViewOrderList
	@RequestMapping("/order/list")
	public String orderList(@RequestParam HttpServletRequest request, Model model) {
		//get list
		int userNo =(int) request.getAttribute("userNo");
		List<Order> orderList = orderService.getOrderList(userNo);
		model.addAttribute("orderList", orderList);
		return "order/orderListView";
	}
	//viewOrderUserList
	@RequestMapping("/order/userView")
	public String orderList(@PathVariable("orderNo") int orderNo, Model model) {
		//get list
		List<String> userNames = orderService.getUserList(orderNo);
		model.addAttribute("userNames", userNames);
		return "order/OrderUserView";
	}
}
