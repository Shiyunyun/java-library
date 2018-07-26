package com.text.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.text.entity.City;
import com.text.entity.User;
import com.text.service.CityService;
import com.text.service.UserService;
import com.text.util.PageUtil;

/**
 * Servlet implementation class UserAdmin
 */
@WebServlet("/userAdmin")
public class UserAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String pageNum=request.getParameter("pageNum");
		
		UserService service=UserService.getInstance();
		
	if(pageNum!=null && !"".equals(pageNum.trim())){
			
			List<User> list=(List<User>) session.getAttribute("userList");
			PageUtil pu=null;
			if(session.getAttribute("size")!=null){
				
				 pu=new PageUtil(list,(int)session.getAttribute("size"));
			}else{
				 pu=new PageUtil(list,10);
			}
			pu.setPageNum(Integer.valueOf(pageNum));
			
			List<User> subList=list.subList(pu.getBeginIndex()-1, pu.getEndIndex());
			
			session.setAttribute("subList", subList);
			session.setAttribute("pu", pu);
			
		}else{
			
			List<User> list=service.selectAll(null);
			
			PageUtil pu=new PageUtil(list,10);
			
			List<User> subList=list.subList(pu.getBeginIndex()-1, pu.getEndIndex());
			
			session.setAttribute("userList", list);
			session.setAttribute("subList", subList);
			session.setAttribute("pu", pu);
			
		
		}
	
		response.sendRedirect(request.getContextPath()+"/Admin/UserManageQuery.jsp");
				
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setCharacterEncoding("utf-8");
			
			UserService service=UserService.getInstance();
			
			String size=request.getParameter("select2");
			
			String userName=request.getParameter("textfield");
			String sex=request.getParameter("select");
			String certType=request.getParameter("loginUserDTO.id_type_code");
			String cert=request.getParameter("textfield2");
			String userType=request.getParameter("passenger_type");
			
			String[] checkes=request.getParameterValues("checkbox");
			System.out.println(Arrays.toString(checkes));
			
			User user=new User();
			user.setUsername(userName);
			user.setSex(sex);
			if(certType!=null && !"".equals(certType)){
				
				user.setCert_type(Integer.valueOf(certType));
			}
			user.setCert(cert);
			if(userType!=null && !"".equals(userType)){
				
				user.setUser_type(Integer.valueOf(userType));
			}
			
			//删除
			List<User> uList=(List<User>) request.getSession().getAttribute("userList");
			User u=new User();
			if(checkes!=null){
				for(int i=0;i<checkes.length;i++){
					for(int j=0;j<uList.size();j++){
						if(checkes[i].equals(uList.get(j).getUsername())){
							u.setUsername(checkes[i]);
							service.deleteUser(u);
							break;
						}
					}
				}
			}
			
			List<User> list=service.selectAll(user);
			
			PageUtil pu=new PageUtil(list,Integer.valueOf(size));
			
			
			
			List<User> subList=list.subList(pu.getBeginIndex()-1, pu.getEndIndex());
			
			HttpSession session=request.getSession();
			session.setAttribute("size", Integer.valueOf(size));
			session.setAttribute("userList", list);
			session.setAttribute("subList", subList);
			session.setAttribute("pu", pu);
			
			
			response.sendRedirect(request.getContextPath()+"/Admin/UserManageQuery.jsp");
		
		
	}

}
