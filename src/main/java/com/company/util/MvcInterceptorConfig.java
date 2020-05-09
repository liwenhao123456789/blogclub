package com.company.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Johnny
 * @category 新建配置类来管理拦截器，兵将之前的拦截器注入其中
 */
@Component
public class MvcInterceptorConfig implements WebMvcConfigurer {

	@Autowired
	AuthorInterceptor authorInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		String[] strs = {"/showuserlist*","/deleteuser*"};
		registry.addInterceptor(authorInterceptor).addPathPatterns(strs);
	}
	
	
}
