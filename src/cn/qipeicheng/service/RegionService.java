package cn.qipeicheng.service;

import java.util.List;

import cn.qipeicheng.entity.Region;

public interface RegionService {
	/**
	 * 根据登录的用户查询所属目的地
	 * 
	 * @param adminId
	 * @return
	 */

	List<Region> getRegionByadminId(int adminId);

	/**
	 * 查询所有目的地
	 * 
	 * @return
	 */
	List<Region> getAllRegion();

	/**
	 * 增加一条线路
	 * 
	 * @param region
	 * @return
	 */
	boolean addRegion(Region region);

	/***
	 * 删除一条线路
	 * 
	 * @param id
	 * @return
	 */
	boolean delRegionById(int id);
	/**
	 * 根据id查询线路
	 * 
	 * @param id
	 * @return
	 */
	Region getRegionById(int id);

	/**
	 * 修改线路
	 * 
	 * @param region
	 * @return
	 */
	boolean upRegionInfo(Region region);
}
