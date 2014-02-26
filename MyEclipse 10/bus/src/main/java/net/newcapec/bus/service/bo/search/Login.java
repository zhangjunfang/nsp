package net.newcapec.bus.service.bo.search;

/**
 * 用户登陆Bo对象
 *
 * @author 黄鑫
 *
 */
public class Login implements java.io.Serializable {

	private static final long serialVersionUID = 8303579150079978420L;

	/**
	 * 客户组织帐号
	 */
	private String legalPerson;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
