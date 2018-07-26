package com.neuedu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.StudentDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Student;
import com.neuedu.entity.rowmapper.StudentRowMapper;
import com.neuedu.utils.DateUtils;
import com.neuedu.utils.JDBCUtils;
import com.neuedu.utils.StringUtils;



public class StudentDaoImpl implements StudentDao{

	@Override
	public int count(Student t) {
		String sql="select count(*) from t_student s where 1=1";
		List parmasList=new ArrayList<>();
		if(t!=null){
			
			if(StringUtils.mathStr(t.getNo())){
				sql+=" and s.no like ?";
				parmasList.add('%'+t.getNo()+'%');
			}
			if(StringUtils.mathStr(t.getName())){
				sql+=" and s.name like ?";
				parmasList.add('%'+t.getName()+'%');
			}
			if(StringUtils.mathStr(t.getSchool())){
				sql+=" and s.school like ?";
				parmasList.add('%'+t.getSchool()+'%');
			}
			if(StringUtils.mathStr(t.getGender())){
				sql+=" and s.gender=?";
				parmasList.add(t.getGender());
			}
		}
		
		Object[] params=parmasList.toArray();
		int row=Integer.parseInt(String.valueOf(JDBCUtils.executeQueryPstmOne(sql, params)));
		return row;
	}

	@Override
	public PageModel<Student> select(PageModel<Student> pageModel) {
		String sql="select * from ( select rownum rn,t1.* from (select s.id,s.no,s.name,"
				+ "s.gender,s.class_id,s.school,s.profession,s.graduation_date,"
				+ "s.mobile,s.email,s.contact_name,s.contact_relation,s.contact_phone "
				+ "from t_student s where 1=1";
		List parmasList=new ArrayList<>();
		
		
		
		if(pageModel.getT()!=null){
			
			if(StringUtils.mathStr(pageModel.getT().getNo())){
				sql+=" and no like ?";
				parmasList.add('%'+pageModel.getT().getNo()+'%');
			}
			if(StringUtils.mathStr(pageModel.getT().getName())){
				sql+=" and name like ?";
				parmasList.add('%'+pageModel.getT().getName()+'%');
			}
			if(StringUtils.mathStr(pageModel.getT().getSchool())){
				sql+=" and school like ?";
				parmasList.add('%'+pageModel.getT().getSchool()+'%');
			}
			if(StringUtils.mathStr(pageModel.getT().getGender())){
				sql+=" and gender like ?";
				parmasList.add('%'+pageModel.getT().getGender()+'%');
			}
		}
		sql+=") t1 where rownum<=?) where rn>=? ";
		parmasList.add(pageModel.getPage()*pageModel.getPageSize());
		parmasList.add((pageModel.getPage()-1)*pageModel.getPageSize()+1);
		Object[] params=parmasList.toArray();
		List list=JDBCUtils.executeQueryPstm(sql, new StudentRowMapper(), params);
		pageModel.setDate(list);
		
		pageModel.setTotal(this.count(pageModel.getT()));
		return pageModel;
	}

	@Override
	public Student selectById(Integer id) {
		String sql="select s.id,s.no,s.name,"
				+ "s.gender,s.class_id,s.school,s.profession,s.graduation_date,"
				+ "s.mobile,s.email,s.contact_name,s.contact_relation,s.contact_phone "
				+ "from t_student s where s.id=?";
		Object[] params={id};
		List list=JDBCUtils.executeQueryPstm(sql, new StudentRowMapper(), params);
		if(list!=null&&list.size()>0){
			return (Student) list.get(0);
		}
		return null;
	}

	@Override
	public Student selectOne(Student t) {
		String sql="select s.id,s.no,s.name,"
				+ "s.gender,s.class_id,s.school,s.profession,s.graduation_date,"
				+ "s.mobile,s.email,s.contact_name,s.contact_relation,s.contact_phone "
				+ "from t_student s where 1=1";
		List parmasList=new ArrayList<>();
		
		if(t!=null){
			
			if(StringUtils.mathStr(t.getNo())){
				sql+=" and s.no=?";
				parmasList.add(t.getNo());
			}
			if(StringUtils.mathStr(t.getName())){
				sql+=" and s.name=?";
				parmasList.add(t.getName());
			}
			if(StringUtils.mathStr(t.getProfession())){
				sql+=" and s.profession=?";
				parmasList.add(t.getProfession());
			}
		}
		
		Object[] params=parmasList.toArray();
		List list=JDBCUtils.executeQueryPstm(sql, new StudentRowMapper(), params);
		if(list!=null&&list.size()>0){
			return (Student) list.get(0);
		}
		return null;
	}

	@Override
	public int add(Student t) {
		String sql="insert into t_student (id,no,name,gender,class_id,school,profession,graduation_date,mobile,email,contact_name,contact_relation,contact_phone) values(seq_t_student_id.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={t.getNo(),t.getName(),t.getGender(),t.getClass_id(),t.getSchool(),t.getProfession(),t.getGraduation_date(),t.getMobile(),t.getEmail(),t.getContact_name(),t.getContact_relation(),t.getContact_phone()};
		return JDBCUtils.executeUpdatePstm(sql, params);
	}

	@Override
	public int delete(Student t) {
		String sql="delete from t_student s where 1=1";
		List parmasList=new ArrayList<>();
		
		if(StringUtils.mathStr(t.getNo())){
			sql+=" and s.no=?";
			parmasList.add(t.getNo());
		}
		if(StringUtils.mathStr(t.getMobile())){
			sql+=" and s.mobile=?";
			parmasList.add(t.getMobile());
		}
		if(StringUtils.mathStr(t.getEmail())){
			sql+=" and s.email=?";
			parmasList.add(t.getEmail());
		}
		
		Object[] params=parmasList.toArray();
		return JDBCUtils.executeUpdatePstm(sql, params);
	}

	@Override
	public int deleteById(Integer id) {
		String sql="delete from t_student where id=?";
		Object[] params={id};
		return JDBCUtils.executeUpdatePstm(sql, params);
	}

	@Override
	public int update(Student t) {
		String sql="update t_student t set t.id=t.id";
		
		List paramsList=new ArrayList();
		
		if(StringUtils.mathStr(t.getName())){
			sql+=",t.name=?";
			paramsList.add(t.getName());
		}
		if(StringUtils.mathStr(t.getGender())){
			sql+=",t.gender=?";
			paramsList.add(t.getGender());
		}
		if(StringUtils.mathStr(t.getSchool())){
			sql+=",t.school=?";
			paramsList.add(t.getSchool());
		}
		if(StringUtils.mathStr(t.getProfession())){
			sql+=",t.profession=?";
			paramsList.add(t.getProfession());
		}
		if(StringUtils.mathStr(t.getMobile())){
			sql+=",t.mobile=?";
			paramsList.add(t.getMobile());
		}
		if(StringUtils.mathStr(t.getEmail())){
			sql+=",t.email=?";
			paramsList.add(t.getEmail());
		}
		if(StringUtils.mathStr(DateUtils.changerString(t.getGraduation_date()))){
			sql+=",t.graduation_date=?";
			paramsList.add(t.getGraduation_date());
		}
		sql+=" where t.id=?";
		paramsList.add(t.getId());
		Object[] params=paramsList.toArray();
		return JDBCUtils.executeUpdatePstm(sql, params);
	}

	

}
