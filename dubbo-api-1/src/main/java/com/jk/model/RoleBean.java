/** 
 * <pre>项目名称:yxs-test 
 * 文件名称:RoleBean.java 
 * 包名:com.jk.yxs.pojo 
 * 创建日期:2019年3月29日下午7:29:26 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;


public class RoleBean implements Serializable{


	private static final long serialVersionUID = -7706837649549363178L;
	private Integer id;
	private String name;
	private String info;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "RoleBean{" +
				"id=" + id +
				", name='" + name + '\'' +
				", info='" + info + '\'' +
				'}';
	}
}
