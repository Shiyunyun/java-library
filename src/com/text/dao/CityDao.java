package com.text.dao;

import java.util.List;

import com.text.entity.City;

public interface CityDao {

	public City selectOne(City city);
	
	public List<City> selectAll(City city);
}
