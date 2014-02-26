package net.newcapec.bus.service.bo;

import net.newcapec.bus.dao.emp.AbstractEmp;

/**
 * 客户
 *
 * @author 黄鑫
 *
 */
public class Emp extends AbstractEmp {

	private static final long serialVersionUID = 8422334332731184691L;

	private String sex_Text;

	public String getSex_Text() {
		if (sex_Text != null)
			return sex_Text;
		switch (getSex()) {
		case 1:
			sex_Text = "男";
			break;
		case 0:
			sex_Text = "女";
			break;
		default:
			sex_Text = "未知";
			break;
		}
		return sex_Text;
	}

	public void setSex_Text(String sex_Text) {
		this.sex_Text = sex_Text;
	}

}
