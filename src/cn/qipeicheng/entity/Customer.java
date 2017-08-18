package cn.qipeicheng.entity;

import cn.qipeicheng.util.excel.ExportConfig;


/**
 * 客户信息
 */
public class Customer {
	// 客户ID
	private int id;
	// 客户名称
	private String customerName;
	// 客户地址
	private String customerAddress;
	// 客户电话
	private String customerPhone;
	// 客户联系人
	private String customerContacts;
	private String code;
	// 银行卡号
	private String bankCard;
	// 地区ID
	private Integer regionId;
	//地区名称
	private String regionName;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the customerAddress
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}
	/**
	 * @param customerAddress the customerAddress to set
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	/**
	 * @return the customerPhone
	 */
	public String getCustomerPhone() {
		return customerPhone;
	}
	/**
	 * @param customerPhone the customerPhone to set
	 */
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	/**
	 * @return the customerContacts
	 */
	public String getCustomerContacts() {
		return customerContacts;
	}
	/**
	 * @param customerContacts the customerContacts to set
	 */
	public void setCustomerContacts(String customerContacts) {
		this.customerContacts = customerContacts;
	}
	/**
	 * @return the bankCard
	 */
	public String getBankCard() {
		return bankCard;
	}
	/**
	 * @param bankCard the bankCard to set
	 */
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}
	/**
	 * @return the regionId
	 */
	public Integer getRegionId() {
		return regionId;
	}
	/**
	 * @param regionId the regionId to set
	 */
	public void setRegionId(String regionId) {
		this.regionId = Integer.parseInt(regionId);
	}
	/**
	 * @return the regionName
	 */
	public String getRegionName() {
		return regionName;
	}
	/**
	 * @param regionName the regionName to set
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

}