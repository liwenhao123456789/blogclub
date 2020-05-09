package com.company.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.bean.Area;
import com.company.bean.Blog;
import com.company.bean.City;
import com.company.bean.Province;
import com.company.bean.User;
import com.company.dao.IAreaDao;
import com.company.dao.IBlogDao;
import com.company.dao.ICityDao;
import com.company.dao.ICommentDao;
import com.company.dao.IProvinceDao;
import com.company.dao.IUserDao;
import com.company.service.IUserService;
import com.company.vo.BlogVO;
import com.company.vo.UserVO;

/**
 * @author Johnny
 * @category 用户的业务逻辑层
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IBlogDao blogDao;

	@Autowired
	private ICommentDao commentDao;

	@Autowired
	private IProvinceDao provinceDao;

	@Autowired
	private ICityDao cityDao;

	@Autowired
	private IAreaDao areaDao;

	public User find(String id, String pass) {
		User user = null;
		if (id != null && !id.equals("")) {
			int idInt = Integer.valueOf(id);
			user = userDao.findById(idInt, pass);
		}
		return user;
	}

	public User findByName(String name, String pass) {
		User user = null;
		if (name != null && !name.equals("")) {
			user = userDao.findByName(name, pass);
		}
		return user;
	}

	public boolean add(User user) {
		user.setInputDate(new Date(System.currentTimeMillis()));
		int i = userDao.add(user);
		return i > 0 ? true : false;
	}

	public List<UserVO> findUserList() {
		List<UserVO> volist = new ArrayList<UserVO>();
		List<User> users = userDao.findUserList();
		for (User po : users) {
			// 通过用户的省市区外键id，得到省市区对象（考虑有可能为null）
			Province provinceObject = provinceDao.findObject(po.getProvinceId());
			City cityObject = cityDao.findObject(po.getCityId());
			Area areaObject = areaDao.findObject(po.getAreaId());
			String province = provinceObject != null ? provinceObject.getProvince() : "未选择";// 得到省的名称
			String city = cityObject != null ? cityObject.getCity() : "未选择";// 得到市的名称
			String area = areaObject != null ? areaObject.getAreas() : "未选择";// 得到区县的名称
			UserVO vo = new UserVO(po.getId(), po.getName(), po.getPass(), po.getSex(), po.getAge(), po.getTel(),
					po.getProvinceId(), po.getCityId(), po.getAreaId(), po.getInputDate(), po.getIp(), province, city,
					area);
			// 将vo对象放入集合中
			volist.add(vo);
		}
		return volist;
	}

	public boolean delete(int userId) {
		boolean flag = false;
		// 根据Userid得到所有的博客
		List<BlogVO> blogs = blogDao.findListByUser(userId);
		for (BlogVO blog : blogs) {
			// 根据博客的id得到所有的评论
			commentDao.deleteByBlogId(blog.getId());
			blogDao.delete(blog.getId());
		}
		// 删除该人发表的所有评论
		commentDao.deleteByUserId(userId);

		int i = userDao.delete(userId);
		if (i > 0) {
			flag = true;
		}
		return flag;
	}

	public User find(String id) {
		User user = null;
		if (id != null && !id.equals("")) {
			int userId = Integer.valueOf(id);
			user = userDao.find(userId);
		}
		return user;
	}

	public boolean update(User user) {
		boolean flag = false;
		if (user != null && user.getId() != 0) {
			int i = userDao.update(user);
			if (i > 0) {
				flag = true;
			}
		}
		return flag;
	}

	public boolean findByUserName(String name) {
		return userDao.findByUserName(name) == null ? true : false;
	}

}
