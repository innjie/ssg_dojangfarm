package com.ssg.dojangfarm.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import com.ssg.dojangfarm.domain.User;

public interface UserMapper {
	public void createUser(User user);
	public void modifyUser(User user);
	public void deleteUser(int userNo);
	public User getUser(int userNo);
	public User existingId(String id);
	public User existingPhone(String phone);
	public User checkIdPw(@Param("id") String id, @Param("password") String password);

}
