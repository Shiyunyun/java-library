package com.neuedu.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.ClassesDao;
import com.neuedu.entity.Classes;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.rowmapper.ClassesRowMapper;
import com.neuedu.utils.DateUtils;
import com.neuedu.utils.JDBCUtils;
import com.neuedu.utils.StringUtils;

public class ClassesDaoImpl implements ClassesDao{

	@Override
	public int count(Classes t) {
		String sql="select count(*) from t_class t where 1=1";
		List paramsList=new ArrayList<>();
		if(t!=null){
			if(StringUtils.mathStr(t.getName())){
				sql+=" and t.name like ?";
				paramsList.add('%'+t.getName()+'%');
			}
			if(StringUtils.mathStr(t.getStudy_direction())){
				sql+=" and t.study_direction like ?";
				paramsList.add('%'+t.getStudy_direction()+'%');
			}
			if(StringUtils.mathStr(t.getClassroom())){
				sql+=" and t.classroom like ?";
				paramsList.add('%'+t.getClassroom()+'%');
			}
			
			if(t.getId()!=null){
				sql+=" and t.id=?";
				paramsList.add(t.getId());
			}
		}
		Object[] params=paramsList.toArray();
		int row=Integer.parseInt(String.valueOf(JDBCUtils.executeQueryPstmOne(sql, params)));
		return row;
	}


	@Override
	public PageModel<Classes> select(PageModel<Classes> pageModel) {
		String sql="select * from (select rownum rn ,t1.* from (select t.id,t.name,t.start_date,t.end_date,t.study_direction ,t.classroom ,t.count from t_class t where 1=1";
		List paramsList=new ArrayList();
		if(pageModel.getT()!=null){
			
			if(StringUtils.mathStr(pageModel.getT().getName())){
				sql+=" and name like ?";
				paramsList.add('%'+pageModel.getT().getName()+'%');
			}
			if(StringUtils.mathStr(pageModel.getT().getClassroom())){
				sql+=" and classroom like ?";
				paramsList.add('%'+pageModel.getT().getClassroom()+'%');
			}
			if(StringUtils.mathStr(pageModel.getT().getStudy_direction())){
				sql+=" and study_direction like ?";
				paramsList.add('%'+pageModel.getT().getStudy_direction()+'%');
			}
			if(pageModel.getT().getId()!=null){
				
				sql+=" and id =?";
				paramsList.add(pageModel.getT().getId());
			}
		}
		sql+=" order by id ) t1 where rownum<=?) where rn>=?";
		paramsList.add(pageModel.getPage()*pageModel.getPageSize());
		paramsList.add((pageModel.getPage()-1)*pageModel.getPageSize()+1);
		
		Object[] params=paramsList.toArray();
		List<Classes> list=JDBCUtils.executeQueryPstm(sql, new ClassesRowMapper(), params);
		pageModel.setDate(list);
		pageModel.setTotal(this.count(pageModel.getT()));
		return pageModel;
	}


	@Override
	public Classes selectOne(Classes t) {
		String sql="select t.id,t.name,t.start_date,t.end_date,t.study_direction,t.classroom,t.count from t_class t where 1=1";
		List paramsList=new ArrayList<>();
		if(t!=null){
			if(StringUtils.mathStr(t.getName())){
				sql+=" and t.name=?";
				paramsList.add(t.getName());
			}
			if(StringUtils.mathStr(t.getStudy_direction())){
				sql+=" and t.study_direaction=?";
				paramsList.add(t.getStudy_direction());
			}
			if(StringUtils.mathStr(t.getClassroom())){
				sql+=" and t.classroom";
				paramsList.add(t.getClassroom());
			}
			
			if(t.getId()!=null){
				sql+=" and t.id=?";
				paramsList.add(t.getId());
			}
		}
		Object[] params=paramsList.toArray();
		List list=JDBCUtils.executeQueryPstm(sql, new ClassesRowMapper(), params);
		if(list!=null&&list.size()>0){
			return (Classes) list.get(0);
		}
		return null;
	}

	@Override
	public Classes selectById(Integer id) {
		String sql="select t.id,t.name,t.start_date,t.end_date,t.study_direction,t.classroom,t.count from t_class t where t.id=?";
		Object[] params={id};
		List list=JDBCUtils.executeQueryPstm(sql, new ClassesRowMapper(), params);
		if(list!=null){
			return (Classes) list.get(0);
		}
		return null;
	}

	@Override
	public int add(Classes t) {
		String sql="insert into t_class (id,name,start_date,end_date,study_direction,classroom,count) values(?,?,?,?,?,?,?)";
		Object[] params={t.getId(),t.getName(),t.getStart_date(),t.getEnd_date(),t.getStudy_direction(),t.getClassroom(),t.getCount()};
		return JDBCUtils.executeUpdatePstm(sql, params);
	}

	@Override
	public int delete(Classes t) {
		String sql="delete from t_class where 1=1";
		List paramsList=new ArrayList<>();
		if(t!=null){
			if(StringUtils.mathStr(t.getName())){
				sql+=" and t.name=?";
				paramsList.add(t.getName());
			}
			if(StringUtils.mathStr(t.getStudy_direction())){
				sql+=" and t.study_direaction=?";
				paramsList.add(t.getStudy_direction());
			}
			if(StringUtils.mathStr(t.getClassroom())){
				sql+=" and t.classroom";
				paramsList.add(t.getClassroom());
			}
			
		}
		Object[] params=paramsList.toArray();
		return JDBCUtils.executeUpdatePstm(sql, params);
	}

	@Override
	public int deleteById(Integer id) {
		String sql="delete from t_class where id=?";
		Object[] params={id};
		return JDBCUtils.executeUpdatePstm(sql, params);
	}

	@Override
	public int update(Classes t) {
		String sql="update t_class t set t.id=t.id";
		List paramsList=new ArrayList<>();
		if(StringUtils.mathStr(t.getName())){
			sql+=",t.name=?";
			paramsList.add(t.getName());
		}
		if(StringUtils.mathStr(t.getClassroom())){
			sql+=",t.classroom=?";
			paramsList.add(t.getClassroom());
		}
		if(StringUtils.mathStr(DateUtils.changerString(t.getStart_date()))){
			sql+=",t.start_date=?";
			paramsList.add(t.getStart_date());
		}
		if(StringUtils.mathStr(DateUtils.changerString(t.getEnd_date()))){
			sql+=",t.end_date=?";
			paramsList.add(t.getEnd_date());
		}
		if(StringUtils.mathStr(t.getStudy_direction())){
			sql+=",t.study_direction=?";
			paramsList.add(t.getStudy_direction());
		}
		if(StringUtils.mathStr(t.getCount()+"")){
			sql+=",t.count=?";
			paramsList.add(t.getCount());
		}
		sql+=" where t.id=?";
		paramsList.add(t.getId());
		Object[] params=paramsList.toArray();
		return JDBCUtils.executeUpdatePstm(sql, params);
	}


	@Override
	public List<Classes> selectAll() {
		String sql="select t.id,t.name,t.classroom,t.study_direction,t.start_date,t.end_date,t.count from t_class t order by t.id";
		
		return JDBCUtils.executeQueryPstm(sql, new ClassesRowMapper(), null);
	}



}
