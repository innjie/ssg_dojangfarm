package com.ssg.dojangfarm.controller.normal;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import com.ssg.dojangfarm.domain.Address;
import com.ssg.dojangfarm.domain.Card;
import com.ssg.dojangfarm.domain.Category;
import com.ssg.dojangfarm.domain.Delivery;
import com.ssg.dojangfarm.domain.Normal;
import com.ssg.dojangfarm.domain.Order;
import com.ssg.dojangfarm.domain.Payment;
import com.ssg.dojangfarm.domain.Product;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

//Normal Controller
@SessionAttributes({"normalList", "categoryList"})
@Controller
public class NormalController implements ServletContextAware {
	private static final String insertNormaForm = "normal/NormalInsertFormView";
	private static final String normalListView = "normal/NormalListView";
	private static final String errorPage = "/normal/Error";
	private static final String normalView = "normal/NormalView";
	private static final String normalUserListView = "normal/NormalUserListView";
	private static final String successPage = "/normal/Success";
	private static final String updateNormalForm = "normal/NormalUpdateFormView";
	private static final String buyNormalForm = "normal/buyNormalFormView";
	private static final String deliveryView = "normal/DeliveryView";
	
	private ServletContext context;	
	
	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
	
	@Autowired
	private FarmFacade farm;
	public void setFarm(FarmFacade farm) {
		this.farm = farm;
	}
	//Normal Command
	@ModelAttribute("normalCommand")
	public NormalCommand formBacking(HttpServletRequest request) {
		return new NormalCommand();
	}
	@ModelAttribute("payment")
	public PaymentCommand formBacking2(HttpServletRequest request) {
		return new PaymentCommand();
	}
	
	//insert form
	@RequestMapping(value = "/normal/insertNormal.do", method = RequestMethod.GET)
	public String insertNormal(HttpServletRequest request,
			 @ModelAttribute("normalCommand") NormalCommand normalCommand,
			 ModelMap model) throws Exception {
		List<Product> pList = this.farm.getProductList();
		model.addAttribute("product", pList);
		
		return insertNormaForm;
	}
	
	//insert normal
	@RequestMapping(value = "/normal/insertNormal.do", method = RequestMethod.POST)
	public ModelAndView insertNormal(
			@Valid@ModelAttribute("normalCommand") NormalCommand normalCommand,
			BindingResult result, HttpServletRequest request, ModelMap model) {
		//insert action
		//get session -> user id
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("user");
		
		//validate
		if(user == null) {
			return new ModelAndView(errorPage, "message", "Please LOGIN first");
		}
		
		if(result.hasErrors()) {
			System.out.println(result.getFieldError());
			System.out.println(result.getErrorCount());
			List<Product> pList = this.farm.getProductList();
			model.addAttribute("product", pList);
			return new ModelAndView(insertNormaForm);
		}
		
		//insert normal
		Normal normal = new Normal();
		normal.setUser(user);
		normal.setPrice(normalCommand.getPrice());
		normal.setTitle(normalCommand.getTitle());
		normal.setInfo(normalCommand.getInfo());
		normal.setSaleType("Normal");
		normal.setProduct(normalCommand.getProduct());
		normal.setSaleState("OPEN");
		normal.setCount(normalCommand.getCount());
		normal.setState("0");
		
		java.util.Date utilDate = normalCommand.getRegidDate();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		normal.setRegidDate(sqlDate);
		
		MultipartFile image = normalCommand.getImage();
		
		if(image != null) {
			System.out.println("image found");
			uploadFile(image, normal);
		} else {
			System.out.println("image not found");
			this.farm.insertSale(normal);
		}

		return new ModelAndView( "redirect:/normal/list.do");
	}
	
	//search normal
	@RequestMapping("/normal/searchNormal.do")
	public String searchNormal(HttpServletRequest request,
			@RequestParam(value="word", required = false) String word,
			ModelMap model) throws Exception {
		//search action
		PagedListHolder<Normal> normalList = null;
		if(word != null) {
			if(!StringUtils.hasLength(word)) {
				model.put("message", "enter keword");
				return errorPage;
			}
			normalList = new PagedListHolder<Normal>(this.farm.searchNormal(word.toLowerCase()));
		}
		
		normalList.setPageSize(10);
		
		//search -> list( or main)
		model.put("normalList", normalList);
		return normalListView;
	}
	
	@RequestMapping("/normal/searchNormal2.do")
	public String searchNormal2(@RequestParam("page") String page,
			@ModelAttribute("normalList") PagedListHolder<Normal> normalList,
			BindingResult result, ModelMap model) throws Exception {
		if (normalList== null) {
			throw new IllegalStateException("Cannot find pre-loaded auction list");
		}
		if ("next".equals(page)) { 
			normalList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			normalList.previousPage(); 
		}
		model.put("search", "search");
		return normalListView;
	}
	//turn state off / on
	@RequestMapping("/normal/turnState.do")
	public ModelAndView sarchNormal(@RequestParam("saleNo") int saleNo) {
		//get normal
		
		String saleState = farm.getSaleState(saleNo);
		System.out.println("current saleState : " + saleState);
		if(saleState.equals( "OPEN")) {
			saleState = "CLOSE";
		} else {
			saleState = "OPEN";
		}
		System.out.println("put saleState = " + saleState);
		int res = farm.turnSaleState(saleNo, saleState);

		if(res == 0) { //failed
			return new ModelAndView(errorPage, "message", "state change failed");
		} else { //success
			return new ModelAndView(successPage, "message", "state change success");
		}

	}
	
	//update form
	@RequestMapping(value="/normal/updateNormal.do", method = RequestMethod.GET)
	public String updateNormal(@RequestParam("saleNo") int saleNo, ModelMap model) throws Exception {
		Normal normal = this.farm.getNormalSale(saleNo);
		
		Product product = this.farm.getProduct(normal.getProduct().getpNo());
		normal.setProduct(product);
		model.addAttribute(normal);
		return updateNormalForm;
	}
	
	//update normal
	@RequestMapping(value = "/normal/updateNormal.do", method = RequestMethod.POST)
	public ModelAndView updateNormal(@Valid@ModelAttribute("normal") Normal normal, 
			BindingResult result, HttpServletRequest request, ModelMap model) {
		//get user session
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("user");
		
		//validate
		if(user == null) {
			return new ModelAndView(errorPage, "message", "Please LOGIN first");
		}
		if(result.hasErrors()) {
			return new ModelAndView(updateNormalForm);
		}
		
		//set attributes
		normal.setSaleState("OPEN");
		int res = farm.updateSale(normal);
		
		if(res == 0)  {//failed
			return new ModelAndView(errorPage, "message", "update Failed");
		} else { //success
			return new ModelAndView(successPage, "message", "update success");
		}
	}
	
	//get all normal list
	@RequestMapping("/normal/list.do")
	public String getNormalList(ModelMap model) throws Exception{
		//get list.do
		PagedListHolder<Normal> normalList = new PagedListHolder<Normal>(farm.getAllNormalList());
		
		
		List <Category> categoryList = farm.getCategoryList();
		normalList.setPageSize(10);
		model.put("normalList", normalList);
		model.put("categoryList", categoryList);
		
		return normalListView;
	}
	@RequestMapping("/normal/list2.do")
	public String getNormalList2(
			@RequestParam("page") String page,
			@ModelAttribute("normalList") PagedListHolder<Normal> normalList,
			BindingResult result, 
			 ModelMap model) throws Exception {
		
		if ("next".equals(page)) {
			normalList.nextPage();
		}
		else if ("previous".equals(page)) {
			normalList.previousPage();
		}
		List <Category> categoryList = farm.getCategoryList();
		model.put("normalList", normalList);
		
		model.put("categoryList", categoryList);
		return normalListView;
	}
	//get NormalList by categoryNo
	@RequestMapping("/normal/cateList.do")
	public String getNormalListByCategoryNo(@RequestParam(value="cateNo", required = false) int cateNo, Model model) {
		//get category list
		PagedListHolder<Normal> normalList =new PagedListHolder<Normal> (farm.getNormalListByCateNo(cateNo));
		normalList.setPageSize(10);
		
		List <Category> categoryList = farm.getCategoryList();
		
		model.addAttribute("normalList", normalList);
		model.addAttribute("categoryList", categoryList);
		return normalListView;
	}
	
	//get normal view
	@RequestMapping("/normal/viewNormal.do")
	public String getNormal(@RequestParam("saleNo") int saleNo, ModelMap model,
			HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession();
		User loginUser = (User) httpSession.getAttribute("user");
		
		Normal normal = this.farm.getNormalSale(saleNo);
		System.out.println(normal.getImage());
		model.addAttribute("normal", normal);
		model.addAttribute("loginUser", loginUser);
		return normalView;
	}
	//get userNormal List
	@RequestMapping("/normal/userList.do")
	public String getNormalListByUserNo(HttpServletRequest request, ModelMap model) {
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("user");
		int userNo = user.getUserNo();
		//get list.do
		PagedListHolder<Normal> normalList = new PagedListHolder<Normal>(farm.getNormalListByUserNo(userNo));
		
		normalList.setPageSize(10);

		model.put("normalList", normalList);
		return normalUserListView;
	}
	@RequestMapping("/normal/userList2.do")
	public String getNormalListByUserNo2(
			@RequestParam("page") String page,
			@ModelAttribute("normalList") PagedListHolder<Normal> normalList,
			BindingResult result, 
			HttpServletRequest request, Model model) {

		if ("next".equals(page)) { 
			normalList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			normalList.previousPage(); 
		}
		
		return normalUserListView;
	}

	
	//normal pay
	@RequestMapping(value = "/normal/buyNormal.do", method = RequestMethod.GET)
	public String buyNormal(@RequestParam("saleNo") int saleNo, 
			@ModelAttribute("payment") PaymentCommand paymentCommand,  ModelMap model) {
		Normal normal = this.farm.getNormalSale(saleNo);
		Product product = this.farm.getProduct(normal.getProduct().getpNo());
		normal.setProduct(product);
		
		model.addAttribute("normal", normal);
		return buyNormalForm;
		
	}
	//normal pay
	@Transactional
	@RequestMapping(value = "/normal/buyNormal.do", method = RequestMethod.POST)
	public ModelAndView buyNormal(@Valid@ModelAttribute("payment") PaymentCommand paymentCommand,
			BindingResult result, HttpServletRequest request, ModelMap model) throws Exception{
		//userSession
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("user");
		if (user == null) {
			return new ModelAndView(errorPage, "message", "Please LOGIN first");
		}
		//get NormalSale
		Normal normal = this.farm.getNormalSale(paymentCommand.getSaleNo());
		Product product = this.farm.getProduct(normal.getProduct().getpNo());
		normal.setProduct(product);
		
		if(paymentCommand.getQuantity() > normal.getCount()) {
			result.rejectValue("quantity", "quantity");
			model.addAttribute("normal", normal);
			return new ModelAndView(buyNormalForm);
		} 
		if(paymentCommand.getQuantity() == normal.getCount()) {
			this.farm.turnSaleState(normal.getSaleNo(), "CLOSE");
		}
				
		if (result.hasErrors()) {
			model.addAttribute("normal", normal);
			return new ModelAndView(buyNormalForm);
		}
		
		//card validation
		Card card = this.farm.getCard(paymentCommand.getCardNo());
		if(card == null) {
			model.addAttribute("normal", normal);
			result.rejectValue("cardNo", "nocardNo");
			return new ModelAndView(buyNormalForm, "payment", paymentCommand);
		}
		if(card.getUser().getUserNo() != user.getUserNo()) {
			model.addAttribute("normal", normal);
			result.rejectValue("cardNo", "notMyCard");
			return new ModelAndView(buyNormalForm, "payment", paymentCommand);
		}
		//Address validation
		Address address = this.farm.getAddress(paymentCommand.getAddrNo());
		if(address == null) {
			model.addAttribute("normal", normal);
			result.rejectValue("addrNo", "noaddressNo");
			return new ModelAndView(buyNormalForm, "payment", paymentCommand);
		}
		if(address.getUser().getUserNo() != user.getUserNo()) {
			model.addAttribute("normal", normal);
			result.rejectValue("addrNo", "notMyAddress");
			return new ModelAndView(buyNormalForm, "payment", paymentCommand);
		}
		//payNo, method, paycheck,cardNo, totalPrice
		Payment payment = new Payment();
		payment.setCard(card);
		payment.setTotalPrice(paymentCommand.getQuantity() * normal.getPrice());
		payment.setMethod("카드");
		//insert normal Payment
		this.farm.insertPayment(payment);
		
		Delivery delivery = new Delivery();
		delivery.setAddress(address);
		delivery.setPhone(paymentCommand.getPhone());
		this.farm.addDelivery(delivery);
		
		int dNo = this.farm.getLastDNo();
		delivery = this.farm.getDelivery(dNo);
		
		int pNo = this.farm.getLastPayNo();
		payment = this.farm.getPayment(pNo);
		
		Order order = new Order();
		
		order.setDelivery(delivery);
		order.setPayment(payment);
		order.setQuantity(paymentCommand.getQuantity());
		order.setSaleNo(paymentCommand.getSaleNo());
		order.setUser(user);
		order.setSaleType("Normal");
		
		this.farm.insertOrder(order);
		
		normal.setCount(normal.getCount() - paymentCommand.getQuantity());
		this.farm.updateSale(normal);
		
		int orderNo = this.farm.getLastOrderNo();
		return new ModelAndView("redirect:/normal/viewDelivery.do?orderNo=" + orderNo);

	}
	
	@RequestMapping("/normal/viewDelivery.do")
	public String deliveryView(@RequestParam("orderNo") int orderNo, ModelMap model) {
		//get order
		Order order = this.farm.getOrder(orderNo);
		//get Delivery
		Delivery delivery = this.farm.getDelivery(order.getDelivery().getdNo());
		//get payment
		Payment payment = this.farm.getPayment(order.getPayment().getPayNo());
		//get Normal
		Normal normal = this.farm.getNormalSale(order.getSaleNo());
		//get Address
		Address address = this.farm.getAddress(delivery.getAddress().getAddrNo());
		delivery.setAddress(address);
		
		model.addAttribute("order", order);
		model.addAttribute("delivery", delivery);
		model.addAttribute("payment", payment);
		model.addAttribute("normal", normal);
		
		return deliveryView;
	}
	
	
	
	
	//related image file
	//upload file
	private void uploadFile(MultipartFile image, Normal normal) {
		this.farm.insertSale(normal);
		System.out.println(image.getOriginalFilename());
		
		int saleNo = this.farm.getLastSaleNo();
		String path = context.getRealPath("/images/normal");
		File file = new File(path, saleNo + ".jpg");
		
		try {
			image.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("path: " + path);
		System.out.println("path: " + file.getPath());
		this.farm.addNormalImage(saleNo, "images/normal/" + file.getName());
	}
}
