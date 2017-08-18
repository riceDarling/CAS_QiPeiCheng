package cn.qipeicheng.dao;

import java.util.List;
import java.util.Map;


import cn.qipeicheng.entity.LogisticsTracking;

public interface LogisticsTrackingDao {

	/**
	 * 添加运单状态信息
	 * 
	 * @param logisticsTracking
	 */
	public void insertInformation(LogisticsTracking logisticsTracking);

	/**
	 * 查询运单跟踪信息 超级管理员 会计
	 */
	public List<Map<String, Object>> selectInformation(String runnum);

	/**
	 * 删除信息
	 */
	public void deleteInformation(Integer id);
	/**
	 * 删除回退信息
	 */
	public void deletefallbackInformation(Integer id);
}
