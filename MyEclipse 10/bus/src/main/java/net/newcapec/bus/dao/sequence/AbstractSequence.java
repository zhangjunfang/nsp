package net.newcapec.bus.dao.sequence;

import net.newcapec.bus.dao.BaseModel;

/**
 *
 * @author 黄鑫
 *
 */
public class AbstractSequence extends BaseModel {

	private static final long serialVersionUID = -1445910156907530858L;
	private String code;
	private Integer max_no;
	private String contentMes;
	private String customerUnitCode;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getMax_no() {
		return max_no;
	}

	public void setMax_no(Integer max_no) {
		this.max_no = max_no;
	}

	public String getContentMes() {
		return contentMes;
	}

	public void setContentMes(String contentMes) {
		this.contentMes = contentMes;
	}

	public String getCustomerUnitCode() {
		return customerUnitCode;
	}

	public void setCustomerUnitCode(String customerUnitCode) {
		this.customerUnitCode = customerUnitCode;
	}

}
