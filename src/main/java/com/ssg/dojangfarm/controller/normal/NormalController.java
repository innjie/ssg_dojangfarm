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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Normal;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

//Normal Controller
@Controller
public class NormalController {
	private static final String insertNormaForm = "normal/NormalInsertFormView";
	private static final String normalListView = "normal/NormalListView";
	private static final String errorPage = "/normal/Error";
	private static final String normalView = "normal/NormalView";
	
	@Autowired
	private FarmFacade farm;
	public void setFarm(FarmFacade farm) {
		this.farm = farm;
	}
	/**
	@ModelAttribute("normal")
	public Normal formBacking() {
		return new Normal();
	}
	**/
	//Normal Command
	@ModelAttribute("normalCommand")
	public NormalCommand formBacking(HttpServletRequest request) {
		return new NormalCommand();
	}
	
	//insert form
	@RequestMapping("/normal/insertForm.do")
	public String insertForm(HttpServletRequest request,
			 @ModelAttribute("normalCommand") NormalCommand normalCommand) throws Exception {
		
		return insertNormaForm;
	}
	
	//insert normal
	@RequestMapping("/normal/insertNormal.do")
	public ModelAndView insertNormal(
			@Valid@ModelAttribute("normalCommand") NormalCommand normalCommand,
			BindingResult result, HttpServletRequest request) {
		//insert action
		
		//get session -> user id
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("user");
		
		//validate
		if(user == null) {
			return new ModelAndView(errorPage, "message", "Please LOGIN first");
		}
		if(result.hasErrors()) {
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
		
		System.out.println("Normal: price: " + normal.getPrice() + " title : " + normal.getTitle()
				+ " info: " + normal.getInfo());
		
		
		int res = this.farm.insertSale(normal);
		System.out.println(res);
		if(res == 0) { //false
			return new ModelAndView(errorPage, "message", "insert Error");
		} else { //success
			//return success page
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
	@RequestMapping("/normal/turn.do")
	public ModelAndView sarchNormal(@ModelAttribute("normal") Normal normal, BindingResult result) {
		//get normal
		int res = farm.turnSaleState(normal.getSaleNo());
		

		if(res == 0) { //failed
			return new ModelAndView("Error", "message", "state change failed");
		} else { //success
			return new ModelAndView("Success", "message", "state change success");
		}

	}
	@RequestMapping(value="/normal/updateForm.do")
	public String updateForm(
			@ModelAttribute("normal") Normal normal) throws Exception {
		return "normal/NormalUpdateFormView";
	}
	//update normal
	@RequestMapping("/normal/updateNormal.do")
	public ModelAndView updateNormal(@ModelAttribute("normal") Normal normal, BindingResult result) {
		//update action
		int res = farm.updateSale(normal);
		
		if(res == 0)  {//failed
			return new ModelAndView("Error", "message", "update Failed");
		} else { //success
			return new ModelAndView("Success", "message", "update success");
		}
	}
	
	//get all normal list
	@RequestMapping("/normal/list.do")
	public String getNormalList(Model model) {
		//get list.do
		List<Normal> normalList = farm.getAllNormalList();
		model.addAttribute("normalList", normalList);
		return "normal/NormalListView";
	}
	
	//get normal view
	@RequestMapping("/normal/viewNormal.do")
	public String getNormal(@RequestParam("saleNo") int saleNo, Model model) {
	
		Normal normal = this.farm.getNormalSale(saleNo);
		if(normal == null) {
			return "normal/NormalNotFound";
		}
		
		model.addAttribute("normal", normal);
		return normalView;
	}
	//get userNormal List
	@RequestMapping("/normal/userList.do")
	public String getNormalListByUserNo(HttpServletRequest request, Model model) {
		User user = (User) request.getAttribute("User");
		int userNo = user.getUserNo();
		//get list.do
		List<Normal> normalList = farm.getNormalListByUserNo(userNo);
		model.addAttribute("normalList", normalList);
		return "normal/NormalUserListView";
	}
}
