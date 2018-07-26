package com.text.dao;

import java.util.List;

import com.text.entity.Province;

public interface ProvinceDao {

	public List<Province> selectAll(Province province);
}
