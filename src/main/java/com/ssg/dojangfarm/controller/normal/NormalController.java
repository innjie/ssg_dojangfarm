package com.ssg.dojangfarm.controller.normal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	private static final String normalList = "/normal/list";
	private static final String errorPage = "/normal/Error";
	
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
		int userNo = (int)request.getSession().getAttribute("userNo");
		
		//validate
		if(userNo <= 0) {
			return new ModelAndView(insertNormaForm, "message", "Please LOGIN first");
		}
		if(result.hasErrors()) {
			return new ModelAndView(insertNormaForm);
		}
		//insert normal
		Normal normal = new Normal();
		User user = new User();
		user.setUserNo(userNo);
		normal.setUser(user);
		int res = farm.insertSale( normal);
		System.out.println(res);
		if(res == 0) { //false
			return new ModelAndView(errorPage, "message", "insert Error");
		} else { //success
			//return success page
		}
		//insert -> list (or main)
		return new ModelAndView( "redirect:" + normalList);
	}
	
	//search normal
	@RequestMapping(value="/normal/searchNormal.do", method = RequestMethod.GET)
	public ModelAndView searchNormal(HttpServletRequest request,
			@RequestParam(value="title", required = false) String word) throws Exception {
		//search action
		List<Normal> normalList = null;
		if(word != null) {
			if(!StringUtils.hasLength(word)) {
				return new ModelAndView("Error", "message", "enter keword");
			}
			normalList = farm.searchNormal(word.toLowerCase());
		}
		//search -> list( or main)
		return new ModelAndView("NormalListView", "normalList", normalList);
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
	public String getNormal(@PathVariable int saleNo, Model model) {
		Normal normal = farm.getNormalSale(saleNo);
		if(normal == null) {
			return "normal/NormalNotFound";
		}
		model.addAttribute("normal", normal);
		return "normal/NormalView";
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
