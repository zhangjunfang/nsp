package net.newcapec.bus.dao.role;

import net.newcapec.bus.dao.BaseModel;

/**
 *
 * @author 黄鑫
 *
 */
public class AbstractRole extends BaseModel {

	private static final long serialVersionUID = -8747107197593753290L;
	/**
	 * 角色编号
	 */
	private Integer roleId;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 客户代码
	 */
	private String customerUnitCode;
	/**
	 * 是否启用 0:不启用 1:启用
	 */
	private Integer isVisible;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCustomerUnitCode() {
		return customerUnitCode;
	}

	public void setCustomerUnitCode(String customerUnitCode) {
		this.customerUnitCode = customerUnitCode;
	}

	public Integer getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}

}
