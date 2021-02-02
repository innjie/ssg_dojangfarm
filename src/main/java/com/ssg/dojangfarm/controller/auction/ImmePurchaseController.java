package com.ssg.dojangfarm.controller.auction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssg.dojangfarm.domain.ImPur;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
public class ImmePurchaseController {
	private static final String LISTIMPUR = "auction/MyImPurListView";
	private static final String VIEWIMPUR = "auction/MyImPurView";
	
	@Autowired
	private FarmFacade farm;
	
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
	
//	//view myImPurList
//	@RequestMapping("/auction/viewMyImPurList.do")
//	public String listMyImPur(
//			ModelMap model,
//			HttpServletRequest request) throws Exception {
//		
//		HttpSession httpSession = request.getSession();
//		User user = (User) httpSession.getAttribute("user");
//
//		PagedListHolder<ImPur> imPurList = new PagedListHolder<ImPur>(this.farm.getMyImPurList(user.getUserNo()));	//add dao
//
//		imPurList.setPageSize(4);
//		model.put("imPurList", imPurList.getSource() );
//		return LISTIMPUR;
//	}
	

/*	//view myImPurList by page
	@RequestMapping("/auction/viewMyImPurList2.do")
	public String listMyImPur2(
			@RequestParam("page") String page,
			@ModelAttribute("imPurList") PagedListHolder<ImPur> imPurList,
			BindingResult result) throws Exception {
		if (imPurList== null) {
			throw new IllegalStateException("Cannot find pre-loaded imPurList");
		}
		if ("next".equals(page)) { 
			imPurList.nextPage(); 
		}
		else if ("previous".equals(page)) { 
			imPurList.previousPage(); 
		}
			
		return LISTIMPUR;
	}
*/	
		
//	//view myImPur
//	@RequestMapping("/auction/viewMyImPur.do")
//	public String viewMyImPur(
//			@RequestParam("imPurNo") int imPurNo,
//			ModelMap model) throws Exception {
//			
//		ImPur imPur = this.farm.getMyImPur(imPurNo);	
//		model.put("imPur", imPur);
//			
//		return VIEWIMPUR;
//	}	
}
