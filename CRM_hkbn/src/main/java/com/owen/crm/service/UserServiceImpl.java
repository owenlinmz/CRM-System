package com.owen.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owen.crm.mapper.UserDao;
import com.owen.crm.pojo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User login(User user) {
		return userDao.findUserByNameAndPwd(user);

	}

}
