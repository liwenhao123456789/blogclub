package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.bean.Province;
import com.company.dao.IProvinceDao;
import com.company.service.IProvinceService;

/**
 * @author Johnny
 * @category 省业务逻辑实现类
 */
@Service
public class ProvinceServiceImpl implements IProvinceService {

	@Autowired
	private IProvinceDao provinceDao;
	
	public List<Province> findAll() {
		return provinceDao.findAll();
	}

	public Province findObject(String provinceId) {
		return null;
	}

}
