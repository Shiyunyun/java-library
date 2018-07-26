package com.text.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.text.entity.User;
import com.text.service.UserService;
import com.text.util.MD5Util;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userName=(String) session.getAttribute("userName");
		String password=(String) session.getAttribute("password");
		System.out.println(userName+"-"+password);
		
		User user=new User(userName,password);
		
		UserService service=UserService.getInstance();
		User u=service.selectOne(user);
		
		if(u!=null){
			
			if(userName.equals(u.getUsername()) && MD5Util.MD5(password).equals(u.getPassword())){
				
				session.setAttribute("user", u);
				
				if("2".equals(u.getRule())){
					response.sendRedirect(request.getContextPath()+"/User/Index.jsp");
				}else{
					
					response.sendRedirect(request.getContextPath()+"/Admin/Index.jsp");
				}
				
			}else{
				
				request.getRequestDispatcher("/exitServlet").forward(request, response);
			}
		}else{
			request.getRequestDispatcher("/exitServlet").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		String userName=request.getParameter("textfield");//获取用户名
		String password=request.getParameter("textfield2");//获取密码
		String userCode=request.getParameter("textfield3").toLowerCase();//获取用户输入的验证码
		String loginAuto=request.getParameter("checkbox");//获取自动登录的值
		
		User user=new User();
		user.setUsername(userName);
		user.setPassword(password);
		
		UserService service=UserService.getInstance();
		if(userName!="" && password!="" &&  userCode!=""){
			User u=service.selectOne(user);
			if(u!=null){
				
				HttpSession session=request.getSession();
				String serviceCode=(String) session.getAttribute("code");
				session.setAttribute("usesCode", userCode.toLowerCase());
				session.setAttribute("user", u);
				session.setAttribute("passwd", password);
				
				if(userName.equals(u.getUsername())&& MD5Util.MD5(password).equals(u.getPassword()) && serviceCode.equals(userCode)){
					
					
					if(loginAuto!=null && "loginauto".equals(loginAuto)){
						System.out.println(1);
						Cookie cookieName=new Cookie("userName",URLEncoder.encode(userName,"utf-8"));
						Cookie cookiePasswd=new Cookie("password",password);
						
						cookieName.setMaxAge(7*24*60*60);
						cookiePasswd.setMaxAge(7*24*60*60);
						
						cookieName.setPath(request.getContextPath()+"/");
						cookiePasswd.setPath(request.getContextPath()+"/");
						
						response.addCookie(cookieName);
						response.addCookie(cookiePasswd);
						
					}

					if("2".equals(u.getRule())){
						response.sendRedirect(request.getContextPath()+"/User/Index.jsp");
					}else{
						
						response.sendRedirect(request.getContextPath()+"/Admin/Index.jsp");
					}
					
				}else{
					request.setAttribute("title", "验证码错误，请重新输入");
					
					request.getRequestDispatcher("/Login.jsp").forward(request, response);;
				}
				
			}else{
				request.setAttribute("title", "用户名或密码错误");
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("title", "用户名或密码为空");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}

}
