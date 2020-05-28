package com.ssg.dojangfarm.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		User user = 
			(User) WebUtils.getSessionAttribute(request, "user");
		
		if (user == null) {
			String url = request.getRequestURL().toString(); 
			String query = request.getQueryString();
			ModelAndView modelAndView = new ModelAndView("LoginView");
			
			if (query != null) {
				modelAndView.addObject("forwardAction", url+"?"+query);
			}
			else {
				modelAndView.addObject("forwardAction", url);
			}
			throw new ModelAndViewDefiningException(modelAndView);
		}
		else {
			return true;
		}
	}
}
