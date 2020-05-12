package com.ssg.dojangfarm.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssg.dojangfarm.domain.User;

@Component
@WebService(serviceName="UserService")
public class UserServiceEndpoint {
	@Autowired
	UserService userService; // inject userSeviceImpl

	@WebMethod
	public void createUser(User user) {
		userService.createUser(user);
	}

	@WebMethod
	public void modifyUser(int userNo, String id, String password, String name, String phone) {
		userService.modifyUser(userNo, id, password, name, phone);
	}

	@WebMethod
	public void deleteUser(int userNo) {
		userService.deleteUser(userNo);
	}

	@WebMethod
	public User getUser(int userNo) {
		return userService.getUser(userNo);
	}

	@WebMethod
	public boolean existingId(String id) {
		return userService.existingId(id);
	}

	@WebMethod
	public boolean existingPhone(String phone) {
		return userService.existingPhone(phone);
	}
	
	@WebMethod
	public boolean checkIdPw(String id, String password) {
		return userService.checkIdPw(id, password);
	}
	
	@WebMethod
	public void login() {
		userService.login();
	}
	
	@WebMethod
	public void logout() {
		userService.logout();
	}

}
