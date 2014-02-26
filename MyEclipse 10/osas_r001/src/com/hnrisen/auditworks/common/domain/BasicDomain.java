/**
 * 
 */
package com.hnrisen.auditworks.common.domain;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author ： ocean date ：2012-4-12
 */
public class BasicDomain implements Serializable {

	private static final long serialVersionUID = 4306353929435791337L;

	@Override
	public int hashCode() {

		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {

		return super.clone();
	}

	@Override
	public String toString() {

		return super.toString();
	}

	/**
	 * 
	 * 在序列化和反序列化进程中需要特殊处理的 Serializable 类应该实现以下方法
	 * 
	 * **/
	private void writeObject(java.io.ObjectOutputStream stream)
			throws IOException {

	}

	private void readObject(java.io.ObjectInputStream stream)
			throws IOException, ClassNotFoundException {

	}

}
