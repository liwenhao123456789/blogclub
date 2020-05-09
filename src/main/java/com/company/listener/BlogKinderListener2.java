package com.company.listener;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.company.bean.BlogKind;
import com.company.service.IBlogKindService;

/**
 * @author Johnny
 * @category 博客类型监听SpringBoot实现
 * 
 */
//@Component
//这个监听已经不用了
public class BlogKinderListener2 implements ApplicationListener<ApplicationStartedEvent> {

	@Autowired
	IBlogKindService blogKindService;// 创建业务逻辑对象

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		System.out.println("监听器工作：监听application，将所有的博客类型放到作用域中");
		// 将 ApplicationContext 转化为 WebApplicationContext
		WebApplicationContext webApplicationContext = (WebApplicationContext) event.getApplicationContext();
		// 从 webApplicationContext中获取servletContext
		ServletContext servletContext = webApplicationContext.getServletContext(); 
		List<BlogKind> blogKindList = blogKindService.findList(); // 得到博客类型列表集合
		servletContext.setAttribute("blogKindList", blogKindList);// servletContext设置值
	}
}
