package cn.qipeicheng.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qipeicheng.dao.FinanceDao;
import cn.qipeicheng.service.FinanceService;

@Service
public class FinanceServiceImpl implements FinanceService {
	@Autowired
	private FinanceDao financeDao;

	@Override
	public List<Map<String, Object>> forCollectionSumByConsignment(Map<String, Object> map) {
		return financeDao.forCollectionSumByConsignment(map);
	}

	@Override
	public List<Map<String, Object>> forCollectionSumByConsignmentInfos(Map<String, Object> map) {
		return financeDao.forCollectionSumByConsignmentInfos(map);
	}

	@Override
	public List<Map<String, Object>> forCollectionSumByDestination(Map<String, Object> map) {
		return financeDao.forCollectionSumByDestination(map);
	}

	@Override
	public List<Map<String, Object>> forCollectionSumByDestinationInfos(Map<String, Object> map) {
		return financeDao.forCollectionSumByDestinationInfos(map);
	}

	@Override
	public List<Map<String, Object>> forCollectionSumByShipper(Map<String, Object> map) {
		return financeDao.forCollectionSumByShipper(map);
	}

	@Override
	public List<Map<String, Object>> forCollectionSumByShipperInfos(Map<String, Object> map) {
		return financeDao.forCollectionSumByShipperInfos(map);
	}

	@Override
	public List<Map<String, Object>> receivingReportSumByShipper(Map<String, Object> map) {
		return financeDao.receivingReportSumByShipper(map);
	}

	@Override
	public List<Map<String, Object>> receivingReportSumByShipperInfos(Map<String, Object> map) {
		return financeDao.receivingReportSumByShipperInfos(map);
	}

	@Override
	public List<Map<String, Object>> receivingReportSumByDate(Map<String, Object> map) {
		return financeDao.receivingReportSumByDate(map);
	}

	@Override
	public List<Map<String, Object>> receivingReportSumByDateInfos(Map<String, Object> map) {
		return financeDao.receivingReportSumByDateInfos(map);
	}

	@Override
	public List<Map<String, Object>> getAllWaybillList(Map<String, Object> map) {
		return financeDao.getAllWaybillList(map);
	}

	@Override
	public List<Map<String, Object>> getAllShipperPayList(Map<String, Object> map) {
		return financeDao.getAllShipperPayList(map);
	}

	@Override
	public List<Map<String, Object>> receivingReportSumByReceiver(Map<String, Object> map) {
		return financeDao.receivingReportSumByReceiver(map);
	}

	@Override
	public List<Map<String, Object>> receivingReportSumByReceiverInfos(Map<String, Object> map) {
		return financeDao.receivingReportSumByReceiverInfos(map);
	}

	@Override
	public List<Map<String, Object>> receivingReportSumByDateDirection(Map<String, Object> map) {
		return financeDao.receivingReportSumByDateDirection(map);
	}

	@Override
	public List<Map<String, Object>> receivingReportSumByDateDirectionInfos(Map<String, Object> map) {
		return financeDao.receivingReportSumByDateDirectionInfos(map);
	}

	@Override
	public List<Map<String, Object>> getAllReturnList(Map<String, Object> map) {
		return financeDao.getAllReturnList(map);
	}

	@Override
	public List<Map<String, Object>> getAllReceiverPayList(Map<String, Object> map) {
		return financeDao.getAllReceiverPayList(map);
	}

	@Override
	public List<Map<String, Object>> oweForColByDate(Map<String, Object> map) {
		return financeDao.oweForColByDate(map);
	}

	@Override
	public List<Map<String, Object>> oweForColByDateInfos(Map<String, Object> map) {
		return financeDao.oweForColByDateInfos(map);
	}

	@Override
	public List<Map<String, Object>> oweForColByShipper(Map<String, Object> map) {
		return financeDao.oweForColByShipper(map);
	}

	@Override
	public List<Map<String, Object>> oweForColByShipperInfos(Map<String, Object> map) {
		return financeDao.oweForColByShipperInfos(map);
	}

	@Override
	public List<Map<String, Object>> oweForColSchedule(Map<String, Object> map) {
		return financeDao.oweForColSchedule(map);
	}

	@Override
	public List<Map<String, Object>> oweForColScheduleByRunnum(String runnum) {
		return financeDao.oweForColScheduleByRunnum(runnum);
	}

	@Override
	public List<Map<String, Object>> payforColByDate(Map<String, Object> map) {
		return financeDao.payforColByDate(map);
	}

	@Override
	public List<Map<String, Object>> payforColByDateInfos(Map<String, Object> map) {
		return financeDao.payforColByDateInfos(map);
	}

	@Override
	public List<Map<String, Object>> payforColByDateDirection(Map<String, Object> map) {
		return financeDao.payforColByDateDirection(map);
	}

	@Override
	public List<Map<String, Object>> payforColByDateDirectionInfos(Map<String, Object> map) {
		return financeDao.payforColByDateDirectionInfos(map);
	}

	@Override
	public List<Map<String, Object>> payforColByShipper(Map<String, Object> map) {
		return financeDao.payforColByShipper(map);
	}

	@Override
	public List<Map<String, Object>> payforColByShipperInfos(Map<String, Object> map) {
		return financeDao.payforColByShipperInfos(map);
	}

	@Override
	public List<Map<String, Object>> payforColByShipperDirection(Map<String, Object> map) {
		return financeDao.payforColByShipperDirection(map);
	}

	@Override
	public List<Map<String, Object>> payforColByShipperDirectionInfos(Map<String, Object> map) {
		return financeDao.payforColByShipperDirectionInfos(map);
	}

	@Override
	public List<Map<String, Object>> payforColPaymentDetail(Map<String, Object> map) {
		return financeDao.payforColPaymentDetail(map);
	}

	@Override
	public List<Map<String, Object>> loadingReportUnbound(Map<String, Object> map) {
		return financeDao.loadingReportUnbound(map);
	}

	@Override
	public List<Map<String, Object>> loadingReportShipper(Map<String, Object> map) {
		return financeDao.loadingReportShipper(map);
	}

	@Override
	public List<Map<String, Object>> loadingReportReceiver(Map<String, Object> map) {
		return financeDao.loadingReportReceiver(map);
	}

	@Override
	public List<Map<String, Object>> getForColInfosByRunnum(String runnum) {
		return financeDao.getForColInfosByRunnum(runnum);
	}

	@Override
	public List<Map<String, Object>> synthesizeReportPickup(Map<String, Object> map) {
		return financeDao.synthesizeReportPickup(map);
	}

	@Override
	public List<Map<String, Object>> synthesizeReportPickupInfos(Map<String, Object> map) {
		return financeDao.synthesizeReportPickupInfos(map);
	}

	@Override
	public List<Map<String, Object>> synReportLoading(Map<String, Object> map) {
		return financeDao.synReportLoading(map);
	}

	@Override
	public List<Map<String, Object>> synReportLoadingInfos(Map<String, Object> map) {
		return financeDao.synReportLoadingInfos(map);
	}

	@Override
	public List<Map<String, Object>> synReportUpload(Map<String, Object> map) {
		return financeDao.synReportUpload(map);
	}

	@Override
	public List<Map<String, Object>> synReportUploadInfos(Map<String, Object> map) {
		return financeDao.synReportUploadInfos(map);
	}

	@Override
	public List<Map<String, Object>> synReportTake(Map<String, Object> map) {
		return financeDao.synReportTake(map);
	}

	@Override
	public List<Map<String, Object>> synReportTakeInfos(Map<String, Object> map) {
		return financeDao.synReportTakeInfos(map);
	}

	@Override
	public List<Map<String, Object>> synReportPayforCol(Map<String, Object> map) {
		return financeDao.synReportPayforCol(map);
	}

	@Override
	public List<Map<String, Object>> synReportPayforColInfos(Map<String, Object> map) {
		return financeDao.synReportPayforColInfos(map);
	}

	@Override
	public List<Map<String, Object>> payforColPaymentDetailByRunnum(String runnum) {
		return financeDao.payforColPaymentDetailByRunnum(runnum);
	}

}
