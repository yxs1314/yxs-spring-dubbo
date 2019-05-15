/** 
 * <pre>项目名称:yxs-test 
 * 文件名称:MenuBean.java 
 * 包名:com.jk.yxs.pojo 
 * 创建日期:2019年4月2日下午1:34:04 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;


import java.io.Serializable;

public class MenuBean implements Serializable {
	private static final long serialVersionUID = 1347547289775437321L;
	private Integer id;
	private String  name;
	private String  url;
	private Integer  powerid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPowerid() {
		return powerid;
	}

	public void setPowerid(Integer powerid) {
		this.powerid = powerid;
	}

	@Override
	public String toString() {
		return "MenuBean{" +
				"id=" + id +
				", name='" + name + '\'' +
				", url='" + url + '\'' +
				", powerid=" + powerid +
				'}';
	}
}
