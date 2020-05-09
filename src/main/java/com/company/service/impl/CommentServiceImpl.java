package com.company.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.bean.Comment;
import com.company.bean.User;
import com.company.dao.ICommentDao;
import com.company.dao.IUserDao;
import com.company.service.ICommentService;
import com.company.vo.CommentVO;

/**
 * @author Johnny
 * @category 评论的业务逻辑实现
 */
@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	private ICommentDao commentDao;
	
	@Autowired
	private IUserDao userDao;

	public boolean delete(int id) {
		return commentDao.delete(id) > 0 ? true : false;
	}

	public List<CommentVO> find(int blogId) {
		List<CommentVO> voList = new ArrayList<CommentVO>();
		List<Comment> list = commentDao.find(blogId);
		for (Comment po : list) {
			int uid = po.getUid();
			User user = userDao.find(uid);
			CommentVO vo = new CommentVO(po.getId(), uid, user.getName(), po.getBid(),
					po.getIp(), po.getDateTime(), po.getContent());
			voList.add(vo);
		}
		return voList;
	}

	public boolean save(int uid,int bid,String content,String ip) {
		Comment comment = new Comment(uid, bid, ip, new Date(), content);
		return commentDao.save(comment) > 0 ? true : false;
	}

}
