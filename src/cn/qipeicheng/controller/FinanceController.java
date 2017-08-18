package cn.qipeicheng.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qipeicheng.service.FinanceService;
import cn.qipeicheng.util.ResponseModel;

/**
 * 财务
 */
@Controller
@RequestMapping("/finance")
public class FinanceController {
	@Autowired
	private FinanceService financeService;

	/**
	 * 装车报表-未装车单
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/loadingReportUnbound")
	public ResponseModel<Map<String, Object>> loadingReportUnbound(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.loadingReportUnbound(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 装车报表-托运方付运费列表
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/loadingReportShipper")
	public ResponseModel<Map<String, Object>> loadingReportShipper(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.loadingReportShipper(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 装车报表-接收方付运费列表
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/loadingReportReceiver")
	public ResponseModel<Map<String, Object>> loadingReportReceiver(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.loadingReportReceiver(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 综合报表-收件汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/synthesizeReportPickup")
	public ResponseModel<Map<String, Object>> synthesizeReportPickup(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.synthesizeReportPickup(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 综合报表-收件汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/synthesizeReportPickupInfos")
	public ResponseModel<Map<String, Object>> synthesizeReportPickupInfos(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.synthesizeReportPickupInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 综合报表-装车汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/synReportLoading")
	public ResponseModel<Map<String, Object>> synReportLoading(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.synReportLoading(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 综合报表-装车汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/synReportLoadingInfos")
	public ResponseModel<Map<String, Object>> synReportLoadingInfos(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.synReportLoadingInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 综合报表-卸车汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/synReportUpload")
	public ResponseModel<Map<String, Object>> synReportUpload(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.synReportUpload(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 综合报表-卸车汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/synReportUploadInfos")
	public ResponseModel<Map<String, Object>> synReportUploadInfos(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.synReportUploadInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 综合报表-取件汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/synReportTake")
	public ResponseModel<Map<String, Object>> synReportTake(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.synReportTake(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 综合报表-取件汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/synReportTakeInfos")
	public ResponseModel<Map<String, Object>> synReportTakeInfos(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.synReportTakeInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 综合报表-付代收款汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/synReportPayforCol")
	public ResponseModel<Map<String, Object>> synReportPayforCol(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.synReportPayforCol(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 综合报表-付代收款汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/synReportPayforColInfos")
	public ResponseModel<Map<String, Object>> synReportPayforColInfos(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.synReportPayforColInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 代收款汇总-按托运地汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/forCollectionSumByConsignment")
	public ResponseModel<Map<String, Object>> forCollectionSumByConsignment(HttpServletRequest request) {
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			List<Map<String, Object>> list = financeService.forCollectionSumByConsignment(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 代收款汇总-按托运地汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/forCollectionSumByConsignmentInfos")
	public ResponseModel<Map<String, Object>> forCollectionSumByConsignmentInfos(HttpServletRequest request) {
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			List<Map<String, Object>> list = financeService.forCollectionSumByConsignmentInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 代收款汇总-按接收地汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/forCollectionSumByDestination")
	public ResponseModel<Map<String, Object>> forCollectionSumByDestination(HttpServletRequest request) {
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			List<Map<String, Object>> list = financeService.forCollectionSumByDestination(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 代收款汇总-按接收地汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/forCollectionSumByDestinationInfos")
	public ResponseModel<Map<String, Object>> forCollectionSumByDestinationInfos(HttpServletRequest request) {
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			List<Map<String, Object>> list = financeService.forCollectionSumByDestinationInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 代收款汇总-按托运方汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/forCollectionSumByShipper")
	public ResponseModel<Map<String, Object>> forCollectionSumByShipper(HttpServletRequest request) {
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			List<Map<String, Object>> list = financeService.forCollectionSumByShipper(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 代收款汇总-按托运方汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/forCollectionSumByShipperInfos")
	public ResponseModel<Map<String, Object>> forCollectionSumByShipperInfos(HttpServletRequest request) {
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			List<Map<String, Object>> list = financeService.forCollectionSumByShipperInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 收款报表-按托运方汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/receivingReportSumByShipper")
	public ResponseModel<Map<String, Object>> receivingReportSumByShipper(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		// 托运方
		String shipper = request.getParameter("shipper");
		// 件数
		String total = request.getParameter("total");
		// 运费
		String freight = request.getParameter("freight");
		// 代收款
		String modernCollection = request.getParameter("modernCollection");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			map.put("shipper", shipper);
			map.put("total", total);
			map.put("freight", freight);
			map.put("modernCollection", modernCollection);
			List<Map<String, Object>> list = financeService.receivingReportSumByShipper(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 收款报表-按托运方汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/receivingReportSumByShipperInfos")
	public ResponseModel<Map<String, Object>> receivingReportSumByShipperInfos(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.receivingReportSumByShipperInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 收款报表-按日期汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/receivingReportSumByDate")
	public ResponseModel<Map<String, Object>> receivingReportSumByDate(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.receivingReportSumByDate(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 收款报表-按日期汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/receivingReportSumByDateInfos")
	public ResponseModel<Map<String, Object>> receivingReportSumByDateInfos(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.receivingReportSumByDateInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 收款报表-全部运单列表
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAllWaybillList")
	public ResponseModel<Map<String, Object>> getAllWaybillList(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.getAllWaybillList(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 收款报表-托运方付运费列表
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAllShipperPayList")
	public ResponseModel<Map<String, Object>> getAllShipperPayList(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.getAllShipperPayList(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 收款报表-按接收方汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/receivingReportSumByReceiver")
	public ResponseModel<Map<String, Object>> receivingReportSumByReceiver(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		// 托运方
		String shipper = request.getParameter("shipper");
		// 件数
		String total = request.getParameter("total");
		// 运费
		String freight = request.getParameter("freight");
		// 代收款
		String modernCollection = request.getParameter("modernCollection");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			map.put("shipper", shipper);
			map.put("total", total);
			map.put("freight", freight);
			map.put("modernCollection", modernCollection);
			List<Map<String, Object>> list = financeService.receivingReportSumByReceiver(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 收款报表-按接收方汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/receivingReportSumByReceiverInfos")
	public ResponseModel<Map<String, Object>> receivingReportSumByReceiverInfos(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.receivingReportSumByReceiverInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 收款报表-按日期-方向汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/receivingReportSumByDateDirection")
	public ResponseModel<Map<String, Object>> receivingReportSumByDateDirection(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.receivingReportSumByDateDirection(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 收款报表-按日期-方向汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/receivingReportSumByDateDirectionInfos")
	public ResponseModel<Map<String, Object>> receivingReportSumByDateDirectionInfos(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.receivingReportSumByDateDirectionInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 收款报表-退货列表
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAllReturnList")
	public ResponseModel<Map<String, Object>> getAllReturnList(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.getAllReturnList(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 收款报表-接收方付运费列表
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAllReceiverPayList")
	public ResponseModel<Map<String, Object>> getAllReceiverPayList(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.getAllReceiverPayList(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 欠代收款报表--按取货时间汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/oweForColByDate")
	public ResponseModel<Map<String, Object>> oweForColByDate(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.oweForColByDate(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 欠代收款报表--按取货时间汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/oweForColByDateInfos")
	public ResponseModel<Map<String, Object>> oweForColByDateInfos(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.oweForColByDateInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 欠代收款报表--按托运方汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/oweForColByShipper")
	public ResponseModel<Map<String, Object>> oweForColByShipper(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.oweForColByShipper(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 欠代收款报表--按托运方汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/oweForColByShipperInfos")
	public ResponseModel<Map<String, Object>> oweForColByShipperInfos(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.oweForColByShipperInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 欠代收款报表--明细表
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/oweForColSchedule")
	public ResponseModel<Map<String, Object>> oweForColSchedule(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.oweForColSchedule(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 欠代收款报表--明细表 --根据运单号查询
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/oweForColScheduleByRunnum")
	public ResponseModel<Map<String, Object>> oweForColScheduleByRunnum(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 运单号
		String runnum = request.getParameter("runnum");
		try {
			List<Map<String, Object>> list = financeService.oweForColScheduleByRunnum(runnum);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 付代收款报表--按日期汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/payforColByDate")
	public ResponseModel<Map<String, Object>> payforColByDate(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.payforColByDate(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 付代收款报表--按日期汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/payforColByDateInfos")
	public ResponseModel<Map<String, Object>> payforColByDateInfos(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.payforColByDateInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 付代收款报表--按日期发送方向汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/payforColByDateDirection")
	public ResponseModel<Map<String, Object>> payforColByDateDirection(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.payforColByDateDirection(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 付代收款报表--按日期发送方向汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/payforColByDateDirectionInfos")
	public ResponseModel<Map<String, Object>> payforColByDateDirectionInfos(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.payforColByDateDirectionInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 付代收款报表--按托运方汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/payforColByShipper")
	public ResponseModel<Map<String, Object>> payforColByShipper(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.payforColByShipper(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 付代收款报表--按托运方汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/payforColByShipperInfos")
	public ResponseModel<Map<String, Object>> payforColByShipperInfos(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.payforColByShipperInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 付代收款报表--按托运方发送方向汇总
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/payforColByShipperDirection")
	public ResponseModel<Map<String, Object>> payforColByShipperDirection(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.payforColByShipperDirection(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 付代收款报表--按托运方发送方向汇总明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/payforColByShipperDirectionInfos")
	public ResponseModel<Map<String, Object>> payforColByShipperDirectionInfos(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.payforColByShipperDirectionInfos(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 付代收款报表-- 付款明细
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/payforColPaymentDetail")
	public ResponseModel<Map<String, Object>> payforColPaymentDetail(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 开始时间
		String startDate = request.getParameter("startDate");
		// 截止时间
		String endDate = request.getParameter("endDate");
		// 托运地
		String consignment = request.getParameter("consignment");
		// 目的地
		String destination = request.getParameter("destination");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("consignment", consignment);
			map.put("destination", destination);
			List<Map<String, Object>> list = financeService.payforColPaymentDetail(map);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 付代收款报表-付款明细 -根据运单号查询
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/payforColPaymentDetailByRunnum")
	public ResponseModel<Map<String, Object>> payforColPaymentDetailByRunnum(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 运单号
		String runnum = request.getParameter("runnum");
		try {
			List<Map<String, Object>> list = financeService.payforColPaymentDetailByRunnum(runnum);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 代收款管理-根据运单号得到托运代收款信息
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getForColInfosByRunnum")
	public ResponseModel<Map<String, Object>> getForColInfosByRunnum(HttpServletRequest request) {
		ResponseModel<Map<String, Object>> rm = new ResponseModel<Map<String, Object>>();
		// 运单号
		String runnum = request.getParameter("runnum");
		try {
			List<Map<String, Object>> list = financeService.getForColInfosByRunnum(runnum);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}
}
