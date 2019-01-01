package com.model;

/**
 * * <b>Description:菜谱模型</b><br>
 * 
 * @author 王尚升
 * @version 1.0
 * @Note <b>ProjectName:</b> MyWeb <br>
 * 		<b>PackageName:</b> com.model <br>
 * 		<b>ClassName:</b> Food <br>
 * 		<b>Date:</b> 2018年11月29日 上午10:42:17
 */

public class Food {
	String area;
	String name;
	String img;
	String intro;
	String publisher;

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}
