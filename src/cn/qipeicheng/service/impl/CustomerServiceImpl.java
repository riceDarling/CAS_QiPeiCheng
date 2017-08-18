package cn.qipeicheng.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qipeicheng.dao.CustomerDao;
import cn.qipeicheng.entity.Customer;
import cn.qipeicheng.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> getCustomerInfos() {
		return customerDao.getCustomerInfos();
	}

	@Override
	public List<Customer> getCustomerByCommon(int adminId) {
		return customerDao.getCustomerByCommon(adminId);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	public List<Map<String, Object>> getCustomerByNamePhone(Map<String, Object> map) {
		return customerDao.getCustomerByNamePhone(map);
	}

	@Override
	public List<Map<String, Object>> getCustomerByNameRegion(Map<String, Object> map) {
		return customerDao.getCustomerByNameRegion(map);
	}

	@Override
	public boolean upCustomerInfo(Customer customer) {
		return customerDao.upCustomerInfo(customer);
	}

	@Override
	public boolean delCustomerById(int id) {
		return customerDao.delCustomerById(id);
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}

	// 通过拼音检索客户信息
	@Override
	public List<Map<String, Object>> getCustomerInfoByPY(Map<String, Object> map) {
		return customerDao.getCustomerInfoByPY(map);
	}

	// 通过拼音检索客户信息加地区
	@Override
	public List<Map<String, Object>> getCustomerInfoByPyRegion(Map<String, Object> map) {
		return customerDao.getCustomerInfoByPyRegion(map);
	}

	@Override
	public List<Map<String, Object>> getCustomerByPY(Map<String, String> map) {
		return customerDao.getCustomerByPY(map);
	}

	@Override
	public List<Map<String, Object>> getCustomerByName(Map<String, Object> map) {
		return customerDao.getCustomerByName(map);
	}

	@Override
	public List<Map<String, Object>> getCustomerByNameClient(Map<String, Object> map) {
		return customerDao.getCustomerByNameClient(map);
	}
}
