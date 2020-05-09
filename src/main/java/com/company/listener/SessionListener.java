package com.company.listener;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.bean.BlogKind;
import com.company.service.IBlogKindService;

/**
 * @author Johnny
 * @category 博客类型监听SpringBoot实现
 * 
 */
@Component
public class SessionListener implements HttpSessionListener{

	@Autowired
	IBlogKindService blogKindService;// 创建业务逻辑对象

	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("监听器工作：监听session，将所有的博客类型放到作用域中");
		// 将 ApplicationContext 转化为 WebApplicationContext
		HttpSession session = se.getSession();
		// 得到博客类型列表集合
		List<BlogKind> blogKindList = blogKindService.findList();
		// servletContext设置值
		session.setAttribute("blogKindList", blogKindList);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("监听器工作：销毁session");	
	}
}
