package cn.qipeicheng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qipeicheng.dao.RegionDao;
import cn.qipeicheng.entity.Region;
import cn.qipeicheng.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService {
	@Autowired
	private RegionDao regionDao;

	@Override
	public List<Region> getRegionByadminId(int adminId) {
		return regionDao.getRegionByadminId(adminId);
	}

	@Override
	public List<Region> getAllRegion() {
		return regionDao.getAllRegion();
	}

	@Override
	public boolean addRegion(Region region) {
		return regionDao.addRegion(region);
	}

	@Override
	public boolean delRegionById(int id) {
		return regionDao.delRegionById(id);
	}
	@Override
	public Region getRegionById(int id) {
		return regionDao.getRegionById(id);
	}

	@Override
	public boolean upRegionInfo(Region region) {
		return regionDao.upRegionInfo(region);
	}

}
