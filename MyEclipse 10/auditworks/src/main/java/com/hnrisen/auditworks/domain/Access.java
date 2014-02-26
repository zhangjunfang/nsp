package com.hnrisen.auditworks.domain;

import java.io.Serializable;

import com.hnrisen.auditworks.util.Constant;

public class Access implements Serializable {
	
	private static final long serialVersionUID = -972291359266736188L;
	
	private String id;
	
	private String segment;
	
	private String segtype;
	
	private String tableName;
	
	private int keys;
	
	private String connection;
	
	private String title;
	
	public String getId() {
	
		return id;
	}
	
	public void setId(String id) {
	
		this.id = id;
	}
	
	public String getSegment() {
	
		return segment;
	}
	
	public void setSegment(String segment) {
	
		this.segment = segment;
	}
	
	public String getSegtype() {
	
		return segtype;
	}
	
	public void setSegtype(String segtype) {
	
		this.segtype = segtype;
	}
	
	public String getTableName() {
	
		return tableName;
	}
	
	public void setTableName(String tableName) {
	
		this.tableName = tableName;
	}
	
	public int getKeys() {
	
		return keys;
	}
	
	public void setKeys(int keys) {
	
		this.keys = keys;
	}
	
	public String getConnection() {
	
		return connection;
	}
	
	public void setConnection(String connection) {
	
		this.connection = connection;
	}
	
	public String getTitle() {
	
		return title;
	}
	
	public void setTitle(String title) {
	
		this.title = title;
	}
	
	@Override
	public String toString() {
	
		return Constant.LINE_BREAK + "access [id=" + id + ", segment=" + segment + ", segtype="
				+ segtype + ", tableName=" + tableName + ", keys=" + keys + ", connection="
				+ connection + ", title=" + title + "]" + Constant.LINE_BREAK;
	}
	
}
