package com.neuedu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.TeacherDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Teacher;
import com.neuedu.entity.rowmapper.TeacherRowMapper;
import com.neuedu.utils.JDBCUtils;
import com.neuedu.utils.StringUtils;

public class TeacherDaoImpl implements TeacherDao {

	@Override
	public int count(Teacher t) {
		/**
		 * 准备sql
		 */
		List paramsList = new ArrayList();
		String sql = "select count(*) from t_teacher t where 1=1";
		if(t!=null){
			if (StringUtils.mathStr(t.getNo())) {
				sql += " and t.no like ?";
				paramsList.add('%'+t.getNo()+'%');
			}
			if (StringUtils.mathStr(t.getName())) {
				sql += " and t.name like ?";
				paramsList.add('%'+t.getName()+'%');
			}
			if (StringUtils.mathStr(t.getGender())) {
				sql += " and t.gender=?";
				paramsList.add(t.getGender());
			}
			if (StringUtils.mathStr(t.getMobile())) {
				sql += " and t.mobile like ?";
				paramsList.add('%'+t.getMobile()+'%');
			}
		}
	

		Object[] params = paramsList.toArray();
		// Integer row=(Integer)JDBCUtils.executeQueryPstmOne(sql,params);
		int row = Integer.parseInt(String.valueOf(JDBCUtils.executeQueryPstmOne(sql, params)));
		// System.out.println(row);
		return row;
	}

	@Override
	public PageModel<Teacher> select(PageModel<Teacher> pageModel) {
		String sql="select * from "
				+ "(select rownum rn,t1.* from "
				+ "(select t.id,t.no,t.name,t.gender,t.qq,t.mobile,t.email,t.job "
				+ "from t_teacher t where 1=1"; 
		List paramsList = new ArrayList();
		
		
		if(pageModel.getT()!=null) {
			if (StringUtils.mathStr(pageModel.getT().getNo())) {
				sql += " and no like ?";
				paramsList.add('%'+pageModel.getT().getNo()+'%');
			}
			if (StringUtils.mathStr(pageModel.getT().getName())) {
				sql += " and name like ?";
				paramsList.add('%'+pageModel.getT().getName()+'%');
			}
			if (StringUtils.mathStr(pageModel.getT().getGender())) {
				sql += " and gender like ?";
				paramsList.add('%'+pageModel.getT().getGender()+'%');
			}
			if (StringUtils.mathStr(pageModel.getT().getMobile())) {
				sql += " and mobile like ?";
				paramsList.add('%'+pageModel.getT().getMobile()+'%');
			}
		}
		sql+=" order by t.no ) t1 where rownum<=?) where rn>=? ";
		paramsList.add(pageModel.getPage()*pageModel.getPageSize());
		paramsList.add((pageModel.getPage()-1)*pageModel.getPageSize()+1);
		Object[] params = paramsList.toArray();
		//查询数据
		List list=JDBCUtils.executeQueryPstm(sql, new TeacherRowMapper(), params);
		pageModel.setDate(list);
		//计算记录数
		pageModel.setTotal(this.count(pageModel.getT()));
		
		return pageModel;
	}

	@Override
	public Teacher selectOne(Teacher t) {
		String sql = "select t.id,t.no,t.name,t.gender,t.qq,t.mobile,t.email,t.job from t_teacher t where 1=1";
		List paramsList = new ArrayList();
		if (StringUtils.mathStr(t.getNo())) {
			sql += " and t.no=?";
			paramsList.add(t.getNo());
		}
		if (StringUtils.mathStr(t.getName())) {
			sql += " and t.name=?";
			paramsList.add(t.getName());
		}
		if (StringUtils.mathStr(t.getMobile())) {
			sql += " and t.Mobile=?";
			paramsList.add(t.getMobile());
		}
		if (StringUtils.mathStr(t.getPassword())) {
			sql += " and t.password=?";
			paramsList.add(t.getPassword());
		}

		Object[] params = paramsList.toArray();
		List list=JDBCUtils.executeQueryPstm(sql, new TeacherRowMapper(), params);
		if(list!=null&&list.size()>0){
			return (Teacher) list.get(0);
		}
		return null;
	}

	@Override
	public Teacher selectById(Integer id) {
		String sql = "select id,no,name,gender,qq,mobile,email,job from t_teacher where id=?";
		Object[] params={id};
		List list=JDBCUtils.executeQueryPstm(sql, new TeacherRowMapper(), params);
		if(list!=null&&list.size()>0){
			return (Teacher) list.get(0);
		}
		return null;
	}

	@Override
	public int add(Teacher t) {
		String sql="insert into t_teacher (id,no,password,name,gender,mobile,qq,email,job) values(seq_t_teacher_id.nextval,?,?,?,?,?,?,?,?)";
		Object[] params={t.getNo(),t.getPassword(),t.getName(),t.getGender(),t.getMobile(),t.getQq(),t.getEmail(),t.getJob()};
		int row=JDBCUtils.executeUpdatePstm(sql, params);
		
		return row;
	}

	@Override
	public int delete(Teacher t) {
		String sql="delete from t_teacher where 1=1";
		List list=new ArrayList<>();
		if(StringUtils.mathStr(t.getNo())){
			sql+=" and no=?";
			list.add(t.getNo());
		}
		if(StringUtils.mathStr(t.getName())){
			sql+=" and name=?";
			list.add(t.getName());
		}
		if(StringUtils.mathStr(t.getJob())){
			sql+=" and job=?";
			list.add(t.getJob());
		}
		Object[] params=list.toArray();
		return JDBCUtils.executeUpdatePstm(sql, params);
	}

	@Override
	public int deleteById(Integer id) {
		String sql="delete from t_teacher where id=?";
		Object[] params={id};
		
		return JDBCUtils.executeUpdatePstm(sql, params);
	}

	@Override
	public int update(Teacher t) {
		String sql="update  t_teacher t set t.id=t.id";
		List paramsList=new ArrayList<>();
		if(StringUtils.mathStr(t.getName())) {
			sql += " ,t.name = ? ";
			paramsList.add(t.getName());
		}
		if(StringUtils.mathStr(t.getEmail())) {
			sql += " ,t.email = ? ";
			paramsList.add(t.getEmail());
		}
		if(StringUtils.mathStr(t.getGender())) {
			sql += " ,t.gender = ? ";
			paramsList.add(t.getGender());
		}
		if(StringUtils.mathStr(t.getJob())) {
			sql += " ,t.job = ? ";
			paramsList.add(t.getJob());
		}
		if(StringUtils.mathStr(t.getPassword())) {
			sql += " ,t.password = ? ";
			paramsList.add(t.getPassword());
		}
		if(StringUtils.mathStr(t.getMobile())) {
			sql += " ,t.mobile = ? ";
			paramsList.add(t.getMobile());
		}
		if(StringUtils.mathStr(t.getQq())) {
			sql += " ,t.qq = ? ";
			paramsList.add(t.getQq());
		}
		sql += " where t.id=? ";
		paramsList.add(t.getId());
		Object[] params = paramsList.toArray();
		return JDBCUtils.executeUpdatePstm(sql, params);
	}

	@Override
	public List<Teacher> selectAll() {
		
		String sql="select t.id,t.no,t.name,t.gender,t.qq,t.mobile,t.email,t.job from t_teacher t where 1=1 order by t.no";
		
	
		return JDBCUtils.executeQueryPstm(sql, new TeacherRowMapper(), null);
	}

}
