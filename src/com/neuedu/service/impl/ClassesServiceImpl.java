package com.neuedu.service.impl;



import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.ClassesDao;
import com.neuedu.dao.impl.ClassesDaoImpl;
import com.neuedu.entity.Classes;
import com.neuedu.entity.PageModel;
import com.neuedu.service.ClassesService;

public class ClassesServiceImpl implements ClassesService{

	ClassesDao classesDao=new ClassesDaoImpl();
	
	@Override
	public PageModel<Classes> select(PageModel<Classes> pageModel) {
		
		return classesDao.select(pageModel);
	}

	@Override
	public boolean create(Classes classes) {
		
		return classesDao.add(classes)==1?true:false;
	}

	@Override
	public Integer compare(Classes c) {
		if(classesDao.selectOne(c)!=null){
			return classesDao.selectOne(c).getId();
		}
		return null;
	}

	@Override
	public boolean update(Classes c) {
		
		return classesDao.update(c)==1?true:false;
	}

	@Override
	public Classes selectId(Integer id) {
		
		return classesDao.selectById(id);
	}

	@Override
	public boolean delete(Integer id) {
		return classesDao.deleteById(id)==1?true:false;
	}

	@Override
	public List<Classes> selectAll() {
		
		return classesDao.selectAll();
	}

	

	

	
}
