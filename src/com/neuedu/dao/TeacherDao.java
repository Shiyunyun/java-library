package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Teacher;

/**
 * Teacher数据持久层
 * @author hp
 *
 */

public interface TeacherDao  extends BaseDao<Teacher>{
	
	public List<Teacher> selectAll();
	
}
