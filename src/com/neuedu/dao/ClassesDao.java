package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Classes;

public interface ClassesDao extends BaseDao<Classes>{

	/**
	 * 查询所以数据
	 */
	
	public List<Classes> selectAll();
	
}
