package cn.qipeicheng.entity;

/**
 * 管理员
 */
public class Admin {
	// 管理员ID
	private Integer id;
	// 管理员名称
	private String adminName;
	// 管理员密码
	private String adminPwd;
	// 权限(超级管理员，普通用户,会计)
	private String power;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the adminName
	 */
	public String getAdminName() {
		return adminName;
	}
	/**
	 * @param adminName the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	/**
	 * @return the adminPwd
	 */
	public String getAdminPwd() {
		return adminPwd;
	}
	/**
	 * @param adminPwd the adminPwd to set
	 */
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	/**
	 * @return the power
	 */
	public String getPower() {
		return power;
	}
	/**
	 * @param power the power to set
	 */
	public void setPower(String power) {
		this.power = power;
	}
}