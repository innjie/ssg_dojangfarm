package com.ssg.dojangfarm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.UserDAO;
import com.ssg.dojangfarm.domain.User;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public void createUser(User user) {
		userDAO.createUser(user);
	}

	public void modifyUser(User user) {
		userDAO.modifyUser(user);
	}

	public void deleteUser(int userNo) {
		userDAO.deleteUser(userNo);
	}

	public User getUser(int userNo) {
		return userDAO.getUser(userNo);
	}

	public boolean existingId(String id) {
		return userDAO.existingId(id);
	}

	public boolean existingPhone(String phone) {
		return userDAO.existingPhone(phone);
	}
	
	public User checkIdPw(String id, String password) {
		return userDAO.checkIdPw(id, password);
	}

	@Override
	public boolean confirmPassword(String password, String cPassword) {
		return userDAO.confirmPassword(password, cPassword);
	}


}
