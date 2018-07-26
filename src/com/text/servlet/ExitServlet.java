package com.text.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ExitServlet
 */
@WebServlet("/exitServlet")
public class ExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//1、清除session
			HttpSession session=request.getSession();
			session.invalidate();
		
			//2、清除cookie
			Cookie[] cookies=request.getCookies();
			
			for(int i=0;i<cookies.length;i++){
				Cookie cookie=cookies[i];
				
				cookie.setMaxAge(0);
				
				cookie.setValue(null);
				
				cookie.setPath(request.getContextPath()+"/");
				
				response.addCookie(cookie);
			}
			
			response.sendRedirect(request.getContextPath()+"/Login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
