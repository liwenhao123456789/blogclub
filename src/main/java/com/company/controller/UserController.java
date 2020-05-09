package com.company.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.bean.User;
import com.company.service.IUserService;
import com.company.vo.UserVO;

/**
 * @author Johnny
 * @category 用户控制器
 */
@Controller
public class UserController {

	@Autowired
	IUserService userService;

	@RequestMapping("/tologin")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("/login")
	public String login(String name, String pass, HttpSession session, Model model) {
		// 调用业务逻辑方法，得到返回值
		User user = userService.findByName(name, pass);
		// 根据返回值响应
		if (user != null) {
			System.out.println("登录成功");
			// 将用户对象放入session中
			session.setAttribute("current_user", user);
			return "redirect:/index";
		} else {
			System.out.println("登录失败");
			model.addAttribute("mes", "密码错误");
			return "forward:/tologin";
		}
	}

	@RequestMapping("/toregist")
	public String toRegist() {
		return "regist";
	}

	@RequestMapping("/regist")
	public String regist(User user, HttpServletRequest request) {
		user.setIp(request.getRemoteAddr());
		boolean flag = userService.add(user);
		if (flag) {
			return "redirect:/tologin";
		} else {
			return "404";
		}
	}

	@RequestMapping("/exit")
	public String exit(HttpSession session) {
		session.removeAttribute("current_user");
		session.invalidate();//使session失效
		return "redirect:/index";
	}

	@RequestMapping("/check")
	@ResponseBody
	public String check(String name) {
		// 接收AJAX传入的名字
		// 调用业务逻辑的方法，得到返回值
		boolean flag = userService.findByUserName(name);
		// 将返回值写出去
		return flag+""; 
	}
	
	@GetMapping("/showuserlist")
	public String showuserlist(Model model) {
		List<UserVO> userList = userService.findUserList();
		model.addAttribute("userList", userList);
		return "userlist";
	}
	
	@GetMapping("/deleteuser")
	public String deleteuser(int uid) {
		boolean flag = userService.delete(uid);
//		log.debug("用户删除："+flag);
		return "redirect:showuserlist";
	}
	
	

}
