package cn.qipeicheng.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qipeicheng.entity.Admin;
import cn.qipeicheng.service.AdminService;
import cn.qipeicheng.util.MD5Util;
import cn.qipeicheng.util.ResponseModel;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	/**
	 * 登录校验功能模块
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public ResponseModel<Admin> login(HttpServletRequest request) {
		// 获取用户名
		String adminName = request.getParameter("adminName");
		String adminPwd = request.getParameter("adminPwd");
		// 获取密码
		if (adminPwd != null && !adminPwd.isEmpty()) {
			adminPwd = MD5Util.encode2hex(request.getParameter("adminPwd"));
		}
		ResponseModel<Admin> rm = new ResponseModel<Admin>();
		try {
			if (!adminName.isEmpty() && !adminPwd.isEmpty()) {
				if (adminService.login(adminName, adminPwd) > 0) {
					Admin admin = adminService.checkAdmin(adminName, adminPwd);
					// 销毁之前的session
					request.getSession().invalidate();
					// 管理员登陆成功后，信息保存在session中
					request.getSession().setAttribute("loginAdmin", admin);
					rm.setMsg("成功");
					rm.setSuccess(true);
					rm.setT(admin);
				} else {
					rm.setMsg("用户名或密码不匹配!");
				}
			} else {
				rm.setMsg("用户名或密码不能为空!");
			}
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 退出登录
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/exit")
	public ResponseModel exit(HttpServletRequest request) {
		ResponseModel<Admin> rm = new ResponseModel<Admin>();
		try {
			// 销毁session
			request.getSession().invalidate();
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 查询所有用户
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAllAdminInfo")
	public ResponseModel<Admin> getAllUserInfo(HttpServletRequest request) {
		ResponseModel<Admin> rm = new ResponseModel<Admin>();
		try {
			List<Admin> user = adminService.getAllAdminInfo();
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setObj(user);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 根据ID查询一条用户信息
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAdminById")
	public ResponseModel<Admin> getAdminById(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		ResponseModel<Admin> rm = new ResponseModel<Admin>();
		try {
			Admin user = adminService.getAdminById(id);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setT(user);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 通过用户名查找权限
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getPower")
	public ResponseModel<Admin> getPower(HttpServletRequest request) {
		String adminName = request.getParameter("adminName");
		ResponseModel<Admin> rm = new ResponseModel<Admin>();
		try {
			Admin user = adminService.getPower(adminName);
			rm.setMsg("成功");
			rm.setSuccess(true);
			rm.setT(user);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 增加一条用户信息
	 * 
	 * @param user
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addAdmin")
	public ResponseModel addAdmin(HttpServletRequest request) {
		ResponseModel rm = new ResponseModel();
		Admin admin = new Admin();
		try {
			// 设置账户名
			admin.setAdminName(request.getParameter("adminName"));
			// 设置密码 md5加密
			admin.setAdminPwd(MD5Util.encode2hex(request.getParameter("adminPwd")));
			// 设置（权限：超级管理员，普通用户）
			admin.setPower(request.getParameter("power"));
			adminService.addAdmin(admin);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 修改一条用户信息
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/upAdminInfo")
	public ResponseModel upAdminInfo(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		ResponseModel rm = new ResponseModel();
		try {
			Admin admin = adminService.getAdminById(id);
			// 设置账户名
			admin.setAdminName(request.getParameter("adminName"));
			// 设置密码 md5加密
			admin.setAdminPwd(MD5Util.encode2hex(request.getParameter("adminPwd")));
			// 设置（权限：超级管理员，普通用户）
			admin.setPower(request.getParameter("power"));
			adminService.upAdminInfo(admin);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}

	/**
	 * 删除一条用户信息
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delAdminById")
	public ResponseModel delAdminById(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		ResponseModel rm = new ResponseModel();
		try {
			adminService.delAdminById(id);
			rm.setMsg("成功");
			rm.setSuccess(true);
		} catch (Exception e) {
			rm.init();
		}
		return rm;
	}
}
