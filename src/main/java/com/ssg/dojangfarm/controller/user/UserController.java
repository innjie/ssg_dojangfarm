package com.ssg.dojangfarm.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.Address;
import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

@Controller
public class UserController {
	private static final String VIEWUSER = "user/UserView";
	private static final String USERFORM = "user/CreateUserFormView";
	private static final String UPDATEUSERFORM = "user/ModifyUserFormView";
	
	@Autowired
	private FarmFacade farm;
	
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
	
	//addressCommand 
	@ModelAttribute("userCommand")
	public UserCommand formBacking() {
		return new UserCommand();
	}
	
	//view user
	@RequestMapping("/user/getUser.do")
	public ModelAndView viewUser(
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");

		return new ModelAndView(VIEWUSER, "user", user);
	}
	
	//create user ... form
	@RequestMapping(value="/user/createUser.do", method=RequestMethod.GET)
	public String userForm(
			 @ModelAttribute("userCommand") UserCommand userCommand,
			 HttpServletRequest request) {				
		return USERFORM;
	}
	
	//create user ... insert
	@RequestMapping(value="/user/createUser.do", method=RequestMethod.POST)
	public String insert(
			@ModelAttribute("userCommand") UserCommand userCommand, 
			BindingResult result) throws Exception {
		
		//validate
		if (result.hasErrors()) {
			return USERFORM;
		}
		
		if(this.farm.existingId(userCommand.getId())){
			result.rejectValue("id", "existUserId", new Object[] {userCommand.getId()}, null);
			return USERFORM;
		}
		if(this.farm.existingPhone(userCommand.getPhone())){
			result.rejectValue("phone", "existingPhone", new Object[] {userCommand.getPhone()}, null);
			return USERFORM;
		}
		
		if(!this.farm.confirmPassword(userCommand.getPassword(), userCommand.getConfirmPassword())) {  //add DAO
			result.rejectValue("confirmPassword", "notSame");
			return USERFORM;
		}
		
		//目盖靛按眉 - 角力按眉 ?????????
		User user = new User();
		
		this.farm.createUser(user);		//in DAO, add user in session

		return "redirect:/user/getUser.do";
	}
	
	//update user ... form
	@RequestMapping(value="/user/modifyUser.do", method=RequestMethod.GET)
	public String updateUserForm(
			 @ModelAttribute("userCommand") UserCommand userCommand,
			 HttpServletRequest request) {				
		return UPDATEUSERFORM;
	}
	
	//update user ... update
	@RequestMapping(value="/user/modifyUser.do", method=RequestMethod.POST)
	public String update(
			@ModelAttribute("userCommand") UserCommand userCommand, 
			BindingResult result,
			HttpServletRequest request) throws Exception {
		
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		
		//validate
		if (result.hasErrors()) {
			return UPDATEUSERFORM;
		}
		
		if(!this.farm.confirmPassword(userCommand.getPassword(), userCommand.getConfirmPassword())) {  //add DAO
		result.rejectValue("confirmPassword", "notSame");
		return USERFORM;
	}
		
		//目盖靛按眉 - 角力按眉 ?????????	
		this.farm.modifyUser(user);

		return "redirect:/user/getUser.do";
	}
			
	//delete user
	@RequestMapping("/user/deleteUser.do")
	public String delete(
			HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		this.farm.deleteUser(user.getUserNo());		
		
		session.removeAttribute("user");
		session.invalidate();
		
		return "redirect:/index.do";
	}
}
