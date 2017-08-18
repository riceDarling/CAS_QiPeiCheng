package cn.qipeicheng.dao;

import java.util.Map;

import cn.qipeicheng.entity.Payment;

public interface PaymentDao {

	public void insertPayment(Payment payment);

	// 删除
	public void deletePayment(Integer id);

	// 更新代收款
	public void updateCollectionPayment(Integer id, Double collectionPayment);

	// 根据id查询信息
	public Map<String, Object> selectPaymentById(Integer id);

	// 更新退货额
	public void updateReturn(Map<String, Object> map);

	// 更新付款额
	public void updatePaid(Map<String, Object> map);

	// 更新欠款金额
	public void updateArrears(Map<String, Object> map);

}
