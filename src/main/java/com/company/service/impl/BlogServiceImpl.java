package com.company.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.bean.Blog;
import com.company.dao.IBlogDao;
import com.company.dao.IBlogKindDao;
import com.company.dao.ICommentDao;
import com.company.dao.IUserDao;
import com.company.service.IBlogService;
import com.company.vo.BlogVO;

/**
 * @author Johnny
 * @category 博客的业务逻辑实现类
 * 
 */
@Service
public class BlogServiceImpl implements IBlogService {

	@Autowired
	private IBlogDao blogDao;
	@Autowired
	private ICommentDao commentDao;// 评论的数据访问层对象

	public List<BlogVO> findList() {
		List<BlogVO> blogList = blogDao.findAllList();//查询所有博客
		return blogList;
	}

	public Blog find(int id) {
		return blogDao.find(id);
	}

	public List<BlogVO> findKindList(int kid) {
		List<BlogVO> blogList = blogDao.findKindList(kid);
		return blogList;
	}

	public List<BlogVO> findList(int uid) {
		List<BlogVO> blogList = blogDao.findListByUser(uid);
		return blogList;
	}

	public boolean delete(int id) {
		// 首先删除该博客的所有评论：使用的是评论的数据访问层对象
		commentDao.deleteByBlogId(id);
		// 删除该博客对象，根据博客id
		boolean flag = blogDao.delete(id) > 0 ? true : false;
		return flag;
	}

	public boolean update(int id, String title, String kind, String schema, String content) {
		int kid = Integer.valueOf(kind);
		// 根据id获取博客对象
		Blog blog = blogDao.find(id);
		blog.setTitle(title);
		blog.setKid(kid);
		blog.setSchema(schema);
		blog.setContent(content);
		return blogDao.update(blog) > 0 ? true : false;
	}

	public boolean saveBlog(int uid, String title, String kind, String schema, String content) {
		boolean flag = false;
		if (kind != null && !kind.equals("")) {
			int kid = Integer.valueOf(kind);
			int clicks = 0; // 初始化的点击量为0
			// 创建博客对象
			Blog blog = new Blog(kid, uid, title, schema, content, clicks, new Date());
			int i = blogDao.add(blog);
			if (i > 0) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public List<BlogVO> findHotList() {
		List<BlogVO> blogList = blogDao.findHotList();
		return blogList;
	}

	@Override
	public List<BlogVO> findIndexList() {
		List<BlogVO> blogList = blogDao.findIndexList();
		return blogList;
	}

	@Override
	public boolean updateClicks(int id) {
		return blogDao.updateClicks(id) > 0 ? true : false;
	}

}
