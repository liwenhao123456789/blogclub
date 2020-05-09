package com.company.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Johnny
 * @category 博客实体类
 */
public class Blog implements Serializable{

	private int id;

	private int kid;

	private int uid;

	private String title;

	private String schema;

	private String content;

	private int clicks;

	private Date dateTime;

	public Blog() {
		super();
	}

	/**
	 * 博客的构造方法，全部参数
	 */
	public Blog(int id, int kid, int uid, String title, String schema,
			String content, int clicks, Date dateTime) {
		super();
		this.id = id;
		this.kid = kid;
		this.uid = uid;
		this.title = title;
		this.schema = schema;
		this.content = content;
		this.clicks = clicks;
		this.dateTime = dateTime;
	}

	public Blog(int kid, int uid, String title, String schema, String content,
			int clicks, Date dateTime) {
		super();
		this.kid = kid;
		this.uid = uid;
		this.title = title;
		this.schema = schema;
		this.content = content;
		this.clicks = clicks;
		this.dateTime = dateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKid() {
		return kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

}
