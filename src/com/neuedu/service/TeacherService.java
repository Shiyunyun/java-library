package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Teacher;

public interface TeacherService {
	
	public Teacher login(Teacher t);
	
	public PageModel<Teacher> select(PageModel<Teacher> pageModel);
	
	public boolean create(Teacher t);
	
	public boolean update(Teacher t);
	
	public String compare(Teacher t);
	
	public Teacher selectOne(String no);
	
	public boolean delete(String no);
	
	public List<Teacher> selectAll();
}
