package com.ssg.dojangfarm.controller.normal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.ssg.dojangfarm.service.NormalService;

//Normal Controller
@Controller
public class NormalController {
	private NormalService normalService;
	
	@Autowired
	public void setNormalService(NormalService normalService) {
		this.normalService = normalService;
	}
	
	//insert form
	@RequestMapping(value="/normal/insertForm.do", method = RequestMethod.GET)
	public String insertForm(
			@ModelAttribute("normal") Normal normal) throws Exception {
		return "normal/NormalInsertFormView";
	}
	
	//insert normal
	@RequestMapping("/normal/insertNormal.do")
	public String insertNormal(@ModelAttribute("normal") Normal normal,
			BindingResult result, HttpServletRequest request) {
		//insert action
		
		//get session -> user id
		int userNo = (int)request.getSession().getAttribute("userNo");
		
		//insert normal
		int res = normalService.insertSale(userNo, normal);
		if(res == 0) { //false
			//return fail page
		} else { //success
			//return success page
		}
		//insert -> list (or main)
		return "redirect:/normal/list";
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
			normalList = normalService.searchNormal(word.toLowerCase());
		}
		//search -> list( or main)
		return new ModelAndView("NormalListView", "normalList", normalList);
	}
	
	//turn state off / on
	@RequestMapping("/normal/turn.do")
	public ModelAndView sarchNormal(@ModelAttribute("normal") Normal normal, BindingResult result) {
		//get normal
		int res = normalService.turnSaleState(normal.getSaleNo());
		

		if(res == 0) { //failed
			return new ModelAndView("Error", "message", "state change failed");
		} else { //success
			return new ModelAndView("Success", "message", "state change success");
		}

	}
	@RequestMapping(value="/normal/updateForm.do", method = RequestMethod.GET)
	public String updateForm(
			@ModelAttribute("normal") Normal normal) throws Exception {
		return "normal/NormalUpdateFormView";
	}
	//update normal
	@RequestMapping("/normal/updateNormal.do")
	public ModelAndView updateNormal(@ModelAttribute("normal") Normal normal, BindingResult result) {
		//update action
		int res = normalService.updateSale(normal);
		
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
		List<Normal> normalList = normalService.getAllNormalList();
		model.addAttribute("normalList", normalList);
		return "normal/normalListView";
	}
	
	//get normal view
	@RequestMapping("/normal/{saleNo}.do")
	public String getNormal(@PathVariable int saleNo, Model model) {
		Normal normal = normalService.getNormalSale(saleNo);
		if(normal == null) {
			return "normal/NormalNotFound";
		}
		model.addAttribute("normal", normal);
		return "normal/NormalView";
	}
}