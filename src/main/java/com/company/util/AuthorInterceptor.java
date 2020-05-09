package com.company.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.company.bean.User;

/**
 * @author Johnny
 * @category 权限拦截器
 */
@Component
public class AuthorInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("进入拦截器");
		HttpSession session = request.getSession();//得到session
		//从Session中取到用户对象
		Object obj = session.getAttribute("current_user");
		//判断用户对象是否存在
		if(obj!=null) {
			//判断用户对象是否是管理员
			User user = (User)obj;
			if(user.getId()==1&&user.getName().equals("admin")) {
				return true;
			}
		}
		response.sendRedirect("index");
		return false;
	}
	
	

}
