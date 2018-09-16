package com.owen.crm.mapper;


import com.owen.crm.pojo.User;


public interface UserDao {
	
	// 根据用户名和密码查询用户
	public User findUserByNameAndPwd(User user);
}
