/**
 * <pre>项目名称:yxs-test
 * 文件名称:DeptBean.java
 * 包名:com.jk.yxs.pojo
 * 创建日期:2019年3月29日下午1:55:22
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre>
 */
package com.jk.model;



import java.io.Serializable;
import java.util.List;


public class DeptBean implements Serializable  {


	private static final long serialVersionUID = 9007757589611241802L;

	private Integer id;
	private String  text;
	private Integer pid;
	private List<DeptBean> children;


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public List<DeptBean> getChildren() {
		return children;
	}

	public void setChildren(List<DeptBean> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "DeptBean{" +
				"id=" + id +
				", text='" + text + '\'' +
				", pid=" + pid +
				", children=" + children +
				'}';
	}
}
