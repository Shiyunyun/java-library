package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.TeacherDao;
import com.neuedu.dao.impl.TeacherDaoImpl;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Teacher;
import com.neuedu.service.TeacherService;
import com.neuedu.utils.MD5Utils;
import com.neuedu.utils.StringUtils;

public class TeacherServiceImpl implements TeacherService{

	TeacherDao td=new TeacherDaoImpl();
	@Override
	public Teacher login(Teacher t) {
		t.setPassword(MD5Utils.getMD5(t.getPassword()));
		Teacher teacher=td.selectOne(t);
		return teacher;
		 
	}

	@Override
	public boolean create(Teacher t) {
		t.setPassword(MD5Utils.getMD5(t.getPassword()));
		int row=td.add(t);
		if(row==1){
			return true;
		}
		return false;
	}

	@Override
	public String compare(Teacher t) {
		if(td.selectOne(t)!=null){
			return td.selectOne(t).getNo();
		}
		return null;
	}

	@Override
	public Teacher selectOne(String no) {
		Teacher t=new Teacher();
		t.setNo(no);
		return td.selectOne(t);
	}

	@Override
	public boolean update(Teacher t) {
		if(StringUtils.mathStr(t.getPassword())){
			
			t.setPassword(MD5Utils.getMD5(t.getPassword()));
		}
		int row=td.update(t);
		return row==1?true:false;
	}

	@Override
	public boolean delete(String no) {
		Teacher t=new Teacher();
		t.setNo(no);
		int row=td.delete(t);
		return row==1?true:false;
	}



	@Override
	public PageModel<Teacher> select(PageModel<Teacher> pageModel) {
			
		return td.select(pageModel);
	}

	@Override
	public List<Teacher> selectAll() {
		
		return td.selectAll();
	}

	

}
