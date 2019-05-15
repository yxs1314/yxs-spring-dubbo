/** 
 * <pre>项目名称:yxs-test 
 * 文件名称:NavBean.java 
 * 包名:com.jk.yxs.pojo 
 * 创建日期:2019年3月29日上午11:33:42 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;



import java.io.Serializable;
import java.util.List;


public class NavBean implements Serializable {


	private static final long serialVersionUID = -8793003924133045935L;
	private Integer id;
	private String  text;
	private String  url;
	private Integer pid;
	private List<NavBean> children;
	private boolean checked;


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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public List<NavBean> getChildren() {
		return children;
	}

	public void setChildren(List<NavBean> children) {
		this.children = children;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "NavBean{" +
				"id=" + id +
				", text='" + text + '\'' +
				", url='" + url + '\'' +
				", pid=" + pid +
				", children=" + children +
				", checked=" + checked +
				'}';
	}
}
