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
	public void modifyUser(User user) {
		userService.modifyUser(user );
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
	public User checkIdPw(String id, String password) {
		return userService.checkIdPw(id, password);
	}
	
	@WebMethod
	public boolean confirmPassword(String password, String cPassword) {
		return userService.confirmPassword(password, cPassword);
	}

}
