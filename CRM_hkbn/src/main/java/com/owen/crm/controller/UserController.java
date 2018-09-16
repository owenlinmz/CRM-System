package com.owen.crm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.owen.crm.pojo.User;
import com.owen.crm.service.UserService;

/**
 * 用户登陆管理
 * @author linn2
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	//登陆
	@RequestMapping("/login")
	public String login(User user, HttpSession httpSession) {
		//判断是否成功从数据库中返回User对象
		if (userService.login(user) != null) {
			if (userService.login(user).getUsername() != null && userService.login(user).getPassword() != null) {
				//设置用户登陆信息
				httpSession.setAttribute("USER_SESSION", userService.login(user).getUsername());
				return "redirect:/customer/list";
			}
		}
		return "login";
	}

	@RequestMapping("/logout")
	public void logout(HttpSession httpSession) {		
		//清除用户登陆信息
		httpSession.setAttribute("USER_SESSION", null);
	}

}
