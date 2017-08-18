package cn.qipeicheng.dao;

import java.util.List;
import java.util.Map;

import cn.qipeicheng.entity.Customer;

public interface CustomerDao {
	/**
	 * 查询显示客户信息 超级管理员
	 */
	List<Customer> getCustomerInfos();

	/**
	 * 查询显示客户信息 业务员
	 */
	List<Customer> getCustomerByCommon(int adminId);

	/**
	 * 根据id查询客户信息
	 * 
	 * @param id
	 * @return
	 */
	Customer getCustomerById(int id);

	/**
	 * 根据客户名称和电话号,登录用户模糊查询指定客户信息
	 * 
	 * @param customerName
	 * @param customerPhone
	 * @return
	 */
	List<Map<String, Object>> getCustomerByNamePhone(Map<String, Object> map);

	/**
	 * 根据客户名称和电话号模糊查询指定客户信息 超级管理员
	 * 
	 * @param customerName
	 * @param regionName
	 * @return
	 */
	List<Map<String, Object>> getCustomerByName(Map<String, Object> map);
	/**
	 * 根据客户名称和电话号模糊查询指定客户信息 业务员
	 * 
	 * @param customerName
	 * @param regionName
	 * @return
	 */
	List<Map<String, Object>> getCustomerByNameClient(Map<String, Object> map);

	/**
	 * 根据目的地和客户名称查询客户信息
	 * 
	 * @param customerName
	 * @param regionName
	 * @return
	 */
	List<Map<String, Object>> getCustomerByNameRegion(Map<String, Object> map);

	/**
	 * 添加客户
	 */
	boolean addCustomer(Customer customer);

	/**
	 * 修改客户
	 * 
	 * @param customer
	 * @return
	 */
	boolean upCustomerInfo(Customer customer);

	/**
	 * 通过id删除客户
	 * 
	 * @param id
	 * @return
	 */
	boolean delCustomerById(int id);

	/**
	 * 通过登录用户，目的地，拼音模糊检索客户信息
	 * 
	 * @author Sseakom
	 * @param py
	 */
	List<Map<String, Object>> getCustomerInfoByPY(Map<String, Object> map);

	/**
	 * 通过拼音模糊检索客户信息  超级管理员
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getCustomerByPY(Map<String, String> map);

	/**
	 * 通过拼音模糊检索客户信息 加地区
	 */
	List<Map<String, Object>> getCustomerInfoByPyRegion(Map<String, Object> map);
}