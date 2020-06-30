package com.ssg.dojangfarm.controller.common;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.controller.commonnotice.CommonNoticeCommand;
import com.ssg.dojangfarm.controller.normal.PaymentCommand;
import com.ssg.dojangfarm.domain.Address;
import com.ssg.dojangfarm.domain.Card;
import com.ssg.dojangfarm.domain.Category;
import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.CommonJoin;
import com.ssg.dojangfarm.domain.CommonNotice;
import com.ssg.dojangfarm.domain.Delivery;
import com.ssg.dojangfarm.domain.Normal;
import com.ssg.dojangfarm.domain.Order;
import com.ssg.dojangfarm.domain.Payment;
import com.ssg.dojangfarm.domain.Product;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
@SessionAttributes({"commonList", "cjList"})
public class CommonController implements ServletContextAware{
	private static final String insertCommonForm = "common/CommonInsertFormView";
	private static final String errorPage = "common/Error";
	private static final String successPage = "common/Success";
	private static final String commonListView = "common/CommonListView";
	private static final String commonUserListView = "common/CommonUserListView";
	private static final String commonView = "common/CommonView";
	private static final String updateCommonForm = "common/CommonUpdateFormView";
	//-----commonjoin-----
	private static final String insertCJForm = "commonjoin/CommonJoinFormView";
	private static final String updateCJForm = "commonjoin/JoinUpdateView";
	private static final String commonJoinUserListView = "commonjoin/JoinUserListView";
	private static final String commonJoinView = "commonjoin/CommonJoinView";
	private static final String commonJoinedListView = "commonjoin/ListBySaleView";
	private static final String buyCommonForm = "common/buyCommonFormView";
	private static final String deliveryView = "normal/DeliveryView";
	
	@Autowired
	private FarmFacade farm;
	public void setFarm(FarmFacade farm) {
		this.farm = farm;
	}


	private ServletContext context;	
	
	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
	
	@ModelAttribute("commonCommand")
	public CommonCommand formBacking(HttpServletRequest request) {
		Common common = null;
		int saleNo = 0;
		if(request.getParameter("saleNo") != null) {
			saleNo = Integer.parseInt(request.getParameter("saleNo"));
			common = this.farm.getCommonSale(saleNo);
		}
		
		// edit CommonNotice
		if (common != null) {	
			CommonCommand command = new CommonCommand();
			command.setTitle(common.getTitle());
			command.setPrice(common.getPrice());
			command.setInfo(common.getInfo());
			command.setMin(common.getMin());
			command.setDeadline(common.getDeadline());
			command.setSaleNo(saleNo);
			
			return command;
		}
		else {
			return new CommonCommand();
		}
	}
	
	
	@ModelAttribute("cjCommand")
	public CommonJoinCommand formBacking2(HttpServletRequest request) {
		CommonJoin commonJoin = null;
		int cjNo = 0;
		
		if(request.getParameter("cjNo") != null) {
			cjNo = Integer.parseInt(request.getParameter("cjNo"));
			commonJoin = this.farm.getCommonJoin(cjNo);
		}
		
		// edit CommonNotice
		if (commonJoin != null) {	
			CommonJoinCommand command = new CommonJoinCommand();
			command.setCount(commonJoin.getCount());
			command.setCommon(commonJoin.getCommon());
			command.setCjNo(cjNo);
			
			return command;
		}
		else {
			return new CommonJoinCommand();
		}
		
	}
	
	
	@ModelAttribute("payment")
	public PaymentCommand formBacking3(HttpServletRequest request) {
		return new PaymentCommand();
	}
	
	
	// insert form
	@RequestMapping(value = "/common/insertCommon.do", method = RequestMethod.GET)
	public String insertCommonForm(
			HttpServletRequest request, 
			@ModelAttribute("commonCommand") CommonCommand commonCommand, 
			ModelMap model) throws Exception {
		List<Product> pList = this.farm.getProductList();
		model.addAttribute("product", pList);

		return insertCommonForm;
	}

	// insert common
	@RequestMapping(value = "/common/insertCommon.do", method = RequestMethod.POST)
	public ModelAndView insertCommon(
			@Valid @ModelAttribute("commonCommand") CommonCommand commonCommand,
			BindingResult result,  HttpServletRequest request, ModelMap model) throws Exception {
		//get session-> user id
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("user");
		
		//validate
		if(user == null) {
			return new ModelAndView(errorPage, "message", "Pleas LOGIN first");
		}
		System.out.println(user.getUserNo());
	
		if(result.hasErrors() ) {
			List<Product> pList = this.farm.getProductList();
			model.addAttribute("product", pList);
			return new ModelAndView(insertCommonForm);
		}
		
		//insert common
		Common common = new Common();
		common.setUser(user);
		
		common.setPrice(commonCommand.getPrice());
		common.setTitle(commonCommand.getTitle());
		common.setSaleType("Common");
		common.setSaleState("OPEN");
		common.setState("0");
		common.setInfo(commonCommand.getInfo());
		java.util.Date utilDate = commonCommand.getDeadline();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		common.setDeadline(sqlDate);
		common.setMin(commonCommand.getMin());
		
		MultipartFile image = commonCommand.getImage();
		
		if(image != null) {
			uploadFile(image, common);
		} else {
			this.farm.insertCommon(common);
		}
	
		return new ModelAndView("redirect:/common/list.do");
	}

	// search common
	@RequestMapping("/common/searchCommon.do")
	public ModelAndView searchCommon(HttpServletRequest request,
			@RequestParam(value = "word", required = false) String word) throws Exception {
		// search action
		PagedListHolder<Common> commonList = null;
		
		if (word != null) {
			if (!StringUtils.hasLength(word)) {
				return new ModelAndView(errorPage, "message", "enter keword");
			}
			commonList = new PagedListHolder<Common> (this.farm.searchCommon(word.toLowerCase()));
		}
		commonList.setPageSize(10);
		// search -> list
		return new ModelAndView(commonListView, "commonList", commonList);
	}
	@RequestMapping("/common/searchCommon2.do")
	public String searchNormal2(@RequestParam("page") String page,
			@ModelAttribute("commonList") PagedListHolder<Common> commonList,
			BindingResult result, ModelMap model) throws Exception {
		if (commonList== null) {
			throw new IllegalStateException("Cannot find pre-loaded auction list");
		}
		if ("next".equals(page)) { 
			commonList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			commonList.previousPage(); 
		}
		model.put("search", "search");
		return commonListView;
	}
	// update common Form
	@RequestMapping(value = "/common/updateCommon.do", method = RequestMethod.GET)
	public String updateCommon(
			@ModelAttribute("commonCommand") CommonCommand commonCommand,
			@RequestParam("saleNo") int saleNo, 
			ModelMap model) throws Exception {
		Common common = this.farm.getCommonSale(saleNo);
		model.addAttribute(common);
		
		return updateCommonForm;
	}
	
	//update Common
	@RequestMapping(value = "/common/updateCommon.do", method = RequestMethod.POST)
	public ModelAndView updateCommon(
			@Valid@ModelAttribute("commonCommand") CommonCommand commonCommand,
			BindingResult result, HttpServletRequest request, ModelMap model) {
		//get user session
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		
		//validate
		if(user == null) {
			return new ModelAndView(errorPage, "message", "Please LOGIN first");
		}
		if(result.hasErrors()) {
			return new ModelAndView(updateCommonForm);
		}
		
		Common common = new Common();
		common.setTitle(commonCommand.getTitle());
		common.setPrice(commonCommand.getPrice());
		common.setInfo(commonCommand.getInfo());
		common.setMin(commonCommand.getMin());
		common.setDeadline(commonCommand.getDeadline());
		
		common.setSaleNo(commonCommand.getSaleNo());
		common.setSaleState("OPEN");
		int res = farm.updateCommon(common);
		if(res == 0) {
			return new ModelAndView(errorPage, "message", "update Failed");
		} else {
			return new ModelAndView(successPage, "message", "update success");
		}
	}

	// common list
	@RequestMapping("/common/list.do")
	public String getCommonList(ModelMap model) {
		// get list.do
		PagedListHolder<Common> commonList = new PagedListHolder<Common>(farm.getAllCommonList());
		
		commonList.setPageSize(10);
		model.put("commonList", commonList);
		return commonListView;
	}
	
	@RequestMapping("/common/list2.do")
	public String getCommonList2(
			@RequestParam("page") String page,
			@ModelAttribute("commonList") PagedListHolder<Common> commonList,
			BindingResult result, ModelMap model) {
		
		if ("next".equals(page)) { 
			commonList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			commonList.previousPage(); 
		}
		
		return commonListView;
	}
	
	//get user CommonList
	@RequestMapping("/common/userList.do")
	public String getCommonListByUserNo(HttpServletRequest request, Model model) {
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("user");
		int userNo = user.getUserNo();
		
		//get list
		PagedListHolder<Common> commonList = new PagedListHolder<Common>(farm.getCommonListByUserNo(userNo));
		commonList.setPageSize(10);
		model.addAttribute("commonList", commonList);
		return commonUserListView;
	}
	//get user CommonList
		@RequestMapping("/common/userList2.do")
		public String getCommonListByUserNo2(
				@RequestParam("page") String page,
				@ModelAttribute("commonList") PagedListHolder<Common> commonList,
				BindingResult result,
				HttpServletRequest request, Model model) {
			if ("next".equals(page)) { 
				commonList.nextPage(); 
			}
			else if ("previous".equals(page)) { 
				commonList.previousPage(); 
			}
			
			return commonUserListView;
		}
	//get commonView
	@RequestMapping("/common/viewCommon.do")
	public String getCommon(@RequestParam("saleNo") int saleNo, ModelMap model,
			HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession();
		User loginUser = (User) httpSession.getAttribute("user");

		Common common = this.farm.getCommonSale(saleNo);
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("common", common);
		
		return commonView;
	}
	
	//--------------------- common join ---------------------
	
	
	//commonJoin user List
	@RequestMapping("/commonJoin/userList.do")
	public String getCommonJoinUserList(HttpServletRequest request, ModelMap model) {
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		int userNo = user.getUserNo();
		
		PagedListHolder<CommonJoin> cjList = new PagedListHolder<CommonJoin>(this.farm.getCommonJoinListByUserNo(userNo));
		cjList.setPageSize(10);
		model.put("cjList", cjList);
		return commonJoinUserListView;
	}
	@RequestMapping("/commonJoin/userList2.do")
	public String getCommonJoinUserList2(
			@RequestParam("page") String page,
			@ModelAttribute("cjList") PagedListHolder<CommonJoin> cjList,
			BindingResult result,
			HttpServletRequest request, ModelMap model) {
		if ("next".equals(page)) {
			cjList.nextPage();
		}
		else if ("previous".equals(page)) {
			cjList.previousPage();
		}
		
		return commonJoinUserListView;
	}
	//commonJoin list by saleNo
	@RequestMapping("/commonJoin/viewList.do")
	public String getCommonJonListBySaleNo(@RequestParam("saleNo") int saleNo, ModelMap model) {
		
		PagedListHolder<CommonJoin> cjList = new PagedListHolder<CommonJoin>(this.farm.getCommonJoinListBySaleNo(saleNo));
		cjList.setPageSize(10);
		model.put("cjList", cjList);
		return commonJoinedListView;
	}
	@RequestMapping("/commonJoin/viewList2.do")
	public String getCommonJonListBySaleNo(@RequestParam("saleNo") int saleNo, 
			@RequestParam("page") String page,
			@ModelAttribute("cjList") PagedListHolder<CommonJoin> cjList,
			BindingResult result, 
			 ModelMap model) {
	
		if ("next".equals(page)) {
			cjList.nextPage();
		}
		else if ("previous".equals(page)) {
			cjList.previousPage();
		}
		
		return commonJoinedListView;
	}
	//insert CommonJoin Form
	@RequestMapping(value = "/commonjoin/join.do", method = RequestMethod.GET)
	public String insertCommonJoin(@RequestParam int saleNo, HttpServletRequest request,
			@ModelAttribute("cjCommand") CommonJoinCommand cjCommand, 
			ModelMap model) throws Exception {
		Common common = this.farm.getCommonSale(saleNo);
		model.addAttribute(common);
		
		return insertCJForm;
	}
	// insert CommonJoin
	@Transactional
	@RequestMapping(value = "/commonjoin/join.do", method = RequestMethod.POST)
	public ModelAndView insertCommonJoin(HttpServletRequest request,
			@Valid @ModelAttribute("cjCommand") CommonJoinCommand cjCommand, 
			BindingResult result,
			BindingResult bindingResult,
			ModelMap model) {
		// insert join actioin
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("user");
		Common common = this.farm.getCommonSale(cjCommand.getCommon().getSaleNo());
		System.out.println("count"+cjCommand.getCount());
		//validate
		if(user == null) {
			return new ModelAndView(errorPage, "message", "Please LOGIN first");
		}
		if(result.hasErrors()) {
			model.addAttribute("common", common);
			return new ModelAndView(insertCJForm);
		}
		
		
		//if already exist
		CommonJoin existJoin = this.farm.ExistCommonJoin(user.getUserNo(), common.getSaleNo());
		if(existJoin != null) {
			model.addAttribute("common", common);
			return new ModelAndView(commonView, "message", "already exist");
		}
		// card validation
		Card card = this.farm.getCard(cjCommand.getCardNo());
		if (card == null) {
			result.rejectValue("cardNo", "nocardNo");
			return new ModelAndView(insertCJForm, "cjCommand", cjCommand);
		}
		if (card.getUser().getUserNo() != user.getUserNo()) {
			result.rejectValue("cardNo", "notMyCard");
			return new ModelAndView(insertCJForm, "cjCommand", cjCommand);
		}
		// Address validation
		Address address = this.farm.getAddress(cjCommand.getAddrNo());
		if (address == null) {
			result.rejectValue("addrNo", "noaddressNo");
			return new ModelAndView(insertCJForm, "cjCommand", cjCommand);
		}
		if (address.getUser().getUserNo() != user.getUserNo()) {
			result.rejectValue("addrNo", "notMyAddress");
			return new ModelAndView(insertCJForm, "cjCommand", cjCommand);
		}
		
		Delivery delivery = new Delivery();
		delivery.setAddress(address);
		delivery.setPhone(cjCommand.getPhone());
		this.farm.addDelivery(delivery);
		
		int dNo = this.farm.getLastDNo();
		delivery = this.farm.getDelivery(dNo);
				
		//insert CommonJoin
		CommonJoin commonJoin = new CommonJoin();
		commonJoin.setUser(user);
		commonJoin.setCount(cjCommand.getCount());
		commonJoin.setDelivery(delivery);
		commonJoin.setCardNo(cjCommand.getCardNo());
		commonJoin.setCommon(common);
		
		
		
		this.farm.insertCommonjoin(commonJoin);
		int memberSize = this.farm.getCommonJoinListBySaleNo(cjCommand.getCommon().getSaleNo()).size();
		//common state change	
		if(memberSize == cjCommand.getCommon().getMin()) {
			common.setSaleState("OK");
			this.farm.updateCommon(common);
		}
		int cjNo = this.farm.getLastCJNo();
		return new ModelAndView("redirect:/commonJoin/view.do?cjNo=" + cjNo);
	}

	//update CommonJoin Form
	@RequestMapping(value = "/commonJoin/update.do", method = RequestMethod.GET)
	public String updateCommonJoin(
			@ModelAttribute("cjCommand") CommonJoinCommand cjCommand, 
			@RequestParam("cjNo") int cjNo, 
			ModelMap model) throws Exception {
		CommonJoin commonJoin = this.farm.getCommonJoin(cjNo);
		
		model.addAttribute(commonJoin);
		return updateCJForm;
	}
	// updateCommonJoin
	@RequestMapping(value = "/commonJoin/update.do", method = RequestMethod.POST)
	public ModelAndView updateCommonJoin(
		@Valid@ModelAttribute("cjCommand") CommonJoinCommand cjCommand, 
		BindingResult result) {
		System.out.println("p"+cjCommand.getPhone());
		if(cjCommand.getCount() < 1) {
			return new ModelAndView(updateCJForm);
		}
		
		CommonJoin commonJoin = new CommonJoin();
		commonJoin.setCjState("신청");
		commonJoin.setCjNo(cjCommand.getCjNo());
		commonJoin.setCount(cjCommand.getCount());
		
		farm.updateCommonjoin(commonJoin);
		
		

		return new ModelAndView("redirect:/commonJoin/userList.do");
	}

	// view CommonJoin
	@RequestMapping("/commonJoin/view.do")
	public String viewCommonJoin(@RequestParam("cjNo")  int cjNo, ModelMap model,
			HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession();
		User loginUser = (User) httpSession.getAttribute("user");
		
		CommonJoin commonJoin = this.farm.getCommonJoin(cjNo);
		Common common = this.farm.getCommonSale(commonJoin.getCommon().getSaleNo());
		commonJoin.setCommon(common);
		
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("commonJoin", commonJoin);
		return commonJoinView;
	}

	// cancel CommonJoin
	@RequestMapping("/commonJoin/cancel.do")
	public ModelAndView cancelCommonJoin(@RequestParam("cjNo") int CJNo) {
		// cancel action
		this.farm.cancelCommonjoin(CJNo);

		return new ModelAndView("redirect:/" + commonJoinedListView);
	}
	@RequestMapping(value = "/common/buyCommon.do", method = RequestMethod.GET)
	public String buyCommon(@RequestParam("saleNo") int saleNo, @RequestParam("cjNo") int cjNo,
			@ModelAttribute("payment")PaymentCommand paymentCommand, ModelMap model) {
		CommonJoin commonJoin = this.farm.getCommonJoin(cjNo);
		Common common = this.farm.getCommonSale(saleNo);
		model.addAttribute("common", common);
		model.addAttribute("commonJoin", commonJoin);
		return buyCommonForm;
	}
	
	@RequestMapping("/common/payCommon.do")
	public ModelAndView buyCommon(@RequestParam("saleNo") int saleNo,
			HttpServletRequest request, ModelMap model) throws Exception {
		//get Common
		Common common = this.farm.getCommonSale(saleNo);
		//get joined user list
		List<CommonJoin> cjUserList = this.farm.getCommonJoinListBySaleNo(saleNo);
		
		//for -> payment
		for(int i = 0; i < cjUserList.size(); i++) {
			int cjNo = cjUserList.get(i).getCjNo();
			CommonJoin commonJoin = this.farm.getCommonJoin(cjNo);
			User user = this.farm.getUser(commonJoin.getUser().getUserNo());
		
			Delivery delivery = this.farm.getDelivery(commonJoin.getDelivery().getdNo());
			System.out.println(delivery.getdNo());
			Card card = this.farm.getCard(commonJoin.getCardNo());
			
			Payment payment = new Payment();
			payment.setCard(card);
			payment.setTotalPrice(commonJoin.getCount()* common.getPrice());
			payment.setMethod("카드");
			// insert normal Payment
			this.farm.insertPayment(payment);
			
			//insert order
			Order order = new Order();
			
			order.setDelivery(delivery);
			order.setPayment(payment);
			order.setQuantity(commonJoin.getCount());
			order.setSaleNo(commonJoin.getCommon().getSaleNo());
			order.setUser(user);
			order.setSaleType("Common");
			
			this.farm.insertOrder(order);
			
			commonJoin.setCjState("결제완료");
			
			this.farm.updateCommonjoin(commonJoin);
		}
		common.setSaleState("CLOSE");
		this.farm.updateCommon(common);
		return new ModelAndView("redirect:/user/myPage.do");
	}
	@RequestMapping("/common/viewDelivery.do")
	public String deliveryView(@RequestParam("orderNo") int orderNo, ModelMap model) {
		//get order
		Order order = this.farm.getOrder(orderNo);
		//get Delivery
		Delivery delivery = this.farm.getDelivery(order.getDelivery().getdNo());
		//get payment
		Payment payment = this.farm.getPayment(order.getPayment().getPayNo());
		//get Normal
		Common  common = this.farm.getCommonSale(order.getSaleNo());
		//get Address
		Address address = this.farm.getAddress(delivery.getAddress().getAddrNo());
		delivery.setAddress(address);
		
		model.addAttribute("order", order);
		model.addAttribute("delivery", delivery);
		model.addAttribute("payment", payment);
		model.addAttribute("common", common);
		
		return deliveryView;
	}
	//upload file
		private void uploadFile(MultipartFile image, Common common) {
			this.farm.insertCommon(common);
			
			int saleNo = this.farm.getLastCommonSaleNo();
			String path = context.getRealPath("/images/common");
			File file = new File(path, saleNo + ".jpg");
			
			try {
				image.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.farm.addCommonImage(saleNo, "images/common/" + file.getName());
		}
}
