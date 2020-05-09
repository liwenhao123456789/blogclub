package com.company.vo;

import java.util.Date;

import com.company.util.DateUtil;

public class CommentVO {

	private int id;

	private int uid;

	/**
	 * 用户名称：评论的人
	 */
	private String userName;

	private int bid;

	private String ip;

	private Date dateTime;

	/**
	 * 评论时间字符串
	 */
	private String dateTimeStr;

	private String content;

	public CommentVO() {
		super();
	}

	public CommentVO(int id, int uid, String userName, int bid, String ip,
			Date dateTime, String content) {
		super();
		this.id = id;
		this.uid = uid;
		this.userName = userName;
		this.bid = bid;
		this.ip = ip;
		this.dateTime = dateTime;
		this.dateTimeStr = DateUtil.changeDateTime(dateTime);
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getDateTimeStr() {
		return dateTimeStr;
	}

	public void setDateTimeStr(String dateTimeStr) {
		this.dateTimeStr = dateTimeStr;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
