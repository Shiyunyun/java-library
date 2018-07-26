package com.neuedu.controller;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Student;
import com.neuedu.entity.Teacher;
import com.neuedu.service.StudentService;
import com.neuedu.service.impl.StudentServiceImpl;

public class StudentController {
	StudentService studentService=new StudentServiceImpl();
	public PageModel<Student> select(PageModel<Student> pageModel){
		return studentService.select(pageModel);
		
	}
	public boolean create(Student s) {
		
		return studentService.create(s);
	}
	public  String compare(Student s) {
		
		return studentService.compare(s);
	}
	public Student selectOne(String no) {
		
		return studentService.selectOne(no);
	}
	public boolean update(Student t) {
		
		return studentService.update(t);
	}
	public boolean delete(String no) {
		
		return studentService.delete(no);
	}
	
}
