package com.text.service;

import java.util.List;

import com.text.dao.CityDao;
import com.text.dao.impl.CityDaoImpl;
import com.text.entity.City;

public class CityService {
	
	CityDao cityDao=new CityDaoImpl();
	
	public City selectOne(City city){
		
		
		return cityDao.selectOne(city);
		
	}
	
	public List<City> selectAll(City city){
		
		return cityDao.selectAll(city);
	}
}
