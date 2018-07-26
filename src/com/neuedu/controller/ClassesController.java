package com.neuedu.controller;

import java.util.List;

import com.neuedu.entity.Classes;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Student;
import com.neuedu.service.ClassesService;
import com.neuedu.service.impl.ClassesServiceImpl;

public class ClassesController {
	
	ClassesService classesService=new ClassesServiceImpl();
	public PageModel<Classes> select(PageModel<Classes> pageModel){
		
		return classesService.select(pageModel);
		
	}
	public Integer compare(Classes c) {
		
		return classesService.compare(c);
	}
	public boolean create(Classes c) {
		
		return classesService.create(c);
	}
	public boolean update(Classes t) {
		
		return classesService.update(t);
	}
	public Classes selectId(Integer id) {
		
		return classesService.selectId(id);
	}
	public boolean delete(Integer id) {
		
		return classesService.delete(id);
	}
	
	public List<Classes> selectAll(){
		
		return classesService.selectAll();
	}
}

