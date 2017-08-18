package cn.qipeicheng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qipeicheng.dao.AdminDao;
import cn.qipeicheng.entity.Admin;
import cn.qipeicheng.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin checkAdmin(String adminName, String adminPwd) {
		return adminDao.checkAdmin(adminName, adminPwd);
	}

	@Override
	public int login(String adminName, String adminPwd) {
		return adminDao.login(adminName, adminPwd);
	}

	@Override
	public boolean addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}

	@Override
	public Admin getAdminById(int id) {
		return adminDao.getAdminById(id);
	}

	@Override
	public boolean upAdminInfo(Admin admin) {
		return adminDao.upAdminInfo(admin);
	}

	@Override
	public boolean delAdminById(int id) {
		return adminDao.delAdminById(id);
	}

	@Override
	public List<Admin> getAllAdminInfo() {
		return adminDao.getAllAdminInfo();
	}
	@Override
	public Admin getPower(String adminName) {
		return adminDao.getPower(adminName);
	}

}
