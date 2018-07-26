package com.text.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.text.service.ProvinceService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProvinceService service=new ProvinceService();
		
		List<Province> list=service.selectAll(null);
		request.getSession().setAttribute("provinceList", list);
		
		response.sendRedirect(request.getContextPath()+"/UserRegistration.jsp");
	}
	
	/**
	 * 响应json格式字符串
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String provid=request.getParameter("provinceId");
		
		System.out.println("provid:"+provid);
		
		Province province=new Province();
		province.setProvinceId(provid);
		City city=new City();
		city.setProvince(province);
		CityService service=new CityService();
		List<City> cityList=service.selectAll(city);
		
		JSONArray json=JSONArray.fromObject(cityList);//数组
//		JSONObject obj=JSONObject.fromObject(object);一个对象
		System.out.println(json);
		response.setContentType("application/json;charset=utf-8");
		
		PrintWriter pw=response.getWriter();
		
		pw.write(json.toString());
		
		pw.flush();
		pw.close();
	
	}
	/**
	 * 响应xml格式的字符串
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost_xml(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String provid=request.getParameter("provinceId");
		
		System.out.println("provid:"+provid);
		
		Province province=new Province();
		province.setProvinceId(provid);
		City city=new City();
		city.setProvince(province);
		CityService service=new CityService();
		List<City> cityList=service.selectAll(city);
		
		StringBuffer xml=new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
		xml.append("<cities>");
		for (City c : cityList) {
			xml.append("<city>");
			xml.append("<cid>"+c.getId()+"</cid>");
			xml.append("<cname>"+c.getCity()+"</cname>");
			xml.append("</city>");
		}
		
		xml.append("</cities>");
		System.out.println(xml);
		response.setContentType("text/xml;charset=utf-8");
		
		PrintWriter pw=response.getWriter();
		
		pw.write(xml.toString());
		pw.flush();
		pw.close();
	}

}
