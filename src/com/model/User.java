package com.model;

/**
 * * <b>Description:用户模型</b><br>
 * 
 * @author 王尚升
 * @version 1.0
 * @Note <b>ProjectName:</b> MyWeb <br>
 * 		<b>PackageName:</b> com.model <br>
 * 		<b>ClassName:</b> User <br>
 * 		<b>Date:</b> 2018年11月29日 上午10:42:56
 */

public class User {
	String name;
	String area;
	Boolean sex;
	String id;
	String password;
	String number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		if (null != number)
			if (11 == number.length())
				this.number = number;
	}

	public User() {

	}

	public User(String name, String area, String password, String num, String sex, String id) {
		this.name = name;
		this.area = area;
		this.password = password;
		if ("1".equals(sex))
			this.sex = true;
		else
			this.sex = false;
		number = num;
		this.id = id;
	}

}
