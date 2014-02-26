package com.hnrisen.auditworks.domain;

/**
 * {display: '', name : '', width : 40, sortable : true, align: 'center'}
 */
public class ColumnModel {
	
	private String display;
	
	private String name;
	
	private int width;
	
	private boolean sortable;
	
	private String align;
	
	public ColumnModel() {
	
	}
	
	public ColumnModel(String display, String name, int width, boolean sortable, String align) {
	
		super();
		this.display = display;
		this.name = name;
		this.width = width;
		this.sortable = sortable;
		this.align = align;
	}
	
	public String getDisplay() {
	
		return display;
	}
	
	public void setDisplay(String display) {
	
		this.display = display;
	}
	
	public String getName() {
	
		return name;
	}
	
	public void setName(String name) {
	
		this.name = name;
	}
	
	public int getWidth() {
	
		return width;
	}
	
	public void setWidth(int width) {
	
		this.width = width;
	}
	
	public boolean isSortable() {
	
		return sortable;
	}
	
	public void setSortable(boolean sortable) {
	
		this.sortable = sortable;
	}
	
	public String getAlign() {
	
		return align;
	}
	
	public void setAlign(String align) {
	
		this.align = align;
	}
	
}
