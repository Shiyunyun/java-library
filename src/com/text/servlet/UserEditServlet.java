package com.text.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.text.entity.User;
import com.text.service.UserService;
import com.text.util.DateUtil;

/**
 * Servlet implementation class UserEditServlet
 */
@WebServlet("/userEditServlet")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=(String)request.getParameter("userName");
		User user=new User();
		user.setUsername(userName);
		System.out.println(user);
		UserService service=UserService.getInstance();
		User u=service.selectOne(user);
		
		HttpSession session=request.getSession();
		session.setAttribute("user", u);
		
		response.sendRedirect(request.getContextPath()+"/Admin/UserManageInfo_Amind_Edit.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		User u=(User) request.getSession().getAttribute("user");
		String userName=u.getUsername();
		
		String password="123456";
		String rule=request.getParameter("select");
		String realName=request.getParameter("textfield2");
		String sex=request.getParameter("userDTO.sex_code");
		String certType=request.getParameter("loginUserDTO.id_type_code");
		String cert=request.getParameter("textfield6");
		String birthday=request.getParameter("textfield7");
		String userType=request.getParameter("passenger_type");
		String content=request.getParameter("textarea");
		String button=request.getParameter("Submit");
		System.out.println("button："+button);
		
		UserService service=UserService.getInstance();
		
		User user=new User();
		user.setUsername(userName);
		if(button==null || "密码初始化".equals(button)){
			
			user.setRule(rule);
			user.setRealName(realName);
			user.setSex(sex);
			user.setCert(cert);
			user.setCert_type(Integer.valueOf(certType));
			user.setBirthday(DateUtil.toDate(birthday));
			user.setUser_type(Integer.valueOf(userType));
			user.setContent(content);
			System.out.println(user);
			boolean reasult=service.updateUser(user);
			if(reasult){
				response.sendRedirect(request.getContextPath()+"/Admin/UserManageQuery.jsp");
			}else{
				response.sendRedirect(request.getContextPath()+"/Admin/UserManageInfo_Amind_Edit.jsp");
			}
		}else{
			
			user.setPassword(password);
			
			boolean result=service.updateUser(user);
			
			response.sendRedirect(request.getContextPath()+"/Admin/UserManageInfo_Amind_Edit.jsp");
		}
		
	}

}
