package com.company.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.bean.Blog;
import com.company.dao.IBlogDao;
import com.company.vo.BlogVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBlogServcie {
	
	@Autowired
	IBlogService blogService;
	
	@Test
	public void test1() {
		m1();
		System.out.println("----");
		m1();
	}
	
	private void m1() {
		Date start = new Date();
		List<BlogVO> list = blogService.findList();
		Date end = new Date();
		System.out.println(list.size());
		System.out.println("所耗费的时间是："+(end.getTime() - start.getTime())+"毫秒");
	}
}
