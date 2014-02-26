package com.hnrisen.auditworks.domain;

import java.io.Serializable;

public class Navigation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8254593706551144572L;
	
	private String module_type_id;
	
	private String parent_id;
	
	private String module_type_name;
	
	private String remark;	
	
	private int order_id;	
	
	public String getModule_type_id() {
	
		return module_type_id;
	}
	
	public void setModule_type_id(String module_type_id) {
	
		this.module_type_id = module_type_id;
	}
	
	public String getParent_id() {
		
		return parent_id;
	}
	
	public void setParent_id(String parent_id) {
	
		this.parent_id = parent_id;
	}
	
	public String getModule_type_name() {
	
		return module_type_name;
	}
	
	public void setModule_type_name(String module_name) {
	
		this.module_type_name = module_name;
	}	
	
	public String getRemark() {
	
		return remark;
	}
	
	public void setRemark(String remark) {
	
		this.remark = remark;
	}	
	
	public int getOrder_id() {
	
		return order_id;
	}
	
	public void setOrder_id(int order_id) {
	
		this.order_id = order_id;
	}	
	
}
