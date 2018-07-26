package com.text.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.text.entity.User;

/**
 * 是否自动登录
 */
@WebFilter("/Login.jsp")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		String userName=null;
		String password=null;
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		
		 HttpSession session =request.getSession();
		
		Cookie[] cookies=request.getCookies();
		
		if(cookies!=null){
			
			for(int i=0;i<cookies.length;i++){
				
				String name=cookies[i].getName();
				String value=URLDecoder.decode(cookies[i].getValue(),"utf-8");
				
				if("userName".equals(name)){
					userName=value;
				}else if("password".equals(name)){
					password=value;
				}
			}
			
			if((userName!=null&&!"".equals(userName)) && (password!=null && !"".equals(password))){
				session.setAttribute("userName", userName);
				session.setAttribute("password", password);
				
				response.sendRedirect(request.getContextPath()+"/LoginServlet");
			}
			
			chain.doFilter(request, response);
		}else{
			
			response.sendRedirect(request.getContextPath()+"/Login.jsp");
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
