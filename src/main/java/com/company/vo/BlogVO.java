package com.company.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Johnny
 * @category 博客表的vo对象类
 */
public class BlogVO implements Serializable {

	private int id;

	private int kid;

	private int uid;

	private String kindName;

	private String authorName;

	private String title;

	private String schema;

	private String content;

	private int clicks;

	private Date dateTime;

	public BlogVO() {
		super();
	}

	public BlogVO(int id, int kid, int uid, String kindName, String authorName,
			String title, String schema, String content, int clicks,
			Date dateTime) {
		super();
		this.id = id;
		this.kid = kid;
		this.uid = uid;
		this.kindName = kindName;
		this.authorName = authorName;
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

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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
