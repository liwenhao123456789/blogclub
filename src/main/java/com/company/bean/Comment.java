package com.company.bean;

import java.util.Date;

/**
 * @author Johnny
 * @category 博客评论实体类
 */
public class Comment {

	private int id;

	private int uid;

	private int bid;

	private String ip;

	private Date dateTime;

	private String content;

	public Comment() {
		super();
	}
	
	public Comment(int id, int uid, int bid, String ip, Date dateTime,
			String content) {
		super();
		this.id = id;
		this.uid = uid;
		this.bid = bid;
		this.ip = ip;
		this.dateTime = dateTime;
		this.content = content;
	}

	public Comment(int uid, int bid, String ip, Date dateTime,
			String content) {
		super();
		this.uid = uid;
		this.bid = bid;
		this.ip = ip;
		this.dateTime = dateTime;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
