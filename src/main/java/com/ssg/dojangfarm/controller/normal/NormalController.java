package com.ssg.dojangfarm.controller.normal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Normal;
import com.ssg.dojangfarm.domain.Product;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

//Normal Controller
@Controller
public class NormalController {
	private static final String insertNormaForm = "normal/NormalInsertFormView";
	private static final String normalListView = "normal/NormalListView";
	private static final String errorPage = "/normal/Error";
	private static final String normalView = "normal/NormalView";
	private static final String normalUserListView = "normal/NormalUserListView";
	private static final String successPage = "/normal/Success";
	private static final String updateNormalForm = "normal/NormalUpdateFormView";
	
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
	
	//insert form
	@RequestMapping("/normal/insertForm.do")
	public String insertForm(HttpServletRequest request,
			 @ModelAttribute("normalCommand") NormalCommand normalCommand,
			 ModelMap model) throws Exception {
		List<Product> pList = this.farm.getProductList();
		model.addAttribute("product", pList);
		
		return insertNormaForm;
	}
	
	//insert normal
	@RequestMapping("/normal/insertNormal.do")
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
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		normal.setRegiDate(sqlDate);
		
		int res = this.farm.insertSale(normal);

		if(res == 0) { //false
			return new ModelAndView(errorPage, "message", "insert Error");
		}
		//insert -> list (or main)
		return new ModelAndView( "redirect:/normal/list.do");
	}
	
	//search normal
	@RequestMapping("/normal/searchNormal.do")
	public ModelAndView searchNormal(HttpServletRequest request,
			@RequestParam(value="word", required = false) String word
			) throws Exception {
		
		System.out.println(word);
		//search action
		List<Normal> normalList = null;
		if(word != null) {
			if(!StringUtils.hasLength(word)) {
				return new ModelAndView(errorPage, "message", "enter keword");
			}
			normalList = this.farm.searchNormal(word.toLowerCase());
		}
		
		if(normalList == null) {
			System.out.println("0");
		} else {
			System.out.println(normalList.size());
		}
		//search -> list( or main)
		
		return new ModelAndView(normalListView, "normalList", normalList);
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
	
	@RequestMapping(value="/normal/updateForm.do")
	public String updateForm(@RequestParam("saleNo") int saleNo, ModelMap model) throws Exception {
		Normal normal = this.farm.getNormalSale(saleNo);
		
		Product product = this.farm.getProduct(normal.getProduct().getpNo());
		normal.setProduct(product);
		model.addAttribute(normal);
		return updateNormalForm;
	}
	//update normal
	@RequestMapping("/normal/updateNormal.do")
	public ModelAndView updateNormal(@ModelAttribute("normal") Normal normal, 
			BindingResult result, HttpServletRequest request, ModelMap model) {
		
		//update action
		
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
		
		int res = farm.updateSale(normal);
		
		if(res == 0)  {//failed
			return new ModelAndView(errorPage, "message", "update Failed");
		} else { //success
			return new ModelAndView(successPage, "message", "update success");
		}
	}
	
	//get all normal list
	@RequestMapping("/normal/list.do")
	public String getNormalList(Model model) {
		//get list.do
		List<Normal> normalList = farm.getAllNormalList();
		model.addAttribute("normalList", normalList);
		
		return normalListView;
	}
	
	//get normal view
	@RequestMapping("/normal/viewNormal.do")
	public String getNormal(@RequestParam("saleNo") int saleNo, ModelMap model,
			HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession();
		User loginUser = (User) httpSession.getAttribute("user");
		
		int confUserNo = this.farm.getUserByNormal(saleNo);
		Normal normal = this.farm.getNormalSale(saleNo);
		User normalUser = new User();
		normalUser.setUserNo(confUserNo);
		normal.setUser(normalUser);
		
		model.addAttribute("normal", normal);
		model.addAttribute("loginUser", loginUser);
		return normalView;
	}
	//get userNormal List
	@RequestMapping("/normal/userList.do")
	public String getNormalListByUserNo(HttpServletRequest request, Model model) {
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("user");
		int userNo = user.getUserNo();
		//get list.do
		List<Normal> normalList = farm.getNormalListByUserNo(userNo);
		model.addAttribute("normalList", normalList);
		return normalUserListView;
	}
}
