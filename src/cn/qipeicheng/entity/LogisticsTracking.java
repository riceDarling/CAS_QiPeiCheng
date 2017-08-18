package cn.qipeicheng.entity;

/**
 * 跟踪查询
 */
public class LogisticsTracking {
	private Integer id;
	// 运单号
	private String runnum;
	// 跟踪日期
	private String date;
	// 跟踪信息（备注）
	private String information;
	// 状态 (1.未装车2.已装车在途中（未卸车）3.已卸车（没有代收款）
	// 4.取货（没有代收款）5.取货（还未付代收款）6.已付代收款7.退货（不含退单）8.退货（含退单）)
	private String status;
	//运单id
	private Integer waybillId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRunnum() {
		return runnum;
	}

	public void setRunnum(String runnum) {
		this.runnum = runnum == null ? null : runnum.trim();
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information == null ? null : information.trim();
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public Integer getWaybillId() {
		return waybillId;
	}

	public void setWaybillId(Integer waybillId) {
		this.waybillId = waybillId;
	}
	
}