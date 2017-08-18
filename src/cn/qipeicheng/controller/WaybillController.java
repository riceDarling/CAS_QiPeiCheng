package cn.qipeicheng.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qipeicheng.entity.Admin;
import cn.qipeicheng.entity.LogisticsTracking;
import cn.qipeicheng.entity.Participant;
import cn.qipeicheng.entity.Payment;
import cn.qipeicheng.entity.Waybill;
import cn.qipeicheng.service.WaybillService;
import cn.qipeicheng.util.ResponseModel;

@Controller
@RequestMapping("/waybill")
public class WaybillController {

	@Resource
	private WaybillService waybillService;

	/**
	 * 添加托运单 ---登记接件
	 * 
	 * @param waybill
	 * @param participant
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insertWaybill")
	public ResponseModel insertWaybill(Waybill waybill, Participant participant, Payment payment, HttpServletRequest request) {
		// 获取当前操作员
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		waybill.setAdminId(admin.getId().toString());
		// 获取代收款总计
		double acount = payment.getFee() + payment.getPremium() + payment.getCounterFee() + payment.getDeliveryCharges() + payment.getServiceCharge() + payment.getFreight();
		// 判断 付费方
		if (waybill.getPayer().equals("2")) {
			payment.setShipperPay(acount);
			payment.setReceiverPay(0.0);
		} else if (waybill.getPayer().endsWith("1")) {
			payment.setReceiverPay(acount);
			payment.setShipperPay(0.0);
		}
		LogisticsTracking lt = new LogisticsTracking();
		ResponseModel rm = new ResponseModel();
		try {
			waybillService.InsertWaybill(waybill, participant, payment, lt);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 运单号自动生成
	 */
	@ResponseBody
	@RequestMapping("/getRunnum")
	public ResponseModel getRunnum() {

		ResponseModel rm = new ResponseModel();
		int count =waybillService.getRunnum()+1;
	String counts=String.valueOf(count);
	String cos="";
	if(counts.length()<10){
		for (int i = 0; i < 10-counts.length(); i++) {
			cos+="0";
		}
		cos+=counts;
	}
	else{
		cos=counts;	
	}
		try {
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setT(cos);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 检查运单号是否重复
	 */
	@ResponseBody
	@RequestMapping("/checkRunnum")
	public ResponseModel checkRunnum(@RequestParam String runnum) {

		ResponseModel rm = new ResponseModel();
		try {
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setT(waybillService.checkRunnum(runnum));
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 物流查询 超级管理员 会计
	 */
	@ResponseBody
	@RequestMapping("/selectWaybill")
	public ResponseModel selectWaybill(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> parameters = new HashMap<String, String>();
		// 获取起始日期
		parameters.put("startDate", request.getParameter("startDate"));
		// 获取截止日期
		parameters.put("endDate", request.getParameter("endDate"));
		// 获取运单状态
		parameters.put("status", request.getParameter("status"));
		// 获取托运地
		parameters.put("consignment", request.getParameter("consignment"));
		// 获取目的地
		parameters.put("destination", request.getParameter("destination"));
		// 获取协作方
		parameters.put("network", request.getParameter("network"));

		ResponseModel rm = new ResponseModel();
		try {
			rm.setObj(waybillService.selectWaybill(parameters));
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 物流查询 业务员
	 */
	@ResponseBody
	@RequestMapping("/selectWaybillClient")
	public ResponseModel selectWaybillClient(HttpServletRequest request, HttpServletResponse response) {
		// 获取当前操作员
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("adminId", admin.getId().toString());
		// 获取起始日期
		parameters.put("startDate", request.getParameter("startDate"));
		// 获取截止日期
		parameters.put("endDate", request.getParameter("endDate"));
		// 获取运单状态
		parameters.put("status", request.getParameter("status"));
		// 获取托运地
		parameters.put("consignment", request.getParameter("consignment"));
		// 获取目的地
		parameters.put("destination", request.getParameter("destination"));
		// 获取协作方
		parameters.put("network", request.getParameter("network"));
		ResponseModel rm = new ResponseModel();
		try {
			rm.setObj(waybillService.selectWaybillClient(parameters));
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 物流查询 - 删除
	 */
	@ResponseBody
	@RequestMapping("/deleteWaybill")
	public ResponseModel deleteWaybill(@RequestParam Integer id) {

		ResponseModel rm = new ResponseModel();
		try {
			waybillService.deleteWaybill(id);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}
	/**
	 * 物流查询 - 回退上一步
	 */
	@ResponseBody
	@RequestMapping("/fallbackWaybill")
	public ResponseModel fallbackWaybill(@RequestParam Integer id) {

		ResponseModel rm = new ResponseModel();
		try {
			waybillService.fallbackWaybill(id);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}
	/**
	 * 物流查询 - 修改代收款
	 */
	@ResponseBody
	@RequestMapping("/updateCollectionPayment")
	public ResponseModel updateCollectionPayment(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Double collectionPayment = Double.parseDouble(request.getParameter("collectionPayment"));
		ResponseModel rm = new ResponseModel();
		try {
			waybillService.updateCollectionPayment(id, collectionPayment);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 物流查询 - 修改双方信息
	 */
	@ResponseBody
	@RequestMapping("/updateParticipant")
	public ResponseModel updateParticipant(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", Integer.parseInt(request.getParameter("id")));
		String shipper = request.getParameter("shipper");
		String receiver = request.getParameter("receiver");
		map.put("address", request.getParameter("address"));
		map.put("phone", request.getParameter("phone"));
		map.put("contacts", request.getParameter("contacts"));
		if (shipper != null) {
			map.put("shipper", shipper);
		} else if (receiver != null) {
			map.put("receiver", receiver);
		}
		ResponseModel rm = new ResponseModel();
		try {
			waybillService.updateParticipant(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 跟踪查询 超级管理员 会计
	 */
	@ResponseBody
	@RequestMapping("/logisticsQuery")
	public ResponseModel logisticsQuery(@RequestParam String runnum, HttpServletRequest request) {
		ResponseModel rm = new ResponseModel();
		try {
			rm.setT(waybillService.logisticsQuery(runnum));
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 跟踪查询 业务员
	 */
	@ResponseBody
	@RequestMapping("/logisticsQueryClient")
	public ResponseModel logisticsQueryClient(@RequestParam String runnum, HttpServletRequest request) {
		// 获取当前操作员
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		String adminId = admin.getId().toString();
		ResponseModel rm = new ResponseModel();
		try {
			rm.setT(waybillService.logisticsQueryClient(runnum, adminId));
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 核对装车 - 查询未装车托运单
	 */
	@ResponseBody
	@RequestMapping("/prepareLoading")
	public ResponseModel prepareLoading(HttpServletRequest request) {
		// 获取当前操作员
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		String adminId = admin.getId().toString();
		ResponseModel rm = new ResponseModel();
		try {
			rm.setObj(waybillService.prepareLoading(adminId));
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 核对装车 - 根据运单号查询未装车托运单
	 */
	@ResponseBody
	@RequestMapping("/prepareLoadingByRunnum")
	public ResponseModel prepareLoadingByRunnum(HttpServletRequest request) {
		// 获取当前操作员
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		String adminId = admin.getId().toString();
		String runnum = request.getParameter("runnum");
		ResponseModel rm = new ResponseModel();
		try {
			rm.setObj(waybillService.prepareLoadingByRunnum(adminId, runnum));
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 查询准备装车的托运单
	 */
	@ResponseBody
	@RequestMapping("/uploadCheck")
	public ResponseModel uploadCheck(@RequestParam Integer[] id) {
		ResponseModel rm = new ResponseModel();
		try {
			rm.setObj(waybillService.uploadCheck(id));
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 按照接收地汇总
	 */
	@ResponseBody
	@RequestMapping("/selectByDestination")
	public ResponseModel selectByDestination(HttpServletRequest request) {
		// 获取当前操作员
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		String adminId = admin.getId().toString();
		ResponseModel rm = new ResponseModel();
		try {
			rm.setObj(waybillService.selectByDestination(adminId));
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 按照接收地汇总 - 明细
	 */
	@ResponseBody
	@RequestMapping("/selectByDestinationDetail")
	public ResponseModel selectByDestinationDetail(HttpServletRequest request) {
		String destination = request.getParameter("destination");
		// 获取当前操作员
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		String adminId = admin.getId().toString();
		ResponseModel rm = new ResponseModel();
		try {
			rm.setObj(waybillService.selectByDestinationDetail(destination, adminId));
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 上传装车托运单
	 */
	@ResponseBody
	@RequestMapping("/loaded")
	public ResponseModel loaded(@RequestParam String[] id) {

		ResponseModel rm = new ResponseModel();
		try {
			waybillService.loaded(id);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 根据运单号查询 信息
	 */
	@ResponseBody
	@RequestMapping("/selectByRunnum")
	public ResponseModel selectByRunnum(@RequestParam String runnum) {

		ResponseModel rm = new ResponseModel();
		try {
			rm.setT(waybillService.selectByRunnum(runnum));
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 卸车
	 */
	@ResponseBody
	@RequestMapping("/unload")
	public ResponseModel unload(@RequestParam Integer id, @RequestParam String remarks) {
		ResponseModel rm = new ResponseModel();
		try {
			rm.setT(waybillService.unload(id, remarks));
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 取货查询
	 * 
	 * @param runnum
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("selectByRunnumStatus")
	public ResponseModel selectByRunnumStatus(@RequestParam String runnum, HttpServletRequest request) {
		// 获取当前操作员
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		String adminId = admin.getId().toString();
		ResponseModel rm = new ResponseModel();
		try {
			if (waybillService.getAdminId(runnum).equals(adminId)) {
				rm.setT(waybillService.selectByRunnumStatus(runnum));
				rm.setMsg("成功");
				rm.setSuccess(true);
			} else {
				int a = 1 / 0;
			}
		} catch (Exception e) {
			rm.init();
		}
		return rm;

	}

	/**
	 * 取货
	 */
	@ResponseBody
	@RequestMapping("/pickup")
	public ResponseModel pickup(@RequestParam String id, @RequestParam Double money, @RequestParam Double arrears) {
		ResponseModel rm = new ResponseModel();
		try {
			waybillService.pickup(id, money, arrears);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 根据id查询 客户信息
	 */
	@ResponseBody
	@RequestMapping("/selectById")
	public ResponseModel selectById(@RequestParam Integer id, @RequestParam String inf) {

		ResponseModel rm = new ResponseModel();
		try {
			rm.setT(waybillService.selectById(id, inf));
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 未取退回
	 */
	@ResponseBody
	@RequestMapping("/salesReturn")
	public ResponseModel salesReturn(@RequestParam Integer id, @RequestParam Double collectionPayment) {
		ResponseModel rm = new ResponseModel();
		try {
			waybillService.salesReturn(id, collectionPayment);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 付代收款
	 */
	@ResponseBody
	@RequestMapping("/payment")
	public ResponseModel payment(@RequestParam(required = false, value = "id[]") int[] id) {
		ResponseModel rm = new ResponseModel();
		try {
			waybillService.payment(id);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 卸车 - 取货 查询
	 */
	@ResponseBody
	@RequestMapping("selectRunnum")
	public ResponseModel selectRunnum(@RequestParam String runnum, HttpServletRequest request) {
		// 获取当前操作员
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		String adminId = admin.getId().toString();
		ResponseModel rm = new ResponseModel();
		try {
			if (waybillService.getAdminId(runnum).equals(adminId)) {
				rm.setT(waybillService.selectByRunnum(runnum));
				rm.setMsg("成功");
				rm.setSuccess(true);
			} else {
				int a = 1 / 0;
			}
		} catch (Exception e) {
			rm.init();
		}
		return rm;

	}

	/**
	 * 得到运单信息根据运单号
	 */
	@ResponseBody
	@RequestMapping("/getWayInfoByRunnum")
	public ResponseModel getWayInfoByRunnum(@RequestParam String runnum) {

		ResponseModel rm = new ResponseModel();
		try {
			rm.setT(waybillService.getWayInfoByRunnum(runnum));
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 核对装车 查询 单一运单号
	 */
	@ResponseBody
	@RequestMapping("/getWayInfoRunnum")
	public ResponseModel getWayInfoRunnum(@RequestParam String runnum) {

		ResponseModel rm = new ResponseModel();
		try {
			rm.setT(waybillService.getWayInfoRunnum(runnum));
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 取货 - 查询收件人 和 应收款
	 */
	@ResponseBody
	@RequestMapping("selectMoney")
	public ResponseModel selectMoney(@RequestParam Integer id) {

		ResponseModel rm = new ResponseModel();
		try {
			rm.setT(waybillService.selectMoney(id));
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;

	}
}
