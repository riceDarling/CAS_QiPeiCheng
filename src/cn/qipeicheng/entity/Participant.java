package cn.qipeicheng.entity;

/**
 * 参与者
 */
public class Participant {
	private Integer id;
	// 运单id
	private Integer waybillId;
	// 托运方
	private String shipper="";
	// 托运地址
	private String shipperAddress="";
	// 托运电话
	private String shipperPhone="";
	// 托运联系人
	private String shipperContacts="";
	// 接收方
	private String receiver="";
	// 接收地址
	private String receiverAddress="";
	// 接收电话
	private String receiverPhone="";
	// 接收联系人
	private String receiverContacts="";
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
	 * @return the waybillId
	 */
	public Integer getWaybillId() {
		return waybillId;
	}
	/**
	 * @param waybillId the waybillId to set
	 */
	public void setWaybillId(Integer waybillId) {
		this.waybillId = waybillId;
	}
	/**
	 * @return the shipper
	 */
	public String getShipper() {
		return shipper;
	}
	/**
	 * @param shipper the shipper to set
	 */
	public void setShipper(String shipper) {
		this.shipper = shipper;
	}
	/**
	 * @return the shipperAddress
	 */
	public String getShipperAddress() {
		return shipperAddress;
	}
	/**
	 * @param shipperAddress the shipperAddress to set
	 */
	public void setShipperAddress(String shipperAddress) {
		this.shipperAddress = shipperAddress;
	}
	/**
	 * @return the shipperPhone
	 */
	public String getShipperPhone() {
		return shipperPhone;
	}
	/**
	 * @param shipperPhone the shipperPhone to set
	 */
	public void setShipperPhone(String shipperPhone) {
		this.shipperPhone = shipperPhone;
	}
	/**
	 * @return the shipperContacts
	 */
	public String getShipperContacts() {
		return shipperContacts;
	}
	/**
	 * @param shipperContacts the shipperContacts to set
	 */
	public void setShipperContacts(String shipperContacts) {
		this.shipperContacts = shipperContacts;
	}
	/**
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}
	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	/**
	 * @return the receiverAddress
	 */
	public String getReceiverAddress() {
		return receiverAddress;
	}
	/**
	 * @param receiverAddress the receiverAddress to set
	 */
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	/**
	 * @return the receiverPhone
	 */
	public String getReceiverPhone() {
		return receiverPhone;
	}
	/**
	 * @param receiverPhone the receiverPhone to set
	 */
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	/**
	 * @return the receiverContacts
	 */
	public String getReceiverContacts() {
		return receiverContacts;
	}
	/**
	 * @param receiverContacts the receiverContacts to set
	 */
	public void setReceiverContacts(String receiverContacts) {
		this.receiverContacts = receiverContacts;
	}

	
}