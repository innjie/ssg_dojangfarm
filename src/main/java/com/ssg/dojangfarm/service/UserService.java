package com.ssg.dojangfarm.service;

import com.ssg.dojangfarm.domain.User;

//@WebService(name = "UserService")
public interface UserService {
	public void createUser(User user);
	public void modifyUser(int userNo, String id, String password, String name, String phone);
	public void deleteUser(int userNo);
	public User getUser(int userNo);
	public boolean existingId(String id);
	public boolean existingPhone(String phone);
	public boolean checkIdPw(String id, String password);
	public void login();
	public void logout();
}
