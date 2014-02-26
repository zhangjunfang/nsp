package net.newcapec.bus;

import java.io.Serializable;

/**
 * 分页
 *
 * @author 黄鑫
 *
 */
public class Pagination implements Serializable {

	private static final long serialVersionUID = 8318796010810856588L;
	/* 当前第1页 */
	int current = 1;
	/* 每页显示20条记录 */
	int pageSize = 20;

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		if (current > 0)
			this.current = current;
	}

	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 每页显示1-200条记录
	 *
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		if (pageSize > 0 && pageSize < 501)
			this.pageSize = pageSize;
	}

}
