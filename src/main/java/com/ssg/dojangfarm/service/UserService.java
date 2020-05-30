package com.ssg.dojangfarm.service;

import com.ssg.dojangfarm.domain.User;

//@WebService(name = "UserService")
public interface UserService {
	public void createUser(User user);
	public void modifyUser(User user);
	public void deleteUser(int userNo);
	public User getUser(int userNo);
	public boolean existingId(String id);
	public boolean existingPhone(String phone);
	public User checkIdPw(String id, String password);
	public boolean confirmPassword(String password, String cPassword);
}
