package com.neuedu.service.impl;

import com.neuedu.dao.StudentDao;
import com.neuedu.dao.impl.StudentDaoImpl;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Student;
import com.neuedu.service.StudentService;

public class StudentServiceImpl implements StudentService{
	StudentDao studentDao=new StudentDaoImpl();
	@Override
	public PageModel<Student> select(PageModel<Student> pageModel) {
		return studentDao.select(pageModel);
	}
	
	@Override
	public boolean create(Student student) {
		int row=studentDao.add(student);
		return row==1?true:false;
	}

	@Override
	public String compare(Student s) {
		if(studentDao.selectOne(s)!=null){
			return studentDao.selectOne(s).getNo();
		}
		return null;
	}

	@Override
	public Student selectOne(String no) {
		Student student=new Student();
		student.setNo(no);
		return studentDao.selectOne(student);
	}

	@Override
	public boolean update(Student s) {
		
		return studentDao.update(s)==1?true:false;
	}

	@Override
	public boolean delete(String no) {
		Student s=new Student();
		s.setNo(no);
		return studentDao.delete(s)==1?true:false;
	}

}
