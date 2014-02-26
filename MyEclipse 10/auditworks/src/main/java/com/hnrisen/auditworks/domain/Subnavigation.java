package com.hnrisen.auditworks.domain;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class Subnavigation implements Serializable{	
	
	private static final long serialVersionUID = 8751282105532159742L;
	@NotEmpty
	private String module_id;
	@NotEmpty
	private String module_type_id;
	@NotEmpty
	private String module_name;
	@NotEmpty
	private String module_url;
	@NotEmpty
	private String remark;
	@NotEmpty
	private char disabled;
	
	private int order_id;
	
	private String module_tag;
	
	private String module_ico;
	
	public String getModule_id() {
	
		return module_id;
	}
	
	public void setModule_id(String module_id) {
	
		this.module_id = module_id;
	}
	
	public String getModule_type_id() {
	
		return module_type_id;
	}
	
	public void setModule_type_id(String module_type_id) {
	
		this.module_type_id = module_type_id;
	}
	
	public String getModule_name() {
	
		return module_name;
	}
	
	public void setModule_name(String module_name) {
	
		this.module_name = module_name;
	}
	
	public String getModule_url() {
	
		return module_url;
	}
	
	public void setModule_url(String module_url) {
	
		this.module_url = module_url;
	}
	
	public String getRemark() {
	
		return remark;
	}
	
	public void setRemark(String remark) {
	
		this.remark = remark;
	}
	
	public char getDisabled() {
	
		return disabled;
	}
	
	public void setDisabled(char disabled) {
	
		this.disabled = disabled;
	}
	
	public int getOrder_id() {
	
		return order_id;
	}
	
	public void setOrder_id(int order_id) {
	
		this.order_id = order_id;
	}	
	
	public String getModule_tag() {
	
		return module_tag;
	}
	
	public void setModule_tag(String module_tag) {
	
		this.module_tag = module_tag;
	}	
	
	public String getModule_ico() {
	
		return module_ico;
	}
	
	public void setModule_ico(String module_ico) {
	
		this.module_ico = module_ico;
	}
	
}
