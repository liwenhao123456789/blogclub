package com.company.vo;

import java.sql.Date;

/**
 * @author Johnny
 * @category 用户实体类
 */
public class UserVO {

	private int id;

	private String name;

	private String pass;

	private String sex;

	private int age;

	private String tel;

	private String provinceId;

	private String cityId;

	private String areaId;

	private Date inputDate;

	private String ip;

	private String province;

	private String city;

	private String area;

	public UserVO() {
		super();
	}

	public UserVO(int id, String name, String pass, String sex, int age, String tel, String provinceId, String cityId,
			String areaId, Date inputDate, String ip, String province, String city, String area) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.areaId = areaId;
		this.inputDate = inputDate;
		this.ip = ip;
		this.province = province;
		this.city = city;
		this.area = area;
	}



	public UserVO(int id, String name, String pass, String sex, int age, String tel, String provinceId, String cityId,
			String areaId, Date inputDate, String ip) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.areaId = areaId;
		this.inputDate = inputDate;
		this.ip = ip;
	}

	public UserVO(String name, String pass, String sex, int age, String tel, String provinceId, String cityId,
			String areaId, Date inputDate, String ip) {
		super();
		this.name = name;
		this.pass = pass;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.areaId = areaId;
		this.inputDate = inputDate;
		this.ip = ip;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
