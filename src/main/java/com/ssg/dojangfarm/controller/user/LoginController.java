package com.ssg.dojangfarm.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.dojangfarm.domain.User;
import com.ssg.dojangfarm.service.FarmFacade;

@RequestMapping("/user/login.do")
@Controller
public class LoginController {
	private static final String LOGINFORM = "user/LoginView";
	
	@Autowired
	private FarmFacade farm;
	
	public void setFarm(FarmFacade  farm) {
		this.farm = farm;
	}
	
	//LoginCommand 
	@ModelAttribute("login")
	public LoginCommand formBacking() {
		return new LoginCommand();
	}
	
	//login ... form
	@RequestMapping(method = RequestMethod.GET)
	public String loginForm(
			 @ModelAttribute("login") LoginCommand loginCommand,
			 HttpServletRequest request) {
		System.out.println("view loginform");
				
		return LOGINFORM;
	}
	
	
	//login
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login(
			HttpServletRequest request,
			@Valid @ModelAttribute("login") LoginCommand loginCommand,
			BindingResult result) throws Exception {
		
		System.out.println("login");
				
		//validate
		if (result.hasErrors()) {
			return new ModelAndView(LOGINFORM);
		}
		
		User user = farm.checkIdPw(loginCommand.getId(), loginCommand.getPassword());

		if (user == null) {
			return new ModelAndView(LOGINFORM, "message", 
					"Invalid username or password.  Signon failed.");
		}
		else {
			System.out.println("Success login");
			
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", user);
			
			if (loginCommand.getForwardAction() != null) 
				return new ModelAndView("redirect:" + loginCommand.getForwardAction());
			else 
				return new ModelAndView("Main");
		}
	}
}
