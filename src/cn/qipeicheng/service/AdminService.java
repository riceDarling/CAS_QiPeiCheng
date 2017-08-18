package cn.qipeicheng.service;

import java.util.List;

import cn.qipeicheng.entity.Admin;

public interface AdminService {

	/**
	 * 验证登录
	 * 
	 * @param adminName
	 * @param adminPwd
	 * @return
	 */
	Admin checkAdmin(String adminName, String adminPwd);

	/**
	 * 检查登录
	 * 
	 * @param adminName
	 * @param adminPwd
	 * @return
	 */
	int login(String adminName, String adminPwd);

	/**
	 * 通过用户名查找权限
	 * 
	 * @param adminName
	 * @return
	 */
	Admin getPower(String adminName);

	/**
	 * 添加登录用户
	 * 
	 * @param admin
	 * @return
	 */
	boolean addAdmin(Admin admin);

	/**
	 * 根据Id查询指定用户信息
	 * 
	 * @param id
	 * @return
	 */
	Admin getAdminById(int id);

	/**
	 * 修改用户信息
	 * 
	 * @param admin
	 * @return
	 */
	boolean upAdminInfo(Admin admin);

	/**
	 * 通过id删除用户
	 * 
	 * @param id
	 * @return
	 */
	boolean delAdminById(int id);

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	List<Admin> getAllAdminInfo();
}
