package com.ssg.dojangfarm.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.dojangfarm.dao.UserDAO;
import com.ssg.dojangfarm.dao.mybatis.mapper.UserMapper;
import com.ssg.dojangfarm.domain.User;

@Repository
public class MybatisUserDAO implements UserDAO{
	@Autowired
	private UserMapper userMapper;
	
	public void createUser(User user) {
		userMapper.createUser(user);
	}
	public void modifyUser(User user) {
		userMapper.modifyUser(user);
	}
	public void deleteUser(int userNo) {
		userMapper.deleteUser(userNo);
	}
	public User getUser(int userNo) {
		return userMapper.getUser(userNo);
	}
	
	public boolean existingId(String id) {
		if(userMapper.existingId(id)) {
			return true;
		}
		else {
			return false;
		}		
	}
	public boolean existingPhone(String phone) {
		if(userMapper.existingPhone(phone)) {
			return true;
		}
		else {
			return false;
		}	
	}
	public User checkIdPw(String id, String password) {
		return userMapper.checkIdPw(id, password);
	}
	
	public boolean confirmPassword(String password, String cPassword) {
		if(password == cPassword) {
			return true;
		}
		else {
			return false;
		}
	}

}
