<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册信息</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form action="ResgisterServlet" method="get">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="2" background="images/ny_top_img_bg.gif"><img src="images/ny_top_img.gif" width="650" height="108"></td>
    </tr>
  <tr>
    <td width="75" height="23" bgcolor="#deedf8">&nbsp;</td>
    <td width="958" align="left" bgcolor="#deedf8" class="text_cray1">当前位置:注册信息　</td>
    </tr>
</table>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="images/bg_point_write.gif"><table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="30" colspan="2" align="center">&nbsp;</td>
        </tr>
      <tr>
        <td width="41" height="7" align="center">&nbsp;</td>
        <td width="794" height="30" align="left" valign="top"><span class="text_blod_title">注册信息</span></td>
      </tr>
      <tr>
        <td height="15" colspan="2" align="center"><img src="images/line1.jpg" width="835" height="6"></td>
      </tr>
      <tr>
        <td colspan="2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="5%">&nbsp;</td>
            <td width="95%" align="left" class="text_cray">注：标有 <span class="text_red">*</span> 处，均为必填项</td>
          </tr>
          <tr>
            <td height="15" colspan="2">&nbsp;</td>
            </tr>
          
        </table>
          <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="30" colspan="4" align="left" class="text_red1"><span class="text_title">登录信息</span></td>
                </tr>
          
          <tr>
            <td width="19" align="center" class="text_red">*</td>
                  <td width="98" height="40" align="left" class="text_cray1">登录名：</td>
                  <td width="160" align="left" class="text_cray1"><input name="textfield2" type="text" class="text_cray" id="textfield2" onblur="nameCheck()"/></td>
                  <td width="423" height="35" align="left" class="text_cray" id="txt">由字母、数字或“_”组成，长度不少于6位，不多于30位</td>
                </tr>
          <tr>
            <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">密码：</td>
                  <td align="left" class="text_cray1"><input name="textfield3" type="text" class="text_cray" id="textfield3" /></td>
                  <td height="35" align="left" class="text_cray" >不少于6位字符</td>
                </tr>
          <tr>
            <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">确认密码：</td>
                  <td align="left" class="text_cray1"><input name="textfield4" type="password" class="text_cray" id="textfield4" /></td>
                  <td height="35" align="left" class="text_cray">请再次输入密码</td>
                </tr>
        </table>
          <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td height="35" colspan="5" align="left" class="text_red1"><span class="text_title">详细信息</span></td>
                </tr>
            
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">真实姓名：</td>
                  <td height="35" colspan="3" align="left"><input name="textfield8" type="text" class="text_cray" id="textfield8" /></td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">性 别：</td>
                  <td height="35" colspan="3" align="left" class="text_cray1">
                    <span class="mr25">
                    <input type="radio" name="userDTO.sex_code" value="M" checked="checked" />
                    </span>
                    <span class="text_cray">
                    <label>男</label>
                    <input type="radio" name="userDTO.sex_code" value="F" />
                    <label>女</label>
                    </span>
                    <label></label>
                    <span><label></label>
                  </span>				</td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">省份：</td>
                  <td width="104" height="35" align="left"><label>
                    <select name="province" class="text_cray" id="province" onchange="provChange()">
                      <option value="省份" selected="selected" >省份</option>
                      <c:forEach items="${provinceList }" var="province">
                      		<option value="${province.provinceId }">${province.province }</option>
                      </c:forEach>
                    </select>
                  </label></td>
                  <td width="43" height="35" align="left"  class="text_cray">城市：</td>
                  <td width="436" height="35" align="left" class="text_cray"><label>
                    <select name="city" class="text_cray" id="city">
                      <option value="城市" selected="selected">市县</option>
                    </select>
                  </label></td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">证件类型：</td>
                  <td height="35" colspan="3" align="left">
                    <select class="text_cray" name="loginUserDTO.id_type_code" id="cardType">
                      <option value="1"><span>二代身份证</span>				</option>
                      <option value="2"><span>港澳通行证</span>				</option>
                      <option value="3"><span>台湾通行证</span>				</option>
                      <option value="4"><span>护照</span>				</option>
                  </select>				</td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">证件号码：</td>
                  <td height="35" colspan="3" align="left"><input name="textfield6" type="text" class="text_cray" id="textfield6" /></td>
                </tr>
            <tr>
              <td width="19" align="center" class="text_red1"><span class="text_red">*</span></td>
                  <td width="98" height="40" align="left" class="text_cray1">出生日期：</td>
                  <td height="35" colspan="3" align="left"><input name="textfield7" type="text" class="text_cray" id="textfield7" /></td>
                </tr>
            
            <tr>
              <td width="19" align="center">&nbsp;</td>
                  <td width="98" height="40" align="left" class="text_cray1">旅客类型：</td>
                  <td height="35" colspan="3" align="left">
                    <select class="text_cray" id="passengerType" name="passenger_type"><option value="1">成人</option>
                      <option value="2">儿童</option>
                      <option value="3">学生</option>
                      <option value="4">残疾军人、伤残人民警察</option>
                  </select>				</td>
                </tr>
            <tr>
              <td height="10" colspan="5" align="center">	</td>
	            </tr>
            
            
            
            
            
            
            <tr>
              <td width="19" align="center">&nbsp;</td>
                  <td width="98" height="30" align="left" class="text_cray1">备注：</td>
                  <td colspan="3" align="left" height="80">
                  <textarea name="textarea" rows="8" class="text_cray" style="width:100%"></textarea>				</td>
                </tr>
            
            
            
            <tr>
              <td align="center">&nbsp;</td>
                  <td height="30" align="left" class="text_cray1"></td>
                  <td height="50" colspan="3" align="left" valign="middle" class="text_cray1">
                  <input type="checkbox" class="check" id="checkAgree" /> 
                  我已阅读并同意遵守				<a href="/otn/regist/rule;jsessionid=FA97B306AACF75E37DD4D10CFD59994A" class="ft14" target="_blank" shape="rect"> 《中国铁路客户服务中心网站服务条款》</a></td>
                </tr>
          </table> <br>        
          <table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="234">&nbsp;</td>
                  <td width="147" height="30" align="center"><input name="button3" type="submit" class="buttj" id="button3" value=""></td>
                  <td width="141" align="center">&nbsp;</td>
                  <td width="147" align="center"><input name="button4" type="submit" class="butcz" id="button4" value=""></td>
                  <td width="166" align="center">&nbsp;</td>
                </tr>
              </table></td>
      </tr>
      </table></td>
  </tr>
</table><br>

<table width="100%" border="0" cellspacing="0">
<tr>
    <td height="2" background="images/bottom_point.gif"></td>
  </tr>
  <tr>
    <td height="25" align="center" background="images/bottom_ny_bg.gif" class="text_cray">copyright@12306 购票网</td>
  </tr>
</table>
</form>

<!-- <script type="text/JavaScript" src="js/common.js"></script> -->
<script type="text/JavaScript">
	
	var xmlHttpRequest=false;
     function nameCheck(){
    	 
    	 	var reg=/^[0-9a-zA-Z_]{6,30}/;
    	 	var name=textfield2.value;
    	 	if(name.match(reg)){
    	 		textfield2.value=name;
    	 	}else{
    	 		textfield2.value="请输入正确格式";
    	 	} 
    	 	
			//非IE浏览器
    		if(window.XMLHttpRequest){
    			
    			xmlHttpRequest=new XMLHttpRequest();
    		}else if(window.ActionXObject){
    			//IE浏览器
    			xmlHttpRequest=new ActionXObject();
    		}
    		
    		if(xmlHttpRequest){
    		/* 	
    			Get请求
    			 */
    		//获取参数
    		var userName=textfield2.value;
			
    		//2、定义url连接
    		var url="checkServlet?userName="+userName;
    		
    		//3、打开服务器的连接
    		xmlHttpRequest.open("get",url,true);
    		
    		//4、绑定回调函数
    		xmlHttpRequest.onreadystatechange=callback;
    		
    		//5、发送请求
    		xmlHttpRequest.send(null);
    			 
    		}else{
    			alert("创建对象失败");
    		}	
        		
        	
        } 
       	
 	
 	function callback(){
 		
 		if(xmlHttpRequest.readyState==4){//响应完成，可以获取响应内容
 			
 			if(xmlHttpRequest.status==200){ //响应状态OK ，没有发生异常
 				

 				var response=xmlHttpRequest.responseText;
 				
 				txt.innerHTML=response;
 			}
 		
 			
 		}
 	} 
 	
</script>
<script type="text/javascript">
	//jquery
	function provChange(){
		
		var provinceObj=document.getElementById("province");
		var provinceId=provinceObj.options[provinceObj.selectedIndex].value;
		
		$.ajax({
			
			type:"POST",
			url:"provinceServlet",
			data:"provinceId="+provinceId,
			
			success:function(cities){
				
				var cityObj=document.getElementById("city");
				
				cityObj.options.length=1;
				
				for(var i=0;i<cities.length;i++){
					
					var city=cities[i];
					
					var cid=city.id;
					var cname=city.city;
					
					cityObj.options[cityObj.options.length]=new Option(cname,cid);
				}
			}
			
		});
	}
	
	//原生写法
	var xmlHttpRequest=false;
	
	function provChang(){
		
		if(window.XMLHttpRequest){
			xmlHttpRequest=new XMLHttpRequest();
		}else if(window.ActionXObject){
			xmlHttpRequest=new ActionXObject();
		}
		
		if(xmlHttpRequest){
			
			var provinceObj=document.getElementById("province");//省下拉列表的对象
			var provinceId=provinceObj.options[provinceObj.selectedIndex].value;//选中的省编号
			
			var url="provinceServlet";
			xmlHttpRequest.open("post",url,true);
			
			xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			
			//xmlHttpRequest.onreadystatechange = callback_xml;
			  xmlHttpRequest.onreadystatechange=callback_json;
			
			xmlHttpRequest.send("provinceId="+provinceId);

			
		}else{
			
			alert("创建对象失败")
		}
	}
	
      function callback_json(){
		
		if(xmlHttpRequest.readyState==4){
			
			if(xmlHttpRequest.status==200){
				
				var response=xmlHttpRequest.responseText;
				
				//将字符串--->对象
				var cities=eval(response);
				
				var cityObj=document.getElementById("city");
				
				cityObj.options.length=1;
				
				for(var i=0;i<cities.length;i++){
					
					var city=cities[i];
					
					var cid=city.id;
					var cname=city.city;
					
					cityObj.options[cityObj.options.length]=new Option(cname,cid);
				}
				
			}
			
		}
	}
	
	
	function callback_xml(){
		
		if(xmlHttpRequest.readyState==4){
			
			if(xmlHttpRequest.status==200){
				
				var response=xmlHttpRequest.responseXML;
				
				
				var cityRoot=response.documentElement;
				
				var cities=cityRoot.getElementsByTagName("city");
				
				var cityObj=document.getElementById("city");
				
				cityObj.options.length=1;
				for(var i=0;i<cities.length;i++){

					var city=cities[i];
					
					var cid=city.childNodes[0].firstChild.nodeValue;
					var cname=city.childNodes[1].firstChild.nodeValue;
					
					
					cityObj.options[cityObj.options.length]=new Option(cname,cid);
					
				}
			}
			
		}
	}
	
	
</script>
</body>
</html>