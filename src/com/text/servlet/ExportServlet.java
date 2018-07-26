package com.text.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.text.entity.User;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * Servlet implementation class ExportServlet
 */
@WebServlet("/exportServlet")
public class ExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//设置响应报头信息
			response.setHeader("Content-disposition", "attachment; filename="+ new String("乘客信息".getBytes("GB2312"),"8859_1")+".xls");
			response.setHeader("pragma", "no-cache");
			response.setContentType("application/msexcel");
			//输出流
			ServletOutputStream sos=response.getOutputStream();
			
			//1、创建一个可写的xls文件
			WritableWorkbook workbook=Workbook.createWorkbook(sos);
			
			//2、创建表单sheet
			WritableSheet ws=workbook.createSheet("乘客信息表", 0);
			
			//3.写入值
			//3.1字符串格式化
			WritableFont font=new WritableFont(WritableFont.TIMES,16,WritableFont.BOLD);
			WritableCellFormat format=new WritableCellFormat(font);
			Label cell=new Label(0,0,"导出乘客列表",format);
			ws.addCell(cell);
			
			//合并单元格
			ws.mergeCells(0, 0, 7, 0);
			
			//设置行高
			ws.setRowView(0, 800);
			
			//设置列宽
			ws.setColumnView(0, 30);
			
			//添加导出的表头-------------------
			ws.addCell(new Label(0,1,"姓名"));
			ws.addCell(new Label(1,1,"性别"));
			ws.addCell(new Label(2,1,"证件类型"));
			ws.addCell(new Label(3,1,"证件号码"));
			ws.addCell(new Label(4,1,"旅客类型"));
			
			//添加导出的数据
			List<User> list=(List<User>) request.getSession().getAttribute("userList");
			
			for(int i=0;i<list.size();i++){
				
				User user=list.get(i);
				
				int k=0;
				
				ws.addCell(new Label(k++,i+2,user.getUsername()));
				ws.addCell(new Label(k++,i+2,user.getSex()));
				ws.addCell(new Label(k++,i+2,user.getCertType().getContent()));
				ws.addCell(new Label(k++,i+2,user.getCert()));
				ws.addCell(new Label(k++,i+2,user.getUserType().getContent()));
			}
			
			//4、写入xls，并关闭资源
			workbook.write();
			workbook.close();
			
		
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
