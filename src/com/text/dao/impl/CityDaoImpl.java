package com.text.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.text.dao.CityDao;
import com.text.entity.City;
import com.text.util.JDBCUtil;

public class CityDaoImpl implements CityDao{

	@Override
	public City selectOne(City city) {
		String sql="select c.id,c.cityid,c.city,c.father,p.provinceid,p.id,p.province from tab_city c,tab_province p where c.father=p.provinceid";
		
		List paramsList=new ArrayList<>();
		
		if(city.getCity()!=null){
			sql+=" and c.city=?";
			paramsList.add(city.getCity());
		}
		Object[] params=paramsList.toArray();
		
		List<City> list=JDBCUtil.executeQueryCity(sql, params);
		if(list!=null && list.size()>0){
			return (City)list.get(0);
		}
		return null;
	}

	@Override
	public List<City> selectAll(City city) {
		
		String sql="select c.id,c.cityid,c.city,c.father,p.provinceid,p.id,p.province from tab_city c,tab_province p where c.father=p.provinceid";
		
		List paramsList=new ArrayList();
		
		if(city!=null){
			if(city.getProvince().getProvinceId()!=null){
				sql+=" and p.provinceid=?";
				paramsList.add(city.getProvince().getProvinceId());
			}
		}
		Object[] params=paramsList.toArray();
		return JDBCUtil.executeQueryCity(sql, params);
		
	}

}
