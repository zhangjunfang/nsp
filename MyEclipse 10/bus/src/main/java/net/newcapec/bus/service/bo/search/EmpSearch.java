package net.newcapec.bus.service.bo.search;

import net.newcapec.bus.dao.emp.AbstractEmp;

/**
 * 客户查询参数
 *
 * @author 黄鑫
 *
 */
public class EmpSearch extends AbstractEmp {

	private static final long serialVersionUID = -2183281619930752477L;
	private String appendSql;
	private Long[] ids;

	public String getAppendSql() {
		return appendSql;
	}

	public void setAppendSql(String appendSql) {
		this.appendSql = appendSql;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

}
