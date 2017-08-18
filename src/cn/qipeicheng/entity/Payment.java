package cn.qipeicheng.entity;

/**
 * 付款
 */
public class Payment {
	private Integer id;
	// 运单id
	private Integer waybillId;
	// 货物值
	private Double cargovalue=0.0;
	// 工本费
	private Double fee=0.0;
	// 保险费
	private Double premium=0.0;
	// 手续费
	private Double counterFee=0.0;
	// 送货费
	private Double deliveryCharges=0.0;
	// 服务费
	private Double serviceCharge=0.0;
	// 运费
	private Double freight=0.0;
	// 接收方合计
	private Double receiverTotal=6.0;
	// 已付款
	private Double paid=0.0;
	// 接方欠款（欠代收款）
	private Double receiverArrears=0.0;
	// 原代收款
	private Double collectionPayment=0.0;
	// 现代收款
	private Double modernCollection=0.0;
	// 接收方付费
	private Double receiverPay=0.0;
	// 托运方付费
	private Double shipperPay=0.0;
	// 退货件数
	private Integer returnGoods=0;
	// 退货额
	private Double returnMoney=0.0;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param waybillId
	 *            the waybillId to set
	 */
	public void setWaybillId(Integer waybillId) {
		this.waybillId = waybillId;
	}

	/**
	 * @return the cargovalue
	 */
	public Double getCargovalue() {
		return cargovalue;
	}

	/**
	 * @param cargovalue
	 *            the cargovalue to set
	 */
	public void setCargovalue(Double cargovalue) {
		this.cargovalue = cargovalue;
	}

	/**
	 * @return the fee
	 */
	public Double getFee() {
		return fee;
	}

	/**
	 * @param fee
	 *            the fee to set
	 */
	public void setFee(Double fee) {
		this.fee = fee;
	}

	/**
	 * @return the premium
	 */
	public Double getPremium() {
		return premium;
	}

	/**
	 * @param premium
	 *            the premium to set
	 */
	public void setPremium(Double premium) {
		this.premium = premium;
	}

	/**
	 * @return the counterFee
	 */
	public Double getCounterFee() {
		return counterFee;
	}

	/**
	 * @param counterFee
	 *            the counterFee to set
	 */
	public void setCounterFee(Double counterFee) {
		this.counterFee = counterFee;
	}

	/**
	 * @return the deliveryCharges
	 */
	public Double getDeliveryCharges() {
		return deliveryCharges;
	}

	/**
	 * @param deliveryCharges
	 *            the deliveryCharges to set
	 */
	public void setDeliveryCharges(Double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	/**
	 * @return the serviceCharge
	 */
	public Double getServiceCharge() {
		return serviceCharge;
	}

	/**
	 * @param serviceCharge
	 *            the serviceCharge to set
	 */
	public void setServiceCharge(Double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	/**
	 * @return the freight
	 */
	public Double getFreight() {
		return freight;
	}

	/**
	 * @param freight
	 *            the freight to set
	 */
	public void setFreight(Double freight) {
		this.freight = freight;
	}

	/**
	 * @return the receiverTotal
	 */
	public Double getReceiverTotal() {
		return receiverTotal;
	}

	/**
	 * @param receiverTotal
	 *            the receiverTotal to set
	 */
	public void setReceiverTotal(Double receiverTotal) {
		this.receiverTotal = receiverTotal;
	}

	/**
	 * @return the paid
	 */
	public Double getPaid() {
		return paid;
	}

	/**
	 * @param paid
	 *            the paid to set
	 */
	public void setPaid(Double paid) {
		this.paid = paid;
	}

	/**
	 * @return the receiverArrears
	 */
	public Double getReceiverArrears() {
		return receiverArrears;
	}

	/**
	 * @param receiverArrears
	 *            the receiverArrears to set
	 */
	public void setReceiverArrears(Double receiverArrears) {
		this.receiverArrears = receiverArrears;
	}

	/**
	 * @return the collectionPayment
	 */
	public Double getCollectionPayment() {
		return collectionPayment;
	}

	/**
	 * @param collectionPayment
	 *            the collectionPayment to set
	 */
	public void setCollectionPayment(Double collectionPayment) {
		this.collectionPayment = collectionPayment;
	}

	/**
	 * @return the modernCollection
	 */
	public Double getModernCollection() {
		return modernCollection;
	}

	/**
	 * @param modernCollection
	 *            the modernCollection to set
	 */
	public void setModernCollection(Double modernCollection) {
		this.modernCollection = modernCollection;
	}

	/**
	 * @return the receiverPay
	 */
	public Double getReceiverPay() {
		return receiverPay;
	}

	/**
	 * @param receiverPay the receiverPay to set
	 */
	public void setReceiverPay(Double receiverPay) {
		this.receiverPay = receiverPay;
	}

	/**
	 * @return the shipperPay
	 */
	public Double getShipperPay() {
		return shipperPay;
	}

	/**
	 * @param shipperPay the shipperPay to set
	 */
	public void setShipperPay(Double shipperPay) {
		this.shipperPay = shipperPay;
	}

	/**
	 * @return the returnGoods
	 */
	public Integer getReturnGoods() {
		return returnGoods;
	}

	/**
	 * @param returnGoods the returnGoods to set
	 */
	public void setReturnGoods(Integer returnGoods) {
		this.returnGoods = returnGoods;
	}

	/**
	 * @return the returnMoney
	 */
	public Double getReturnMoney() {
		return returnMoney;
	}

	/**
	 * @param returnMoney the returnMoney to set
	 */
	public void setReturnMoney(Double returnMoney) {
		this.returnMoney = returnMoney;
	}
	
}