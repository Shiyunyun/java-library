package com.text.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.text.entity.User;
import com.text.service.UserService;

/**
 * Servlet implementation class UserUpload
 */
@WebServlet("/userUpload")
public class UserUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session=request.getSession();
			
			User user=(User) session.getAttribute("user");
			String userName=user.getUsername();
			
			String userType=null;
			String content=null;
			String imagePath=null;
			if(ServletFileUpload.isMultipartContent(request)){
				DiskFileItemFactory factory=new DiskFileItemFactory();
				
				ServletFileUpload upload=new ServletFileUpload(factory);
				upload.setSizeMax(10*1024*1024);
				upload.setHeaderEncoding("utf-8");
				
				List<FileItem> fileItemList=upload.parseRequest(request);
				
				for (FileItem fileItem : fileItemList) {
					if(fileItem.isFormField()){
						String name=fileItem.getFieldName();
						
						String value=fileItem.getString();
						
						System.out.println(name+"   "+value);
						
						if("passenger_type".equals(name)){
							userType=value;
						}
						if("textarea".equals(content)){
							content=value;
						}
						
					}else{
						
						String fileName=fileItem.getName();
						if(fileName.lastIndexOf("\\")>=0){
							fileName=fileName.substring(fileName.lastIndexOf("\\")).substring(1);
						}
						System.out.println("源文件名称：" + fileName);//Desert.jpg
						
						//扩展名
						String suffix = fileName.substring(fileName.lastIndexOf('.'));
						System.out.println("扩展名：" + suffix);
						
						//新文件名字
						String newFileName = new Date().getTime() + suffix;
						System.out.println("新文件名称：" + newFileName);
						
						//5. 调用FileItem的write()方法，写入文件
						File file = new File(request.getServletContext().getRealPath("upload")+"\\"+newFileName);
						fileItem.write(file);
						
						imagePath="upload/"+newFileName;
						
						System.out.println(file.getAbsolutePath());
						
						//6. 调用FileItem的delete()方法，删除临时文件
						fileItem.delete();
						
						System.out.println("上传成功");
						
						session.setAttribute("fileName", fileName);
						session.setAttribute("imagePath", imagePath);
						
					}
				}
				
			}
			
		
			
			
			
			User u=new User();
			u.setUsername(userName);
			u.setUser_type(Integer.valueOf(userType));
			u.setContent(content);
			u.setImage_path(imagePath);
			
			UserService service=UserService.getInstance();
			
			boolean result=service.updateUser(u);
			System.out.println(true);
			if(result){
				response.sendRedirect(request.getContextPath()+"/User/Index.jsp");
			}else{
				response.sendRedirect(request.getContextPath()+"/User/UserManageInfo_Edit.jsp");
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
