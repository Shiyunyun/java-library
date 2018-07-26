<%@page import="com.text.entity.User"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>12306购票系统</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
</style>
<script language="javascript">
	function UserRegistration(){
	
	
	window.location.href="provinceServlet";
	
	}
</script>
<script language="javascript">
	/*  function UserLogin(){
	
	
   window.location.href ="Admin/Index.html";
	
	}   */
	function changeCode(){
		code.src="validateCodeServlet?date="+(new Date()).getMilliseconds();
	}
	
</script>
<style type="text/css">
<!--
body {
	background-image: url(images/bg_point.gif);
}
-->
</style></head>

<%
	
	/* String userName=null;
	String password=null;

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
	}
	
	//如果只有验证错误，用户名与密码保留原来的值
	if(session.getAttribute("code")!=null){
		
		String serviceCode=(String)session.getAttribute("code");//服务器验证码
		String userCode=(String)session.getAttribute("userCode");//客户输入的验证码
		User user=(User)session.getAttribute("user");
		if(user!=null){
			if(!serviceCode.equals(userCode)){
				userName=user.getUsername();
				password=(String)session.getAttribute("passwd");
			}
			
		}
		
	} */

%>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
 <form name="form1"  action="LoginServlet" method="post">
   <table width="933" border="0" align="center" cellpadding="0" cellspacing="0" style="margin:120px;">
  <tr>
    <td height="412" valign="top" background="images/bg_img1.jpg"><table height="300" border="0" cellspacing="0">
      <tr>
        <td width="538">&nbsp;</td>
        <td height="130" colspan="6">&nbsp;</td>
        </tr>
      <tr>
        <td rowspan="9">&nbsp;</td>
        <td width="98" height="20" align="right"><img src="images/text_yh.gif" width="60" height="18"></td>
        <td width="16">&nbsp;</td>
        <td width="136"><input name="textfield" type="text" id="textfield" size="18" value='${user.username }' /></td>
        <td width="55">&nbsp;</td>
        <td width="44">&nbsp;</td>
        <td width="32">&nbsp;</td>
      </tr>
      <tr>
        <td height="20" align="right">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="20" align="right"><img src="images/text_password.gif" width="60" height="18"></td>
        <td>&nbsp;</td>
        <td><input name="textfield2" type="text" id="textfield2" size="18" value='${user.password }'/></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="20" align="right">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="20" align="right"><img src="images/text_yzm.gif" width="60" height="18"></td>
        <td>&nbsp;</td>
        <td><input name="textfield3" type="text" id="textfield3" size="18" /></td>
        <td><span class="text_cray1"><img id="code" src="validateCodeServlet" alt="点击换验证码" height="20" style="cursor: pointer;" onclick="changeCode()"/></span></td>
        <td><img src="images/text_sx.gif" width="32" height="18" onclick="changeCode()"></td>
        <td align="left">&nbsp;</td>
      </tr>
      <tr>
        <td height="30">&nbsp;</td>
        <td>&nbsp;</td>
        <td valign="bottom"><table width="100%" border="0" cellspacing="0">
          <tr>
            <td width="26" align="left"><input name="checkbox" type="checkbox" value="loginauto" style=" margin:0 auto;"/></td>
            <td width="170"><img src="images/text_zddl.gif" width="60" height="18"></td>
          </tr>
        </table></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="20">&nbsp;</td>
        <td>&nbsp;</td>
        <td colspan="2">
        	<%=!"".equals(request.getAttribute("title")) && request.getAttribute("title")!=null?request.getAttribute("title"):"" %>
        </td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="20">&nbsp;</td>
        <td>&nbsp;</td>
        <td colspan="2"><table width="200" border="0" cellspacing="0">
          <tr>
            <td width="78"><input name="button"  type="submit"  class="butlogin" id="button" value="" ></td>
            <td>&nbsp;</td>
            <td width="78"><input name="button2"  type="button"  class="butzc" id="button2"value="" onClick="UserRegistration()"></td>
          </tr>
        </table></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="20">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
 </form>
</body>
</html>
