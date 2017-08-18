package cn.qipeicheng.service;

import java.util.List;
import java.util.Map;

import cn.qipeicheng.entity.LogisticsTracking;
import cn.qipeicheng.entity.Participant;
import cn.qipeicheng.entity.Payment;
import cn.qipeicheng.entity.Waybill;

public interface WaybillService {
	// 运单号自动生成
	public int getRunnum();

	// 检查运单号是否重复
	public int checkRunnum(String runnum);

	// 登记接件
	public void InsertWaybill(Waybill waybill, Participant participant, Payment payment, LogisticsTracking lt);

	// 物流查询 超级管理员 会计
	public List<Map<String, Object>> selectWaybill(Map<String, String> parameters);

	// 物流查询 业务员
	public List<Map<String, Object>> selectWaybillClient(Map<String, String> parameters);

	// 物流查询 - 删除
	public void deleteWaybill(Integer id);
	// 物流查询 - 回退上一步
	public void fallbackWaybill(Integer id);
	// 物流查询 - 修改代收款
	public void updateCollectionPayment(Integer id, Double collectionPayment);

	// 跟踪查询 超级管理员 会计
	public Map<String, List<Map<String, Object>>> logisticsQuery(String runnum);

	// 跟踪查询 业务员
	public Map<String, List<Map<String, Object>>> logisticsQueryClient(String runnum, String adminId);

	// 查询未装车托运单
	public List<Map<String, Object>> prepareLoading(String adminId);

	// 根据运单号查询未装车托运单
	public List<Map<String, Object>> prepareLoadingByRunnum(String adminId, String runnum);

	// 按照接收地汇总
	public List<Map<String, Object>> selectByDestination(String adminId);

	// 按照接收地汇总明细
	public List<Map<String, Object>> selectByDestinationDetail(String destination, String adminId);

	// 修改参与双方还信息
	public void updateParticipant(Map<String, Object> map);

	// 核对装车
	public void loaded(String[] id);

	// 取货
	public void pickup(String id, Double money, Double arrears);

	// 根据运单号查询信息
	public Map<String, Object> selectByRunnum(String runnum);

	// 根据运单号查询信息
	public Map<String, Object> selectByRunnumStatus(String runnum);

	// 根据id 获取 客户信息
	public Map<String, Object> selectById(Integer Id, String inf);

	// 未取退回
	public void salesReturn(Integer id, Double collectionPayment);

	// 上传前核对
	public List<Map<String, Object>> uploadCheck(Integer[] id);

	// 付代收款
	public void payment(int[] id);

	// 卸车
	public String unload(Integer id, String remarks);

	// 获取adminId
	public String getAdminId(String runnum);

	// 得到运单信息根据运单号
	public Map<String, Object> getWayInfoByRunnum(String runnum);

	// 核对装车 查询 单个信息
	public Map<String, Object> getWayInfoRunnum(String runnum);

	// 获取收件方和应收款
	public Map<String, Object> selectMoney(Integer id);
}
