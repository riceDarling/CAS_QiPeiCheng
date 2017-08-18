package cn.qipeicheng.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.qipeicheng.entity.Waybill;

public interface WaybillDao {

	// 添加运单
	public void insertWaybill(Waybill waybill);

	// 运单号自动生成
	public int getRunnum();

	// 检查运单号是否重复
	public int checkRunnum(String runnum);

	// 查询运单 超级管理员 会计
	public List<Map<String, Object>> selectWaybill(Map<String, String> parameters);

	// 查询运单 业务员
	public List<Map<String, Object>> selectWaybillClient(Map<String, String> parameters);

	// 物流查询 - 删除
	public void deleteWaybill(Integer runnum);
	// 物流查询 - 回退上一步
	public void fallbackWaybill(Integer runnum);
	// 跟踪查询 超级管理员 会计
	public List<Map<String, Object>> logisticsQueryWaybill(String runnum);

	// 跟踪查询 业务员
	public List<Map<String, Object>> logisticsQueryWaybillClient(@Param("runnum") String runnum, @Param("adminId") String adminId);

	// 查询未装车托运单
	public List<Map<String, Object>> prepareLoading(String adminId);

	// 根据运单号查询未装车托运单
	public List<Map<String, Object>> prepareLoadingByRunnum(@Param("adminId") String adminId, @Param("runnum") String runnum);

	// 按照接收地汇总
	public List<Map<String, Object>> selectByDestinationO(String adminId);

	// 按照接收地汇总明细
	public List<Map<String, Object>> selectByDestinationDetail(String destination, String adminId);

	// 修改运单状态
	public void updateStatus(Map<String, Object> map);

	// 根据运单号查询信息
	public Map<String, Object> selectByRunnum(String runnum);

	// 根据运单号查询信息
	public Map<String, Object> selectByRunnumStatus(String runnum);

	// 根据id查询托运方信息
	public Map<String, Object> selectShipperById(Integer Id);

	// 根据id查询收件方信息
	public Map<String, Object> selectReceiverById(Integer Id);

	// 上传前核对
	public Map<String, Object> uploadCheck(Integer id);

	// 获取运单装态
	public String getStatus(Integer id);

	// 更新备注
	public void updateRemarks(String remarks);

	// 获取该运单操作员id
	public String getAdminId(String runnum);

	// 得到运单信息根据运单号
	public Map<String, Object> getWayInfoByRunnum(String runnum);

	// 获取收件方和应收款
	public Map<String, Object> selectMoney(Integer id);
}
