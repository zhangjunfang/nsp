package net.newcapec.bus.dao.emp;

import net.newcapec.bus.dao.BaseModel;

/**
 * 抽象客户类
 *
 * @author 黄鑫
 *
 */
public class AbstractEmp extends BaseModel {

	private static final long serialVersionUID = -6772443140177897301L;

	private Integer empId;
	private String empCode;
	private String empName;
	private String empPwd;
	private String empPos;
	private String empEmail;
	private String dptCode;
	private String idCardNo;
	private Integer certificateId;
	private String telPhoneNum;
	private Integer sex;
	private Integer postId;
	private String address;
	private String nation;
	private String incomeDate;
	private String userId;
	private Integer loginSt;
	private String roleCode;
	private Integer isSystemUser;
	private String cashCardType;
	private String saleCardType;
	private Integer privilegeLogon;
	private Integer yearCheck;
	private String checkBeginDay;
	private String checkEndDay;
	private String themes;
	private Integer ver;
	private Integer areaId;
	private Integer status;
	private Integer exceptiveEmp;
	private Integer isDelete;
	private String customerUnitCode;
	private Integer bankCode;
	private String bankCardNo;
	private String language;
	private String deleteDate;
	private Integer accountType;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public String getEmpPos() {
		return empPos;
	}

	public void setEmpPos(String empPos) {
		this.empPos = empPos;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getDptCode() {
		return dptCode;
	}

	public void setDptCode(String dptCode) {
		this.dptCode = dptCode;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public Integer getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(Integer certificateId) {
		this.certificateId = certificateId;
	}

	public String getTelPhoneNum() {
		return telPhoneNum;
	}

	public void setTelPhoneNum(String telPhoneNum) {
		this.telPhoneNum = telPhoneNum;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getIncomeDate() {
		return incomeDate;
	}

	public void setIncomeDate(String incomeDate) {
		this.incomeDate = incomeDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getLoginSt() {
		return loginSt;
	}

	public void setLoginSt(Integer loginSt) {
		this.loginSt = loginSt;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public Integer getIsSystemUser() {
		return isSystemUser;
	}

	public void setIsSystemUser(Integer isSystemUser) {
		this.isSystemUser = isSystemUser;
	}

	public String getCashCardType() {
		return cashCardType;
	}

	public void setCashCardType(String cashCardType) {
		this.cashCardType = cashCardType;
	}

	public String getSaleCardType() {
		return saleCardType;
	}

	public void setSaleCardType(String saleCardType) {
		this.saleCardType = saleCardType;
	}

	public Integer getPrivilegeLogon() {
		return privilegeLogon;
	}

	public void setPrivilegeLogon(Integer privilegeLogon) {
		this.privilegeLogon = privilegeLogon;
	}

	public Integer getYearCheck() {
		return yearCheck;
	}

	public void setYearCheck(Integer yearCheck) {
		this.yearCheck = yearCheck;
	}

	public String getCheckBeginDay() {
		return checkBeginDay;
	}

	public void setCheckBeginDay(String checkBeginDay) {
		this.checkBeginDay = checkBeginDay;
	}

	public String getCheckEndDay() {
		return checkEndDay;
	}

	public void setCheckEndDay(String checkEndDay) {
		this.checkEndDay = checkEndDay;
	}

	public String getThemes() {
		return themes;
	}

	public void setThemes(String themes) {
		this.themes = themes;
	}

	public Integer getVer() {
		return ver;
	}

	public void setVer(Integer ver) {
		this.ver = ver;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getExceptiveEmp() {
		return exceptiveEmp;
	}

	public void setExceptiveEmp(Integer exceptiveEmp) {
		this.exceptiveEmp = exceptiveEmp;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getCustomerUnitCode() {
		return customerUnitCode;
	}

	public void setCustomerUnitCode(String customerUnitCode) {
		this.customerUnitCode = customerUnitCode;
	}

	public Integer getBankCode() {
		return bankCode;
	}

	public void setBankCode(Integer bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

}
