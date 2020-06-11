package com.ssg.dojangfarm.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.ssg.dojangfarm.domain.User;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)throws Exception {
				
		LoginCommand login = new  LoginCommand();
		User user = 
			(User) WebUtils.getSessionAttribute(request, "user");
		
		if (user == null) {
			String url = request.getRequestURL().toString(); 
			String query = request.getQueryString();
			ModelAndView modelAndView = new ModelAndView("user/LoginView", "login", login);
			
			if (query != null) {
				login.setForwardAction(url+"?"+query);
			}
			else {
				login.setForwardAction(url);
			}
			throw new ModelAndViewDefiningException(modelAndView);
		}
		else {
			return true;
		}
	}
}
