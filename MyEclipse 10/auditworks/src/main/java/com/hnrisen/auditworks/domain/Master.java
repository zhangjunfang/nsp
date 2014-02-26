package com.hnrisen.auditworks.domain;

import java.io.Serializable;

import com.hnrisen.auditworks.util.Constant;

public class Master implements Serializable {
	
	private static final long serialVersionUID = -6574759909683381792L;
	
	private int id;
	
	private String segname;
	
	private String fieldName;
	
	private String alias;
	
	private String title;
	
	public int getId() {
	
		return id;
	}
	
	public void setId(int id) {
	
		this.id = id;
	}
	
	public String getSegname() {
	
		return segname;
	}
	
	public void setSegname(String segname) {
	
		this.segname = segname;
	}
	
	public String getFieldName() {
	
		return fieldName;
	}
	
	public void setFieldName(String fieldName) {
	
		this.fieldName = fieldName;
	}
	
	public String getAlias() {
	
		return alias;
	}
	
	public void setAlias(String alias) {
	
		this.alias = alias;
	}
	
	public String getTitle() {
	
		return title;
	}
	
	public void setTitle(String title) {
	
		this.title = title;
	}
	
	@Override
	public String toString() {
	
		return "master ：[id=" + id + ", segname=" + segname + ", fieldName=" + fieldName
				+ ", alias=" + alias + ", title=" + title + "]" + Constant.LINE_BREAK;
	}
}
