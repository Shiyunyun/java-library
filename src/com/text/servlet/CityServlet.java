package com.text.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.text.entity.City;
import com.text.entity.Province;
import com.text.service.CityService;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet("/cityServlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CityService service=new CityService();
		List<City> list=service.selectAll(null);
		
		Set<Province> set=new HashSet<Province>();
		
		for(int i=0;i<list.size();i++){
			set.add(list.get(i).getProvince());
		}
		System.out.println(set.size());
		
	
		request.getSession().setAttribute("provinceSet", set);
		response.sendRedirect(request.getContextPath()+"/Admin/UserInfo_Add.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
