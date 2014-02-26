/**
 * 说明：
 *   
 *   本类设计是面向过程设计
 * 
 */
package com.hnrisen.auditworks.domain.tree;

import java.io.Serializable;

import org.springframework.util.Assert;

/**
 * @author ： ocean date ：2012-4-20
 */
public class Tree implements Serializable, Comparable<Tree> {
	
	private static final long serialVersionUID = -7497943561134950794L;
	
	/**
	 * 当前节点编号
	 * 
	 * **/
	// @Range(min = 0, max = 16)
	private String id;
	
	/**
	 * 父节点标号
	 * 
	 * **/
	// @Range(min = 0, max = 16)
	private String pId;
	
	/**
	 * 节点名称
	 * 
	 * **/
	// @NotBlank
	// @Length(min = 5, max = 25)
	private String name;
	
	/**
	 * 索引关键字
	 * 
	 * **/
	// @NotBlank
	// @Length(min = 1)
	private String t;
	
	public String getId() {
	
		return id;
	}
	
	public void setId(String id) {
	
		this.id = id;
	}
	
	public String getpId() {
	
		return pId;
	}
	
	public void setpId(String pId) {
	
		this.pId = pId;
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
	
	@Override
	public int hashCode() {
	
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
	
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Tree other = (Tree) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	
	@Override
	public int compareTo(Tree tree) {
	
		Assert.notNull(tree);
		
		Assert.notNull(id);
		
		
		Assert.notNull(tree.getId());
		
		return tree.getId().compareTo(id);
	}

	
	@Override
	public String toString() {
	
		return "{id:" + id + ", pId:" + pId + ", name:" + name + ", t:" + t + "}";
	}
	
}
