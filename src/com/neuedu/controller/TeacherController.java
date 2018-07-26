package com.neuedu.controller;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Teacher;
import com.neuedu.service.TeacherService;
import com.neuedu.service.impl.TeacherServiceImpl;

/**
 * Teacher控制层
 * @author hp
 *
 */
public class TeacherController {
	TeacherService teacherService=new TeacherServiceImpl();
	
	public Teacher login(Teacher t){
		
		return teacherService.login(t);
		
	}
	
	public PageModel<Teacher> select(PageModel<Teacher> pageModel){
		
		return teacherService.select(pageModel);
	}
	
	public boolean create(Teacher t){
		
		return teacherService.create(t);
	}
	
	public String compare(Teacher t){
		
		return teacherService.compare(t);
	}
	
	public Teacher selectOne(String no){
		return teacherService.selectOne(no);
	}
	
	public boolean update(Teacher t){
		
		return teacherService.update(t);
	}
	
	public boolean delete(String no){
		
		return teacherService.delete(no);
	}
	
	public List<Teacher> selectAll(){
		
		return teacherService.selectAll();
	}
}
