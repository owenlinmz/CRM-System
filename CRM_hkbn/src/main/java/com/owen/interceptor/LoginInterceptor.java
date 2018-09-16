package com.owen.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 登陆拦截器
 * @author linn2
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取当前URI /user/login
		String URI = request.getRequestURI();
		if (!URI.contains("/login")) {
			String username = (String) request.getSession().getAttribute("USER_SESSION");
			if (username == null) {
				response.sendRedirect(request.getContextPath() + "/user/login");
				return false;
			}
		}
		return true;
	}

	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
