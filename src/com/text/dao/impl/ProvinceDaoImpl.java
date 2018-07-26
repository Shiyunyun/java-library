package com.text.dao.impl;

import java.util.List;

import com.text.dao.ProvinceDao;
import com.text.entity.Province;
import com.text.util.JDBCUtil;

public class ProvinceDaoImpl implements ProvinceDao{

	@Override
	public List<Province> selectAll(Province province) {
		
		String sql="select p.id,p.provinceid,p.province from tab_province p where 1=1";
		
		return JDBCUtil.executeQueryProvince(sql, null);
	}

}
