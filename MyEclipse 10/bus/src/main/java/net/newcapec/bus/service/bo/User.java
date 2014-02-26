package net.newcapec.bus.service.bo;

/**
 *
 * @author 黄鑫
 *
 */
public class User implements java.io.Serializable{

	private static final long serialVersionUID = -400637522873300274L;

	private String username;
	private int sex;
	private String realname;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}


}
