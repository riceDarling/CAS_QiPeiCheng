package cn.qipeicheng.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qipeicheng.entity.Admin;
import cn.qipeicheng.entity.Region;
import cn.qipeicheng.service.RegionService;
import cn.qipeicheng.util.ResponseModel;

@Controller
@RequestMapping("/region")
public class RegionController {
	@Autowired
	private RegionService regionService;

	/**
	 * 查询所有目的地
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAllRegion")
	public ResponseModel<Region> getAdminById(HttpServletRequest request) {
		ResponseModel<Region> rm = new ResponseModel<Region>();
		try {
			List<Region> list = regionService.getAllRegion();
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 根据登录的用户查询所属目的地
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getRegionByadminId")
	public ResponseModel<Region> getRegionByadminId(HttpServletRequest request) {
		 Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		 int adminId=admin.getId();
		ResponseModel<Region> rm = new ResponseModel<Region>();
		try {
			List<Region> list = regionService.getRegionByadminId(adminId);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(list);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 增加一条线路
	 * 
	 * @param region
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addRegion")
	public ResponseModel addRegion(Region region, HttpServletRequest request) {
		ResponseModel rm = new ResponseModel();
		try {
			regionService.addRegion(region);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 根据id查询线路
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getRegionById")
	public ResponseModel getRegionById(HttpServletRequest request) {
		ResponseModel rm = new ResponseModel();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Region region = regionService.getRegionById(id);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setT(region);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 修改线路
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/upRegionInfo")
	public ResponseModel upRegionInfo(HttpServletRequest request) {
		ResponseModel rm = new ResponseModel();
		int id = Integer.parseInt(request.getParameter("id"));
		String regionName = request.getParameter("regionName");
		int adminId=Integer.parseInt(request.getParameter("adminId"));
		Region region = regionService.getRegionById(id);
		try {
			region.setAdminId(adminId);
			region.setRegionName(regionName);
			regionService.upRegionInfo(region);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 删除一条线路
	 * 
	 * @param region
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delRegionById")
	public ResponseModel delRegionById(Region region, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		ResponseModel rm = new ResponseModel();
		try {
			regionService.delRegionById(id);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}
}
