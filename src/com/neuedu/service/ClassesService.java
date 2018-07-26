package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Classes;
import com.neuedu.entity.PageModel;

public interface ClassesService {

	public PageModel<Classes> select(PageModel<Classes> pageModel);
	
	public boolean create(Classes classes);
	
	public Integer compare(Classes c);
	
	public boolean update(Classes c);
	
	public Classes selectId(Integer id);
	
	public boolean delete(Integer id);
	
	public List<Classes> selectAll();
}
