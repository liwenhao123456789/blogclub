package com.company.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.bean.Blog;
import com.company.bean.BlogKind;
import com.company.bean.User;
import com.company.service.IBlogKindService;
import com.company.service.IBlogService;
import com.company.service.IUserService;
import com.company.vo.BlogVO;

/**
 * @author Johnny
 * @category 博客控制器
 */
@Controller
public class BlogController {

	@Autowired
	IBlogService blogService;

	@Autowired
	IUserService userService;

	@Autowired
	IBlogKindService kindService;

	/**
	 * 博客详情
	 */
	@RequestMapping("/showbloginfo")
	public String showbloginfo(int id, Model model) {
		Blog blog = blogService.find(id);
		//更新博客的点击量
		blogService.updateClicks(id);
		model.addAttribute("blog", blog);
		return "bloginfo";
	}

	/**
	 * 个人博客列表
	 */
	@RequestMapping("/personbloglist")
	public String personbloglist(int uid, Model model) {
		// 调用业务逻辑对象的方法，得到集合、得到用户
		List<BlogVO> voList = blogService.findList(uid);
		User user = userService.find(String.valueOf(uid));
		// 将集合、用户放到作用域中
		model.addAttribute("voList", voList);
		model.addAttribute("user", user);
		return "personblogschemalist";
	}

	/**
	 * 跳转到创建博客的页面
	 */
	@RequestMapping("/tocreateblog")
	public String tocreateblog(Model model) {
		// 调用业务逻辑对象取到博客类型集合
		List<BlogKind> blogKindList = kindService.findList();
		model.addAttribute("blogKindList", blogKindList);
		return "blogcreate";
	}

	/**
	 * 创建博客
	 */
	@RequestMapping("/createblog")
	public String createblog(HttpSession session, String title, String kind, String schema, String content) {
		Object obj = session.getAttribute("current_user");
		if (obj != null) {
			User user = (User) obj;
			// 调用业务逻辑对象方法，得到返回值
			boolean flag = blogService.saveBlog(user.getId(), title, kind, schema, content);
			// 根据返回值，响应
			if (flag) {
				return "redirect:/personbloglist?uid=" + user.getId();
			} else {
				return "404";
			}
		} else {
			return "redirect:/tologin";
		}
	}

	/**
	 * 删除博客
	 */
	@RequestMapping("/deleteblog")
	public String deleteblog(int id, HttpSession session) {
		Object obj = session.getAttribute("current_user");
		if (obj != null) {
			User user = (User) obj;
			blogService.delete(id);
			return "redirect:/personbloglist?uid=" + user.getId();
		} else {
			return "404";
		}
	}

	/**
	 * 跳转到编辑博客
	 */
	@RequestMapping("/toeditblog")
	public String toeditblog(int id, Model model) {
		Blog blog = blogService.find(id);
		List<BlogKind> blogKindList = kindService.findList();
		model.addAttribute("blog", blog);
		model.addAttribute("blogKindList", blogKindList);
		return "blogedit";
	}
	
	/**
	 * 编辑博客
	 */
	@RequestMapping("/editblog")
	public String editblog(HttpSession session,int id, String title, String kind, String schema, String content) {
		Object obj = session.getAttribute("current_user");
		if (obj != null) {
			User user = (User) obj;
			boolean flag = blogService.update(id, title, kind, schema, content);
			if(flag) {
				return "redirect:/personbloglist?uid=" + user.getId();
			}else {
				return "404";
			}
		} else {
			return "404";
		}
	}
	
	/**
	 * 博客列表控制器
	 */
	@RequestMapping("/bloglist")
	public String bloglist(Integer kid,Model model) {
		List<BlogVO> voList = null;
		if(kid!=null) {
			//调用业务逻辑方法获得博客列表			
			voList = blogService.findKindList(kid);
		}else {
			voList = blogService.findList();
		}
		//将volist放入request作用域中
		model.addAttribute("voList", voList);
		return "bloglist";
	}
	
}

































