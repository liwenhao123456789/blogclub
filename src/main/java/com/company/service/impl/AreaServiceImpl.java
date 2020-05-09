package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.bean.Area;
import com.company.dao.IAreaDao;
import com.company.service.IAreaService;

/**
 * @author Johnny
 * @category 区业务逻辑实现类
 */
@Service
public class AreaServiceImpl implements IAreaService {
	
	@Autowired
	private IAreaDao areaDao;

	public List<Area> findAreasByCid(String cityId) {
		List<Area> list = null;
		if(cityId!=null){
			list = areaDao.findAreasByCid(cityId);
		}
		return list;
	}

	public Area findObject(String areaId) {
		return null;
	}

}
