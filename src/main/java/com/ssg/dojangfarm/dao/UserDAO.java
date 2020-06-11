package com.ssg.dojangfarm.dao;

import com.ssg.dojangfarm.domain.User;

public interface UserDAO {
	public void createUser(User user);
	public void modifyUser(User user);
	public void deleteUser(int userNo);
	public User getUser(int userNo);
	public User existingId(String id);
	public User existingPhone(String phone);
	public User checkIdPw(String id, String password);
	public boolean confirmPassword(String password, String cPassword);

}
