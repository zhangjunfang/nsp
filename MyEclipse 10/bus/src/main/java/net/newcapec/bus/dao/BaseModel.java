package net.newcapec.bus.dao;

import java.io.Serializable;

/**
 *
 * @author 黄鑫
 *
 */
public abstract class BaseModel implements Serializable {

	private static final long serialVersionUID = -7316604022958838673L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
