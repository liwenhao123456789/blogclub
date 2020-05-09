package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.bean.City;
import com.company.dao.ICityDao;
import com.company.service.ICityService;

/**
 * @author Johnny
 * @category 市业务逻辑实现类
 */
@Service
public class CityServiceImpl implements ICityService {
	
	@Autowired
	private ICityDao cityDao;

	public List<City> findCitiesByPid(String provinceId) {
		List<City> list = null;
		if(provinceId!=null){
			list = cityDao.findCitiesByPid(provinceId);
		}
		return list;
	}

	public City findObject(String cityId) {
		return null;
	}

}
