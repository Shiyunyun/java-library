package com.text.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.text.entity.User;

@WebFilter("/Admin/Index.jsp")
public class RuleFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	System.out.println("初始化登录过滤器");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse) response;
		
		HttpSession session=req.getSession();
		
		User user=(User) session.getAttribute("user");
		String rule=null;
		if(user!=null){
			
		 rule=user.getRule();
		}
		
		if("1".equals(rule)){
			System.out.println("执行登录过滤器1");
			chain.doFilter(req, resp);
		}else if("2".equals(rule)){
			System.out.println("执行登录过滤器2");
			String uri=req.getRequestURI();
			if(uri.contains("Admin")){
				resp.sendRedirect(req.getContextPath()+"/User/Index.jsp");
			}else{
				chain.doFilter(req, resp);
			}
		}else{
			
			System.out.println("执行登录过滤器3");
			resp.sendRedirect(req.getContextPath()+"/Login.jsp");
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
