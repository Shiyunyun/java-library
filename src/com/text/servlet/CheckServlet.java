package com.text.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.text.entity.User;
import com.text.service.UserService;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/checkServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		
		System.out.println(userName);
		
		User user=new User();
		user.setUsername(userName);
		UserService service=UserService.getInstance();
		
		User u=service.selectOne(user);
		boolean flag=service.veriForm(userName);
		System.out.println(flag);
		PrintWriter pw=response.getWriter();
		
		if(flag){
			if(u==null){
				pw.write("该用户名可以使用");	
			}else{
				
				pw.write("用户名已使用");
			}
		}else{
			pw.write("请输入正确格式");
		}
		
		
		pw.flush();
		pw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
