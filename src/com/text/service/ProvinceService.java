package com.text.service;

import java.util.List;

import com.text.dao.ProvinceDao;
import com.text.dao.impl.ProvinceDaoImpl;
import com.text.entity.Province;

public class ProvinceService {

	ProvinceDao provinceDao=new ProvinceDaoImpl();
	
	public List<Province> selectAll(Province province){
		
		return provinceDao.selectAll(province);
		
	}
}
