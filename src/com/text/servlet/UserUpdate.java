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
import com.text.util.MD5Util;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/userUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		User user=(User) session.getAttribute("user");
		String userName=user.getUsername();
		
		String content=request.getParameter("textarea");
		String user_type=request.getParameter("passenger_type");
		
		User u=new User();
		u.setUsername(userName);
		u.setUser_type(Integer.valueOf(user_type));
		u.setContent(content);
		
		UserService service=UserService.getInstance();
		
		boolean result=service.updateUser(u);
		System.out.println(true);
		if(result){
			response.sendRedirect(request.getContextPath()+"/User/Index.jsp");
		}else{
			response.sendRedirect(request.getContextPath()+"/User/UserManageInfo_Edit.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String oldPassword=request.getParameter("textfield5");
		String newPassword=request.getParameter("textfield6");
		String againPassword=request.getParameter("textfield7");
		
		
		User user=(User) session.getAttribute("user");
		
		UserService service=UserService.getInstance();
	
		if(MD5Util.MD5(oldPassword).equals(user.getPassword())){
			
			if(newPassword!="" &&  againPassword!="" && newPassword.equals(againPassword)){
				User u=new User();
				u.setPassword(newPassword);
				u.setUsername(user.getUsername());
				boolean result=service.updateUser(u);
				
				if(result){
					request.setAttribute("mag", "修改成功");
					request.getRequestDispatcher("/User/Index.jsp").forward(request, response);
					
				}else{
					request.setAttribute("mag", "修改失败");
					request.getRequestDispatcher("/User/UserPassword_Edit.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("mag", "两次输入的密码不相同");
				request.getRequestDispatcher("/User/UserPassword_Edit.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("mag", "初始密码错误");
			request.getRequestDispatcher("/User/UserPassword_Edit.jsp").forward(request, response);
		}
	}

}
