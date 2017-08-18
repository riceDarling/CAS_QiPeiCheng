package cn.qipeicheng.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qipeicheng.entity.Admin;
import cn.qipeicheng.entity.Customer;
import cn.qipeicheng.service.CustomerService;
import cn.qipeicheng.util.CheckStr;
import cn.qipeicheng.util.ResponseModel;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	/**
	 * 查询显示客户信息 超级管理员
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCustomerInfos")
	public ResponseModel<Customer> getCustomerInfos(HttpServletRequest request) {
		ResponseModel<Customer> rm = new ResponseModel<Customer>();
		try {
			List<Customer> customers = customerService.getCustomerInfos();
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(customers);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 查询显示客户信息 业务员
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCustomerByCommon")
	public ResponseModel<Customer> getCustomerByCommon(HttpServletRequest request) {
		// 获取管理员id
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		ResponseModel<Customer> rm = new ResponseModel<Customer>();
		try {
			List<Customer> customers = customerService.getCustomerByCommon(admin.getId());
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(customers);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 增加一条客戶信息
	 * 
	 * @param customerProfile
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addCustomer")
	public ResponseModel addCustomer(Customer customer, HttpServletRequest request) {
		ResponseModel rm = new ResponseModel();
		try {
			customerService.addCustomer(customer);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 根据客户名称和电话号模糊查询指定客户信息 超级管理员 客户档案模块查询
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCustomerByName")
	public ResponseModel<Map<String, Object>> getCustomerByName(HttpServletRequest request) {
		String customerName = request.getParameter("customerName");
		ResponseModel rm = new ResponseModel();
		try {
			// isChinese方法，如果返回true，表示 string为中文，否则相反
			if (CheckStr.isChineses(customerName)) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("customerName", customerName);
				List<Map<String, Object>> list = customerService.getCustomerByName(map);
				rm.setObj(list);
			} else if (CheckStr.isNumber(customerName)) {// isNumber方法返回true的时候表示 str为数字
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("customerPhone", customerName);
				List<Map<String, Object>> list = customerService.getCustomerByName(map);
				rm.setObj(list);
			} else {
				Map<String, String> para = new HashMap<String, String>();
				para.put("py", customerName);
				List<Map<String, Object>> customerProfile = customerService.getCustomerByPY(para);
				rm.setObj(customerProfile);
			}
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 根据客户名称和电话号模糊查询指定客户信息 业务员 客户档案模块查询
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCustomerByNameClient")
	public ResponseModel<Map<String, Object>> getCustomerByNameClient(HttpServletRequest request) {
		// 获取管理员id
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		String customerName = request.getParameter("customerName");
		ResponseModel rm = new ResponseModel();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("adminId", admin.getId().toString());
			// isChinese方法，如果返回true，表示 string为中文，否则相反
			if (CheckStr.isChineses(customerName)) {
				map.put("customerName", customerName);
				List<Map<String, Object>> list = customerService.getCustomerByNameClient(map);
				rm.setObj(list);
			} else if (CheckStr.isNumber(customerName)) {// isNumber方法返回true的时候表示 str为数字
				map.put("customerPhone", customerName);
				List<Map<String, Object>> list = customerService.getCustomerByNameClient(map);
				rm.setObj(list);
			} else {
				map.put("py", customerName);
				List<Map<String, Object>> customerProfile = customerService.getCustomerInfoByPY(map);
				rm.setObj(customerProfile);
			}
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 根据目的地,客户名称,电话号  查询客户信息 超管 登记接件模块查询
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCustomerByNameRegion")
	public ResponseModel<Map<String, Object>> getCustomerByNameRegion(HttpServletRequest request) {
		// 目的地
		String regionName = request.getParameter("regionName");
		// 客户名称
		String customerName = request.getParameter("customerName");
		ResponseModel rm = new ResponseModel();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("regionName", regionName);
			// isChinese方法，如果返回true，表示 string为中文，否则相反
			if (CheckStr.isChineses(customerName)) {
				map.put("customerName", customerName);
				List<Map<String, Object>> list = customerService.getCustomerByNameRegion(map);
				rm.setObj(list);
			}else if (CheckStr.isNumber(customerName)) {// isNumber方法返回true的时候表示 str为数字
					map.put("customerPhone", customerName);
					List<Map<String, Object>> list = customerService.getCustomerByNameRegion(map);
					rm.setObj(list);
				} else {
				map.put("py", customerName);
				List<Map<String, Object>> list = customerService.getCustomerInfoByPyRegion(map);
				rm.setObj(list);
			}
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 根据目的地，客户名称,,电话号,登录用户 查询客户信息 普通客户 登记接件查询
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCustomerByNamePhone")
	public ResponseModel<Customer> getCustomerByNamePhone(HttpServletRequest request) {
		// 获取管理员id
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		// 目的地
		String regionName = request.getParameter("regionName");
		// 客户名称
		String customerName = request.getParameter("customerName");
		ResponseModel rm = new ResponseModel();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("regionName", regionName);
			map.put("adminId", admin.getId().toString());
			// isChinese方法，如果返回true，表示 string为中文，否则相反
			if (CheckStr.isChineses(customerName)) {
				map.put("customerName", customerName);
				List<Map<String, Object>> list = customerService.getCustomerByNamePhone(map);
				rm.setObj(list);
			}else if (CheckStr.isNumber(customerName)) {// isNumber方法返回true的时候表示 str为数字
				map.put("customerPhone", customerName);
				List<Map<String, Object>> list = customerService.getCustomerByNamePhone(map);
				rm.setObj(list);
			} else {
				map.put("py", customerName);
				List<Map<String, Object>> customerProfile = customerService.getCustomerInfoByPY(map);
				rm.setObj(customerProfile);
			}
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 修改一条客户信息
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/upCustomer")
	public ResponseModel uCustomerInfo(HttpServletRequest request) {
		// Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		// int adminId = admin.getId();
		int id = Integer.parseInt(request.getParameter("id"));
		ResponseModel rm = new ResponseModel();
		try {
			Customer customer = customerService.getCustomerById(id);
			customer.setCustomerName(request.getParameter("customerName"));
			customer.setCustomerAddress(request.getParameter("customerAddress"));
			customer.setCustomerPhone(request.getParameter("customerPhone"));
			customer.setCustomerContacts(request.getParameter("customerContacts"));
			customer.setCode(request.getParameter("code"));
			customer.setBankCard(request.getParameter("bankCard"));
			customer.setRegionId(request.getParameter("regionId"));
			// customer.setAdminId(adminId);
			customerService.upCustomerInfo(customer);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 根据id查询客户信息
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCustomerById")
	public ResponseModel getCustomerById(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		ResponseModel rm = new ResponseModel();
		try {
			Customer customer = customerService.getCustomerById(id);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setT(customer);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 删除一条客户信息
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delCustomer")
	public ResponseModel dCustomerInfo(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		ResponseModel rm = new ResponseModel();
		try {
			customerService.delCustomerById(id);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

}
