package com.neuedu.service;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Student;

public interface StudentService {

	public PageModel<Student> select(PageModel<Student> pageModel);
	
	public boolean create(Student student);
	
	public String compare(Student s);
	
	public Student selectOne(String no);
	
	public boolean update(Student s);
	
	public boolean delete(String no);
}
