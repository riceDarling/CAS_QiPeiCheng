package cn.qipeicheng.dao;

import java.util.Map;

import cn.qipeicheng.entity.Participant;

public interface ParticipantDao {

	//添加双方信息
	public void insertParticipant(Participant participant);
	//删除
	public void deleteParticipant(Integer id);
	//修改托运方信息
	public void updateShipper(Map<String,Object> map);
	//修改收件方信息
	public void updateReceiver(Map<String,Object> map);
}
