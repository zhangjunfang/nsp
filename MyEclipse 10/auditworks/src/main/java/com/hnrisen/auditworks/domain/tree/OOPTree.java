/**
 * 说明：
 *   
 *   本类设计是面向过程设计
 * 
 */
package com.hnrisen.auditworks.domain.tree;

import java.io.Serializable;

/**
 * @author ： ocean date ：2012-4-20
 */
public class OOPTree implements Serializable, Comparable<OOPTree> {
	
	private static final long serialVersionUID = -7497943561134950794L;
	
	private int id;
	
	private String name;
	
	private String t;
	
	private OOPTree pid;
	
	public int getId() {
	
		return id;
	}
	
	public void setId(int id) {
	
		this.id = id;
	}
	
	public String getName() {
	
		return name;
	}
	
	public void setName(String name) {
	
		this.name = name;
	}
	
	public String getT() {
	
		return t;
	}
	
	public void setT(String t) {
	
		this.t = t;
	}
	
	public OOPTree getPid() {
	
		return pid;
	}
	
	public void setPid(OOPTree pid) {
	
		this.pid = pid;
	}
	
	@Override
	public int hashCode() {
	
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
	
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OOPTree other = (OOPTree) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
	
		return "OOPTree [id=" + id + ", name=" + name + ", t=" + t + ", pid=" + pid + "]";
	}
	
	@Override
	public int compareTo(OOPTree o) {
	
		int temp = o.getId() - this.getId();
		
		if (temp > 0) {
			return 1;
		} else if (temp < 0) {
			return -1;
		}
		
		return 0;
	}
	
}
