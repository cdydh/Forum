<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册成功</title>
</head>
<script type="text/javascript">  
            var time = 4;  
            function returnUrlByTime() {    
                window.setTimeout('returnUrlByTime()', 1000);    
                time = time - 1;    
                if(time<=0){  
                    time = 0;  
             window.setTimeout("location.href='${pageContext.request.contextPath}/login.jsp';", 0);   
                }  
                document.getElementById("layer").innerHTML = time;    
            }    
        </script> 
<body   onload="returnUrlByTime()">

 <div >
<font >注册成功！<br><b><span id="layer">3</span></b>秒后会自动跳转，如果没有跳转，请点下方返回登录页面...</font></div> 
<form action="login.jsp">
<br>
<input type="submit" value="返回登录页面">
</form>
</body>
</html>