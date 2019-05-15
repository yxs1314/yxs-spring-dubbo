/** 
 * <pre>项目名称:yxs-test 
 * 文件名称:AreaBean.java 
 * 包名:com.jk.yxs.pojo 
 * 创建日期:2019年3月29日下午7:17:48 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;


import java.io.Serializable;

public class AreaBean implements Serializable {


	private static final long serialVersionUID = 161196198111451093L;
	private Integer id;
	private String  name;
	private Integer pid;


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

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "AreaBean{" +
				"id=" + id +
				", name='" + name + '\'' +
				", pid=" + pid +
				'}';
	}
}
