package com.company.bean;

/**
 * @author Johnny
 * @category 博客类型实体类
 */
public class BlogKind {

	private int id;

	private String name;

	public BlogKind() {
		super();
	}

	public BlogKind(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
