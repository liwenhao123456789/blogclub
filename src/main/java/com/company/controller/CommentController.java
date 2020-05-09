package com.company.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.service.ICommentService;
import com.company.vo.CommentVO;

@RestController
public class CommentController {
	
	@Autowired
	ICommentService commentService;
	
	@RequestMapping("/getcommentlist")
	public List<CommentVO> getCommentList(int bid) {
		List<CommentVO> list = commentService.find(bid);
		return list;
	}
	
	@RequestMapping("/savecomment")
	public boolean saveComment(int uid,int bid,String content,HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		boolean flag = commentService.save(uid, bid, content, ip);
		return flag;
	}
	
	@RequestMapping("/deletecomment")
	public boolean deletecomment(int id) {
		boolean flag = commentService.delete(id);
		return flag;
	}
}
