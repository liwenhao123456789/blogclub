package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.bean.BlogKind;
import com.company.dao.IBlogKindDao;
import com.company.service.IBlogKindService;

/**
 * @author Johnny
 * @category 博客类型的业务逻辑层
 */
@Service
public class BlogKindServiceImpl implements IBlogKindService {

	@Autowired
	private IBlogKindDao blogKindDao;
	
	public List<BlogKind> findList() {
		return blogKindDao.findList();
	}

	public BlogKind find(int id) {
		return blogKindDao.find(id);
	}
	
	
}
