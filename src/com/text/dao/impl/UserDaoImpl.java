package com.text.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.text.dao.UserDao;
import com.text.entity.User;
import com.text.util.DateUtil;
import com.text.util.JDBCUtil;

public class UserDaoImpl implements UserDao{

	Connection conn=null;
	
	
	

	public UserDaoImpl(Connection conn){
		this.conn=conn;
	}

	@Override
	public boolean addUser(User user) {
		String sql="insert into tab_user (id,username,password,realName,sex,city,cert_type,cert,birthday,user_type,content) values(tab_user_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={user.getUsername(),user.getPassword(),user.getRealName(),user.getSex(),user.getCity().getId(),user.getCert_type(),user.getCert(),new Date(user.getBirthday().getTime()),user.getUser_type(),user.getContent()};
		int row=JDBCUtil.executeUpdate(sql, params,conn);
		if(row>0){
			return true;
		}
		return false;
	}

	@Override
	public User selectOne(User user) {
		
		String sql="select t.id,t.username,t.password,t.rule,t.realname,t.sex,c.id,t.cert_type,"
				+ "ct.contents,t.cert,t.birthday,t.user_type,ut.ucontent,t.image_path,t.content,c.city,p.province "
				+ "from tab_user t,tab_city c,tab_province p,tab_certtype ct,tab_usertype ut "
				+ "where t.city=c.id and c.father=p.provinceid and t.cert_type=ct.id and t.user_type=ut.id ";
		List paramsList=new ArrayList<>();
		if(user!=null){
			if(user.getUsername()!=null){
				sql+=" and t.username=?";
				paramsList.add(user.getUsername());
			}
			if(user.getPassword()!=null){
			
				sql+=" and t.password=?";
				paramsList.add(user.getPassword());
			}
		}
		
		Object[] params=paramsList.toArray();
		
		List list=JDBCUtil.executeQuery(sql, params,conn);
		
		if(list!=null&&list.size()>0){
			return (User) list.get(0);
		}
		return null;
		
	}

	@Override
	public boolean updateUser(User user) {
		String sql="update tab_user t set t.id=t.id ";
		List paramsList=new ArrayList<>();
		if(user.getPassword()!=null){
			sql+=" , t.password=?";
			paramsList.add(user.getPassword());
		}
		if(user.getUser_type()!=0){
			sql+=",t.user_type=?";
			paramsList.add(user.getUser_type());
		}
		if(user.getContent()!=null && !"".equals(user.getContent().trim())){
			sql+=",t.content=?";
			paramsList.add(user.getContent());
			
		}
		if(user.getRule()!=null && !"".equals(user.getRule().trim())){
			sql+=",t.rule=?";
			paramsList.add(user.getRule());
		}
		if(user.getRealName()!=null && !"".equals(user.getRealName().trim())){
			sql+=",t.realname =?";
			paramsList.add(user.getRealName());
		}
		if(user.getSex()!=null && !"".equals(user.getSex().trim())){
			sql+=",t.sex=?";
			paramsList.add(user.getSex());
		}
		if(user.getCert()!=null && !"".equals(user.getCert().trim())){
			sql+=",t.cert=?";
			paramsList.add(user.getCert());
		}
		if(user.getCert_type()!=0){
			sql+=",t.cert_type=?";
			paramsList.add(user.getCert_type());
		}
		if(DateUtil.formats(user.getBirthday())!=null){
			sql+=",t.birthday=?";
			paramsList.add(new Date(user.getBirthday().getTime()));
		}
		if(user.getImage_path()!=null && !"".equals(user.getImage_path())){
			sql+=",t.image_path=?";
			paramsList.add(user.getImage_path());
		}
		
		sql+=" where t.username=?";
		paramsList.add(user.getUsername());
		
		System.out.println("sql"+sql);
		
		Object[] params=paramsList.toArray();
		int row=JDBCUtil.executeUpdate(sql, params,conn);
		if(row>0){
			return true;
		}
		return false;
	}

	@Override
	public List<User> selectAll(User user) {
		
		String sql="select t.id,t.username,t.password,t.rule,t.realname,t.sex,c.id,t.cert_type,"
				+ "ct.contents,t.cert,t.birthday,t.user_type,ut.ucontent,t.image_path,t.content,c.city,p.province "
				+ "from tab_user t,tab_city c,tab_province p,tab_certtype ct,tab_usertype ut "
				+ "where t.city=c.id and c.father=p.provinceid and t.cert_type=ct.id and t.user_type=ut.id ";
		List paramList=new ArrayList<>();
		if(user!=null){
			
			if(user.getUsername()!=""){
				System.out.println(1);
				sql+=" and t.username=?";
				paramList.add(user.getUsername());
			}
			if(user.getSex()!=""){
				sql+=" and t.sex=?";
				paramList.add(user.getSex());
			}
			
			if(user.getCert_type()!=0){
				sql+=" and t.cert_type=?";
				paramList.add(user.getCert_type());
			}
			
			if(user.getUser_type()!=0){
				sql+=" and t.user_type=?";
				paramList.add(user.getUser_type() );
			}
			if(user.getCert()!=""){
				
				sql+=" and t.cert like ?";
				paramList.add('%'+user.getCert()+'%');
			}
		}
		Object[] params=paramList.toArray();
		System.out.println(Arrays.toString(params));
		return JDBCUtil.executeQuery(sql, params,conn);
		
	}

	@Override
	public boolean deleteUser(User user) {
		String sql="delete from tab_user t where 1=1";
		List paramsList=new ArrayList<>();
		if(user!=null){
			if(user.getUsername()!=null){
				sql+=" and t.username=?";
				paramsList.add(user.getUsername());
			}
		}
		Object[] params=paramsList.toArray();
		int row=JDBCUtil.executeUpdate(sql, params, conn);
		if(row>0){
			return true;
		}
		return false;
	}

	@Override
	public List<User> selectAllByPage(User user, int pageNum, int pageSize) {
		
		String sql="select tx.* from (select rownum rn,tb.* from (select t.id,t.username,t.password,t.rule,t.realname,t.sex,c.id cid,t.cert_type,"
				+ "ct.contents,t.cert,t.birthday,t.user_type,ut.ucontent,t.image_path,t.content,c.city,p.province "
				+ "from tab_user t,tab_city c,tab_province p,tab_certtype ct,tab_usertype ut "
				+ "where t.city=c.id and c.father=p.provinceid and t.cert_type=ct.id and t.user_type=ut.id ";
		List paramList=new ArrayList<>();
		if(user!=null){
			
			if(user.getUsername()!=""){
				System.out.println(1);
				sql+=" and t.username=?";
				paramList.add(user.getUsername());
			}
			if(user.getSex()!=""){
				sql+=" and t.sex=?";
				paramList.add(user.getSex());
			}
			
			if(user.getCert_type()!=0){
				sql+=" and t.cert_type=?";
				paramList.add(user.getCert_type());
			}
			
			if(user.getUser_type()!=0){
				sql+=" and t.user_type=?";
				paramList.add(user.getUser_type() );
			}
			if(user.getCert()!=""){
				
				sql+=" and t.cert like ?";
				paramList.add('%'+user.getCert()+'%');
			}
		}
		sql+=") tb where rownum<="+pageNum*pageSize+" ) tx where tb.rn>="+(pageNum-1)*pageSize+1+"";
		Object[] params=paramList.toArray();
		System.out.println(Arrays.toString(params));
		return JDBCUtil.executeQuery(sql, params,conn);
	}
}
