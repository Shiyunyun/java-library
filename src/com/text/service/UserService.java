package com.text.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.text.dao.UserDao;
import com.text.dao.impl.UserDaoImpl;
import com.text.entity.User;
import com.text.util.JDBCUtil;
import com.text.util.MD5Util;

public class UserService {

	private static final UserService service=new UserService();
	
	Connection conn=null;
	private UserService(){
		
	}
	
	public static UserService getInstance(){
		return service;
	}
	
	public boolean addUser(User user){
		try {
			conn=JDBCUtil.getConnection();
			
			user.setPassword(MD5Util.MD5(user.getPassword()));
			JDBCUtil.beginTransation(conn);
			UserDao userDao=new UserDaoImpl(conn);
			if(userDao.addUser(user)){
				JDBCUtil.commitTransation(conn);
				
				JDBCUtil.close(conn);
				return true;
			}else{
				JDBCUtil.rollBackTransation(conn);
				JDBCUtil.close(conn);
				return false;
			}
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//验证格式
	public boolean veriForm(String str){
		if(str!=null){
			/*char[] ch=str.toCharArray();
			if(ch.length>5 && ch.length<=30){
				for(int i=0;i<ch.length;i++){
					if(!(ch[i]>=65&&ch[i]<=90||ch[i]>=97&&ch[i]<=122||ch[i]>=48&&ch[i]<=57||ch[i]=='_')){
						return false;
					}
				}
				return true;
			}*/
			String reg="^[a-zA-Z0-9_]{6,30}$";
			if(str.matches(reg)){
				return true;
			}
		}
		return false;
	}
	
	//验证用户是否已存在
	public User selectOne(User user){
		try {
			conn=JDBCUtil.getConnection();
			if(user!=null ){
				
				user.setPassword(MD5Util.MD5(user.getPassword()));
			}
			UserDao userDao=new UserDaoImpl(conn);
			
			User u=userDao.selectOne(user);
			
			JDBCUtil.close(conn);
			return 	u;
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//更新
		public boolean updateUser(User user){
			try {
				conn=JDBCUtil.getConnection();
				JDBCUtil.beginTransation(conn);
				
				if(user.getPassword()!=null){
					
					user.setPassword(MD5Util.MD5(user.getPassword()));
				}
				UserDao userDao=new UserDaoImpl(conn);
				
				if(userDao.updateUser(user)){
					JDBCUtil.commitTransation(conn);
					
					JDBCUtil.close(conn);
					return true;
				}else{
					JDBCUtil.rollBackTransation(conn);
					
					JDBCUtil.close(conn);
					
					return false;
				}
			
			} catch (NamingException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
		}
		
		//查询所有
		public List<User> selectAll(User user){
			
			try {
				conn=JDBCUtil.getConnection();
				
				UserDao userDao=new UserDaoImpl(conn);
				List<User> list=userDao.selectAll(user);
				
				JDBCUtil.close(conn);
				
				return list;
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}
			return null;
			
		}
		
		//分页查询所有数据
				public List<User> selectAllByPage(User user,int pageNum,int pageSize){
					
					try {
						conn=JDBCUtil.getConnection();
						
						UserDao userDao=new UserDaoImpl(conn);
						List<User> list=userDao.selectAllByPage(user, pageNum, pageSize);
						
						JDBCUtil.close(conn);
						
						return list;
					} catch (NamingException | SQLException e) {
						e.printStackTrace();
					}
					return null;
					
				}
		
		//删除
		public boolean deleteUser(User user){
			
			try {
				conn=JDBCUtil.getConnection();
				JDBCUtil.beginTransation(conn);
				
				UserDao userDao=new UserDaoImpl(conn);
				boolean result=userDao.deleteUser(user);
				
				if(result){
					JDBCUtil.commitTransation(conn);
					
					JDBCUtil.close(conn);
					return true;
				}else{
					JDBCUtil.rollBackTransation(conn);
					JDBCUtil.close(conn);
					
					return false;
				}
				
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return false;
			
		}
		
		
}
