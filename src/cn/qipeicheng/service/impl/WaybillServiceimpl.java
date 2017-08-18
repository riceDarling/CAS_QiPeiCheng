package cn.qipeicheng.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qipeicheng.dao.LogisticsTrackingDao;
import cn.qipeicheng.dao.ParticipantDao;
import cn.qipeicheng.dao.PaymentDao;
import cn.qipeicheng.dao.RegionDao;
import cn.qipeicheng.dao.WaybillDao;
import cn.qipeicheng.entity.LogisticsTracking;
import cn.qipeicheng.entity.Participant;
import cn.qipeicheng.entity.Payment;
import cn.qipeicheng.entity.Waybill;
import cn.qipeicheng.service.WaybillService;

@Service
public class WaybillServiceimpl implements WaybillService {

	@Resource
	private WaybillDao waybillDao;
	@Resource
	private RegionDao regionDao;
	@Resource
	private LogisticsTrackingDao logisticsTrackingDao;
	@Resource
	private ParticipantDao participantDao;
	@Resource
	private PaymentDao paymentDao;

	/**
	 * 登记接件
	 */
	@Transactional
	@Override
	public void InsertWaybill(Waybill waybill, Participant participant, Payment payment, LogisticsTracking lt) {
		// 向运单表插入信息
		waybill.setStatus("1");
		waybill.setWayDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		waybillDao.insertWaybill(waybill);
		// 获取 waybillId
		Integer waybillId = waybill.getId();
		// 向参与者表添加数据
		participant.setWaybillId(waybillId);
		participantDao.insertParticipant(participant);
		// 向付款表中添加数据
		payment.setWaybillId(waybillId);
		paymentDao.insertPayment(payment);
		// 向跟踪表中插入信息
		lt.setWaybillId(waybillId);
		lt.setRunnum(waybill.getRunnum());
		lt.setInformation("<" + waybill.getConsignment() + ">已收件");
		lt.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		lt.setStatus("1");
		logisticsTrackingDao.insertInformation(lt);
	}

	/**
	 * 物流查询 超级管理员 会计
	 */
	@Override
	public List<Map<String, Object>> selectWaybill(Map<String, String> parameters) {

		return waybillDao.selectWaybill(parameters);
	}

	/**
	 * 物流查询 业务员
	 */
	@Override
	public List<Map<String, Object>> selectWaybillClient(Map<String, String> parameters) {

		return waybillDao.selectWaybillClient(parameters);
	}

	/**
	 * 物流查询 - 删除
	 */
	@Transactional
	@Override
	public void deleteWaybill(Integer id) {
		waybillDao.deleteWaybill(id);
		logisticsTrackingDao.deleteInformation(id);
		participantDao.deleteParticipant(id);
		paymentDao.deletePayment(id);
	}
	/**
	 * 物流查询 - 回退上一步
	 */
	@Transactional
	@Override
	public void fallbackWaybill(Integer id) {
		logisticsTrackingDao.deletefallbackInformation(id);
		waybillDao.fallbackWaybill(id);
	}

	/**
	 * 物流查询 - 修改代收款
	 */
	@Override
	public void updateCollectionPayment(Integer id, Double collectionPayment) {
		paymentDao.updateCollectionPayment(id, collectionPayment);
	}

	/**
	 * 跟踪查询 超级管理员 会计
	 */
	@Transactional
	@Override
	public Map<String, List<Map<String, Object>>> logisticsQuery(String runnum) {
		Map<String, List<Map<String, Object>>> result = new HashMap<String, List<Map<String, Object>>>();
		List<Map<String, Object>> waybill = waybillDao.logisticsQueryWaybill(runnum);
		if (!waybill.isEmpty()) {
			List<Map<String, Object>> logistics = logisticsTrackingDao.selectInformation(runnum);
			result.put("waybill", waybill);
			result.put("logistics", logistics);
		}
		return result;
	}

	/**
	 * 跟踪查询 业务员
	 */
	@Transactional
	@Override
	public Map<String, List<Map<String, Object>>> logisticsQueryClient(String runnum, String adminId) {
		Map<String, List<Map<String, Object>>> result = new HashMap<String, List<Map<String, Object>>>();
		List<Map<String, Object>> waybill = waybillDao.logisticsQueryWaybillClient(runnum, adminId);
		if (!waybill.isEmpty()) {
			List<Map<String, Object>> logistics = logisticsTrackingDao.selectInformation(runnum);
			result.put("waybill", waybill);
			result.put("logistics", logistics);
		}
		return result;
	}

	/**
	 * 查询未装车托运单
	 */
	@Override
	public List<Map<String, Object>> prepareLoading(String adminId) {

		return waybillDao.prepareLoading(adminId);

	}

	/**
	 * 按照接收地汇总
	 */
	@Override
	public List<Map<String, Object>> selectByDestination(String adminId) {
		return waybillDao.selectByDestinationO(adminId);
	}

	/**
	 * 按照接地汇总明细
	 */
	@Override
	public List<Map<String, Object>> selectByDestinationDetail(String destination, String adminId) {
		return waybillDao.selectByDestinationDetail(destination, adminId);
	}

	/**
	 * 修改托运方信息
	 */
	@Override
	public void updateParticipant(Map<String, Object> map) {
		if (map.containsKey("shipper")) {
			participantDao.updateShipper(map);
		} else if (map.containsKey("receiver")) {
			participantDao.updateReceiver(map);
		}
	}

	/**
	 * 核对装车
	 */
	@Override
	public void loaded(String[] id) {
		if (id.length != 0) {
			for (String x : id) {
				Integer i = Integer.parseInt(x);
				if (!waybillDao.getStatus(i).equals("1")) {
					throw new RuntimeException();
				}
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("status", 2);
				map.put("id", x);
				waybillDao.updateStatus(map);
				LogisticsTracking logisticsTracking = new LogisticsTracking();
				logisticsTracking.setRunnum((String) waybillDao.selectReceiverById(Integer.parseInt(x)).get("runnum"));
				logisticsTracking.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				logisticsTracking.setInformation("已装车");
				logisticsTracking.setWaybillId(Integer.parseInt(x));
				logisticsTracking.setStatus("2");
				logisticsTrackingDao.insertInformation(logisticsTracking);
			}
		}

	}

	/**
	 * 客户取货
	 */
	@Transactional
	@Override
	public void pickup(String id, Double money, Double arrears) {
		// id
		Integer i = Integer.parseInt(id);
		// 获取代收款
		Map<String, Object> co = paymentDao.selectPaymentById(i);
		Double collectionPayment = (Double) co.get("collectionPayment");
		// 判断是否有代收
		if (collectionPayment == 0.0) {
			LogisticsTracking logisticsTracking = new LogisticsTracking();
			logisticsTracking.setRunnum((String) waybillDao.selectReceiverById(Integer.parseInt(id)).get("runnum"));
			logisticsTracking.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			logisticsTracking.setWaybillId(i);
			logisticsTracking.setInformation("已取货，无代收款");
			logisticsTracking.setStatus("4");
			// 更新跟踪信息
			logisticsTrackingDao.insertInformation(logisticsTracking);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", i);
			map.put("status", "4");
			// 更新运单 装填信息
			waybillDao.updateStatus(map);
		} else {
			LogisticsTracking logisticsTracking = new LogisticsTracking();
			logisticsTracking.setRunnum((String) waybillDao.selectReceiverById(Integer.parseInt(id)).get("runnum"));
			logisticsTracking.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			logisticsTracking.setWaybillId(i);
			if (arrears == 0.0) {
				logisticsTracking.setInformation("已取货，付款 " + co.get("sum") + "--代收款" + co.get("collectionPayment") + "--运费" + co.get("freight"));
			} else {
				logisticsTracking.setInformation("已取货，付款 :" + money + ",欠款:" + arrears);
				Map<String, Object> paymentMap = new HashMap<String, Object>();
				paymentMap.put("id", i);
				paymentMap.put("receiverArrears", arrears);
				paymentDao.updateArrears(paymentMap);
			}
			logisticsTracking.setStatus("5");
			logisticsTrackingDao.insertInformation(logisticsTracking);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", i);
			map.put("status", "5");
			waybillDao.updateStatus(map);
		}

	}

	/**
	 * 根据运单号查询信息
	 */
	@Override
	public Map<String, Object> selectByRunnum(String runnum) {

		return waybillDao.selectByRunnum(runnum);
	}

	/**
	 * 根据id获取客户信息
	 */
	@Override
	public Map<String, Object> selectById(Integer Id, String inf) {

		// 根据inf 判断 是查询 托运方信息还是 收件方信息
		if (inf.equals("shipper")) {
			return waybillDao.selectShipperById(Id);
		} else if (inf.equals("receiver")) {
			return waybillDao.selectReceiverById(Id);
		} else {
			return null;
		}
	}

	/**
	 * 未取退回
	 */
	@Transactional
	@Override
	public void salesReturn(Integer id, Double collectionPayment) {
		LogisticsTracking logisticsTracking = new LogisticsTracking();
		logisticsTracking.setRunnum((String) waybillDao.selectReceiverById(id).get("runnum"));
		logisticsTracking.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		logisticsTracking.setWaybillId(id);
		logisticsTracking.setInformation("未取退回");
		logisticsTracking.setStatus("2");
		// 更新跟踪信息
		logisticsTrackingDao.insertInformation(logisticsTracking);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("status", "2");
		Map<String, Object> paymentMap = new HashMap<String, Object>();
		paymentMap.put("id", id);
		paymentMap.put("collectionPayment", collectionPayment);
		waybillDao.updateStatus(map);
		paymentDao.updateReturn(paymentMap);

	}

	/**
	 * 上传前核对
	 */
	@Override
	public List<Map<String, Object>> uploadCheck(Integer[] id) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (Integer x : id) {
			result.add(waybillDao.uploadCheck(x));
		}
		return result;
	}

	/**
	 * 付代收款
	 */
	@Override
	public void payment(int[] id) {
		for (int i = 0; i < id.length; i++) {
			LogisticsTracking logisticsTracking = new LogisticsTracking();
			logisticsTracking.setRunnum((String) waybillDao.selectReceiverById(id[i]).get("runnum"));
			logisticsTracking.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			logisticsTracking.setWaybillId(id[i]);
			logisticsTracking.setInformation("已付代收款" + (Double)paymentDao.selectPaymentById(id[i]).get("collectionPayment") + "元");
			logisticsTracking.setStatus("6");
			// 更新跟踪信息
			logisticsTrackingDao.insertInformation(logisticsTracking);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id[i]);
			map.put("status", "6");
			waybillDao.updateStatus(map);
			Map<String, Object> paymentMap = new HashMap<String, Object>();
			paymentMap.put("id", id[i]);
			paymentMap.put("paid", (Double)paymentDao.selectPaymentById(id[i]).get("collectionPayment"));
			paymentDao.updatePaid(paymentMap);
		}
	}

	/**
	 * 卸车
	 */
	@Override
	public String unload(Integer id, String remarks) {
		String status = waybillDao.getStatus(id);
		if (status.equals("3")) {
			return "该运单已卸车";
		} else if (status.equals("2")) {
			LogisticsTracking logisticsTracking = new LogisticsTracking();
			logisticsTracking.setRunnum((String) waybillDao.selectReceiverById(id).get("runnum"));
			logisticsTracking.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			logisticsTracking.setInformation("已卸车" + "---" + remarks);
			logisticsTracking.setWaybillId(id);
			logisticsTracking.setStatus("3");
			// 更新跟踪信息
			logisticsTrackingDao.insertInformation(logisticsTracking);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("status", "3");
			waybillDao.updateStatus(map);
			waybillDao.updateRemarks(remarks);
			return null;
		} else {
			return "请检查运单状态";
		}

	}

	/**
	 * 根据运单号获取adminId
	 */
	@Override
	public String getAdminId(String runnum) {

		return waybillDao.getAdminId(runnum);
	}

	@Override
	public Map<String, Object> getWayInfoByRunnum(String runnum) {
		return waybillDao.getWayInfoByRunnum(runnum);
	}

	@Override
	public Map<String, Object> selectByRunnumStatus(String runnum) {
		return waybillDao.selectByRunnumStatus(runnum);
	}

	@Override
	public Map<String, Object> getWayInfoRunnum(String runnum) {
		Map<String, Object> map = waybillDao.getWayInfoByRunnum(runnum);
		Integer id = (Integer) map.get("id");
		if (!waybillDao.getStatus(id).equals("1")) {
			throw new RuntimeException();
		}
		return map;
	}

	// 获取收件方和应收款
	@Override
	public Map<String, Object> selectMoney(Integer id) {

		return waybillDao.selectMoney(id);
	}

	@Override
	public List<Map<String, Object>> prepareLoadingByRunnum(String adminId, String runnum) {
		return waybillDao.prepareLoadingByRunnum(adminId, runnum);
	}
	@Override
	public int checkRunnum(String runnum) {
		return waybillDao.checkRunnum(runnum);
	}
	@Override
	public int getRunnum() {
		return waybillDao.getRunnum();
	}

}
