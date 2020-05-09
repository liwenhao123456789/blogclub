package com.company.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.vo.BlogVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBlogDao {

	@Autowired
	IBlogDao blogDao;
	
	@Test
	public void test2() {
		Date start = new Date();
		List<BlogVO> list = blogDao.findAllList();
		Date end = new Date();
		System.out.println(list.size());
		System.out.println("所耗费的时间是："+(end.getTime() - start.getTime())+"毫秒");
	}
}
