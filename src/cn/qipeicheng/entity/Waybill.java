package cn.qipeicheng.entity;

/**
 * 运单信息
 */
public class Waybill {
	private Integer id;
	// 运单号
	private String runnum;
	// 托运地
	private String consignment="";
	// 目的地
	private String destination="";
	// 总件数
	private Integer total=0;
	// 笔数 
	private Integer number=1;
	// 重量
	private Double weight=0.0;
	// 体积
	private Double volume=0.0;
	// 收件方式（1.自提，2.送货上门）
	private String model;
	// 付费方式（1.托运方付费2.收件方付费3.托运方月结）
	private String payer;
	// 备注
	private String remarks="";
	// （运输方式：1.汽运，2.火车，3.飞机）
	private String transportAtion;
	// 收货员
	private String deliveryMan="";
	// 状态 (1.未装车2.已装车在途中（未卸车）3.已卸车（没有代收款）
	// 4.取货（没有代收款）5.取货（还未付代收款）6.已付代收款  7.退货)
	private String status;
	//运单时间
	private String wayDate;
	//网络协作
	private String network="";
	//操作员ID
	private String adminId; 
	
	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getRunnum() {
		return runnum;
	}

	public void setRunnum(String runnum) {
		this.runnum = runnum == null ? null : runnum.trim();
	}

	public String getConsignment() {
		return consignment;
	}

	public void setConsignment(String consignment) {
		this.consignment = consignment == null ? null : consignment.trim();
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination == null ? null : destination.trim();
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model == null ? null : model.trim();
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer == null ? null : payer.trim();
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}

	/**
	 * @return the transportAtion
	 */
	public String getTransportAtion() {
		return transportAtion;
	}

	/**
	 * @param transportAtion the transportAtion to set
	 */
	public void setTransportAtion(String transportAtion) {
		this.transportAtion = transportAtion;
	}

	/**
	 * @return the deliveryMan
	 */
	public String getDeliveryMan() {
		return deliveryMan;
	}

	/**
	 * @param deliveryMan the deliveryMan to set
	 */
	public void setDeliveryMan(String deliveryMan) {
		this.deliveryMan = deliveryMan;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	/**
	 * @return the wayDate
	 */
	public String getWayDate() {
		return wayDate;
	}

	/**
	 * @param wayDate the wayDate to set
	 */
	public void setWayDate(String wayDate) {
		this.wayDate = wayDate;
	}
	
}