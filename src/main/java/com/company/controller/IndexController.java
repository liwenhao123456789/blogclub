package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.service.IBlogService;
import com.company.vo.BlogVO;

/**
 * @author Johnny
 * @category 首页的控制器
 */
@Controller
public class IndexController {

	@Autowired
	IBlogService blogService;

	@RequestMapping({"/index","/"})
	public String index(Model model) {
		// 调用查询博客类型列表
		List<BlogVO> hotList = blogService.findHotList();
		List<BlogVO> indexList = blogService.findIndexList();
		//将集合放入到作用域中
		model.addAttribute("hotList", hotList);
		model.addAttribute("indexList", indexList);
		//转发
		return "index";
	}
}
