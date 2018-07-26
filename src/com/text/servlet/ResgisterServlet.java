package com.text.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.text.entity.City;
import com.text.entity.User;
import com.text.service.CityService;
import com.text.service.UserService;
import com.text.util.DateUtil;

/**
 * Servlet implementation class ResgisterServlet
 */
@WebServlet("/ResgisterServlet")
public class ResgisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("textfield2");
		//System.out.println("userName:"+userName);
		String password=request.getParameter("textfield3");
		//System.out.println("password:"+password);
		String secondPassword=request.getParameter("textfield4");
		//System.out.println("secondPassword:"+secondPassword);
		String realName=request.getParameter("textfield8");
		//System.out.println("realName:"+realName);
		
		String gender=request.getParameter("userDTO.sex_code");
		//System.out.println("gender:"+gender);
		String province=request.getParameter("province");
		//System.out.println("province："+province);
		String city=request.getParameter("city");
		//System.out.println("city:"+city);
		String id_card_type=request.getParameter("loginUserDTO.id_type_code");
		//System.out.println("id_card_type"+id_card_type);
		String idCardNumber=request.getParameter("textfield6");
		//System.out.println("idCardNumber"+idCardNumber);
		String birthday=request.getParameter("textfield7");
		//System.out.println("birthday:"+birthday);
		String passenger_type=request.getParameter("passenger_type");
		//System.out.println("passenger_type"+passenger_type);
		String textarea=request.getParameter("textarea");
		//System.out.println("textarea:"+textarea);
		
		UserService userService=UserService.getInstance();
		
		CityService cityService=new CityService();
		City c=new City();
		c.setCity(city);
		System.out.println("c:"+c);
		City cy=cityService.selectOne(c);
		System.out.println("cy:"+cy);
		
		boolean result=userService.veriForm(userName);
//		System.out.println(result);
		//手动设置请求编码
		byte[] bytes=userName.getBytes("ISO-8859-1");
		String newUserName=new String(bytes,"utf-8");
		System.out.println("new:"+newUserName);
		User user=new User();
		if(result){
			user.setUsername(newUserName);
			
		}else{
			user.setUsername(null);
		}
		
		user.setPassword(password);
		user.setRealName(realName);
		user.setSex(gender);
		user.setBirthday(DateUtil.toDate(birthday));
		user.setCert_type(Integer.valueOf(id_card_type));
		user.setCert(idCardNumber);
		user.setCity(cy);
		user.setUser_type(Integer.valueOf(passenger_type));
		user.setContent(textarea);
	
	    boolean flag=userService.addUser(user);
		       
	    response.sendRedirect(request.getContextPath()+"/Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//请求
				request.setCharacterEncoding("utf-8");
				
				String userName=request.getParameter("textfield2");
				//System.out.println("userName:"+userName);
				String rule=request.getParameter("select");
				String password="123456";
				String realName=request.getParameter("textfield");
				//System.out.println("realName:"+realName);
				String gender=request.getParameter("userDTO.sex_code");
				//System.out.println("gender:"+gender);
				String province=request.getParameter("province");
				//System.out.println("province："+province);
				String city=request.getParameter("city");
				//System.out.println("city:"+city);
				String id_card_type=request.getParameter("loginUserDTO.id_type_code");
				//System.out.println("id_card_type"+id_card_type);
				String idCardNumber=request.getParameter("textfield6");
				//System.out.println("idCardNumber"+idCardNumber);
				String birthday=request.getParameter("textfield7");
				//System.out.println("birthday:"+birthday);
				String passenger_type=request.getParameter("passenger_type");
				//System.out.println("passenger_type"+passenger_type);
				String textarea=request.getParameter("textarea");
				//System.out.println("textarea:"+textarea);
				
				UserService userService=UserService.getInstance();
				
				CityService cityService=new CityService();
				City c=new City();
				c.setCity(city);
				System.out.println("c:"+c);
				City cy=cityService.selectOne(c);
				System.out.println("cy:"+cy);
				
				boolean result=userService.veriForm(userName);
//				System.out.println(result);
				//手动设置请求编码
				byte[] bytes=userName.getBytes("ISO-8859-1");
				String newUserName=new String(bytes,"utf-8");
				System.out.println("new:"+newUserName);
				User user=new User();
				if(result){
					user.setUsername(newUserName);
					
				}else{
					user.setUsername(null);
				}
				
				user.setPassword(password);
				user.setRealName(realName);
				user.setSex(gender);
				user.setRule(rule);
				user.setBirthday(DateUtil.toDate(birthday));
				user.setCert_type(Integer.valueOf(id_card_type));
				user.setCert(idCardNumber);
				user.setCity(cy);
				user.setUser_type(Integer.valueOf(passenger_type));
				user.setContent(textarea);
			
			    boolean flag=userService.addUser(user);
			    System.out.println(flag);
			    
			    response.sendRedirect(request.getContextPath()+"/Admin/UserInfo_Add.jsp");
	}

}
