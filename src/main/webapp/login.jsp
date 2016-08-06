<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>

<style type="text/css">
body{
	color:#000;
	font-size: 14px;
	margin: 20px auto;
}
</style>

<script type="text/javascript">
	function check(form){
		if(document.forms.loginForm.uname.value==""){
			alert("请输入用户名！");
			document.forms.loginForm.uname.focus();
			return false;
		}
		
	
	}
</script>

</head>
<body>
	<form action="<%= request.getContextPath() %>/loginServlet" method="post" name="loginForm">
		<table border="1" cellspacing="1" cellpadding="5" bordercolor="silver" align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="#E8E8E8">用户登录</td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="uname">
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" name="submit" onclick="return check(this);"/>
					<input type="reset" name="reset">
				</td>
			</tr>		
		</table>
	</form>
</body>
</html>