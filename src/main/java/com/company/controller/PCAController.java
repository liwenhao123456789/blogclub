package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.bean.Area;
import com.company.bean.City;
import com.company.bean.Province;
import com.company.service.IAreaService;
import com.company.service.ICityService;
import com.company.service.IProvinceService;

/**
 * @author Johnny
 * @category 
 */
@RestController
public class PCAController {

	@Autowired
	IProvinceService provinceService;
	
	@Autowired
	ICityService cityService;
	
	@Autowired
	IAreaService areaService;
	
	@RequestMapping("/getprovince")
	public List<Province> getProvice() {
		List<Province> list = provinceService.findAll();
		return list;
	}
	
	@RequestMapping("/getcity")
	public List<City> getCity(String provinceId) {
		List<City> list = cityService.findCitiesByPid(provinceId);
		return list;
	}
	
	@RequestMapping("/getarea")
	public List<Area> getArea(String cityId) {
		List<Area> list = areaService.findAreasByCid(cityId);
		return list;
	}
}



























