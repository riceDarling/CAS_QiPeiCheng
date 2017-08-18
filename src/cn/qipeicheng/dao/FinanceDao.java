package cn.qipeicheng.dao;

import java.util.List;
import java.util.Map;

public interface FinanceDao {
	/**
	 * 装车报表-未装车单
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> loadingReportUnbound(Map<String, Object> map);

	/**
	 * 装车报表-托运方付运费列表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> loadingReportShipper(Map<String, Object> map);

	/**
	 * 装车报表-接收方付运费列表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> loadingReportReceiver(Map<String, Object> map);

	/**
	 * 综合报表-收件汇总
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> synthesizeReportPickup(Map<String, Object> map);

	/**
	 * 综合报表-收件汇总明细
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> synthesizeReportPickupInfos(Map<String, Object> map);

	/**
	 * 综合报表-装车汇总
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> synReportLoading(Map<String, Object> map);

	/**
	 * 综合报表-装车汇总明细
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> synReportLoadingInfos(Map<String, Object> map);

	/**
	 * 综合报表-卸车汇总
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> synReportUpload(Map<String, Object> map);

	/**
	 * 综合报表-卸车汇总明细
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> synReportUploadInfos(Map<String, Object> map);

	/**
	 * 综合报表-取件汇总
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> synReportTake(Map<String, Object> map);

	/**
	 * 综合报表-取件汇总明细
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> synReportTakeInfos(Map<String, Object> map);

	/**
	 * 综合报表-付代收款汇总
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> synReportPayforCol(Map<String, Object> map);

	/**
	 * 综合报表-付代收款汇总明细
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> synReportPayforColInfos(Map<String, Object> map);

	/**
	 * 代收款汇总-按托运地汇总
	 * 
	 * @return
	 */
	List<Map<String, Object>> forCollectionSumByConsignment(Map<String, Object> map);

	/**
	 * 代收款汇总-按托运地汇总明细
	 * 
	 * @return
	 */
	List<Map<String, Object>> forCollectionSumByConsignmentInfos(Map<String, Object> map);

	/**
	 * 代收款汇总-按接收地汇总
	 * 
	 * @return
	 */
	List<Map<String, Object>> forCollectionSumByDestination(Map<String, Object> map);

	/**
	 * 代收款汇总-按接收地汇总明细
	 * 
	 * @return
	 */
	List<Map<String, Object>> forCollectionSumByDestinationInfos(Map<String, Object> map);

	/**
	 * 代收款汇总-按托运方汇总
	 * 
	 * @return
	 */
	List<Map<String, Object>> forCollectionSumByShipper(Map<String, Object> map);

	/**
	 * 代收款汇总-按托运方汇总明细
	 * 
	 * @return
	 */
	List<Map<String, Object>> forCollectionSumByShipperInfos(Map<String, Object> map);

	/**
	 * 收款报表-按托运方汇总
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> receivingReportSumByShipper(Map<String, Object> map);

	/**
	 * 收款报表-按托运方汇总明细
	 * 
	 * @return
	 */
	List<Map<String, Object>> receivingReportSumByShipperInfos(Map<String, Object> map);

	/**
	 * 收款报表-按日期汇总
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> receivingReportSumByDate(Map<String, Object> map);

	/**
	 * 收款报表-按日期汇总明细
	 * 
	 * @return
	 */
	List<Map<String, Object>> receivingReportSumByDateInfos(Map<String, Object> map);

	/**
	 * 收款报表-全部运单列表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getAllWaybillList(Map<String, Object> map);

	/**
	 * 收款报表-托运方付运费列表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getAllShipperPayList(Map<String, Object> map);

	/**
	 * 收款报表-按接收方汇总
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> receivingReportSumByReceiver(Map<String, Object> map);

	/**
	 * 收款报表-按接收方汇总明细
	 * 
	 * @return
	 */
	List<Map<String, Object>> receivingReportSumByReceiverInfos(Map<String, Object> map);

	/**
	 * 收款报表-按日期-方向汇总
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> receivingReportSumByDateDirection(Map<String, Object> map);

	/**
	 * 收款报表-按日期-方向汇总明细
	 * 
	 * @return
	 */
	List<Map<String, Object>> receivingReportSumByDateDirectionInfos(Map<String, Object> map);

	/**
	 * 收款报表-退货列表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getAllReturnList(Map<String, Object> map);

	/**
	 * 收款报表-接收方付运费列表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getAllReceiverPayList(Map<String, Object> map);

	/**
	 * 欠代收款报表--按取货时间汇总
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> oweForColByDate(Map<String, Object> map);

	/**
	 * 欠代收款报表--按取货时间汇总明细
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> oweForColByDateInfos(Map<String, Object> map);

	/**
	 * 欠代收款报表--按托运方汇总
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> oweForColByShipper(Map<String, Object> map);

	/**
	 * 欠代收款报表--按托运方汇总明细
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> oweForColByShipperInfos(Map<String, Object> map);

	/**
	 * 欠代收款报表--明细表
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> oweForColSchedule(Map<String, Object> map);

	/**
	 * 欠代收款报表--明细表 --根据运单号查询
	 * 
	 * @param runnum
	 * @return
	 */
	List<Map<String, Object>> oweForColScheduleByRunnum(String runnum);

	/**
	 * 付代收款报表--按日期汇总
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> payforColByDate(Map<String, Object> map);

	/**
	 * 付代收款报表--按日期汇总明细
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> payforColByDateInfos(Map<String, Object> map);

	/**
	 * 付代收款报表--按日期发送方向汇总
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> payforColByDateDirection(Map<String, Object> map);

	/**
	 * 付代收款报表--按日期发送方向汇总明细
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> payforColByDateDirectionInfos(Map<String, Object> map);

	/**
	 * 付代收款报表--按托运方汇总
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> payforColByShipper(Map<String, Object> map);

	/**
	 * 付代收款报表--按托运方汇总明细
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> payforColByShipperInfos(Map<String, Object> map);

	/**
	 * 付代收款报表--按托运方发送方向汇总
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> payforColByShipperDirection(Map<String, Object> map);

	/**
	 * 付代收款报表--按托运方发送方向汇总明细
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> payforColByShipperDirectionInfos(Map<String, Object> map);

	/**
	 * 付代收款报表-- 付款明细
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> payforColPaymentDetail(Map<String, Object> map);

	/**
	 * 付代收款报表-付款明细 -根据运单号查询
	 * 
	 * @param runnum
	 * @return
	 */
	List<Map<String, Object>> payforColPaymentDetailByRunnum(String runnum);

	/**
	 * 代收款管理-根据运单号得到托运代收款信息
	 * 
	 * @param runnum
	 * @return
	 */
	List<Map<String, Object>> getForColInfosByRunnum(String runnum);
}
